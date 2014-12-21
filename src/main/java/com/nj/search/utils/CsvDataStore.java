package com.nj.search.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nj.search.accident.Accident;
import com.nj.search.casualty.Casualty;
import com.nj.search.makemodel.MakeModel;
import com.nj.search.mapping.RefDataMgr;
import com.nj.search.vehicle.Vehicle;
import org.apache.camel.Exchange;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CsvDataStore {
    public static final String ACCIDENTS = "Acc";
    public static final String CASUALTIES = "Casualty";
    public static final String VEHICLES = "Vehicle";

    private Logger logger = LoggerFactory.getLogger(CsvDataStore.class);

    private volatile Map<String, Accident> accidents = new ConcurrentHashMap<String, Accident>();
    private volatile List<Accident> accidentsFullData = new ArrayList<Accident>();
    private volatile Map<String, List<Casualty>> casualties = new ConcurrentHashMap<String, List<Casualty>>();
    private volatile Map<String, List<Vehicle>> vehicles = new ConcurrentHashMap<String, List<Vehicle>>();
    private volatile Map<String, List<MakeModel>> makemodels = new ConcurrentHashMap<String, List<MakeModel>>();


    private volatile List<String> accidentIdList = new ArrayList<String>();
    private volatile Map<String, Integer> accidentIdCompletedList = new ConcurrentHashMap<String, Integer>();

    private ObjectMapper mapper = new ObjectMapper();


    public void addVehicle(Exchange ex) {

        ArrayList<Vehicle> vList = (ArrayList<Vehicle>) ex.getIn().getBody(List.class);

        for (Vehicle v : vList) {
            String accidentId = v.getAcc_Index();

            if (!vehicles.containsKey(accidentId)) {
                List<Vehicle> arr = new ArrayList<Vehicle>();
                arr.add(v);
                vehicles.put(accidentId, arr);
            } else {
                vehicles.get(accidentId).add(v);
            }
        }
    }

    public void purgeDoneVehicles(Exchange ex){
        for(String accidentId : accidentIdCompletedList.keySet()){
            if(vehicles.containsKey(accidentId)){
                vehicles.remove(accidentId);
            }
        }
    }

    public void addCasualty(Exchange ex){

        ArrayList<Casualty> cList = (ArrayList<Casualty>) ex.getIn().getBody(List.class);

        for(Casualty c : cList) {
            String accidentId = c.getAcc_Index();

            if (!casualties.containsKey(accidentId)) {
                List<Casualty> arr = new ArrayList<Casualty>();
                arr.add(c);
                casualties.put(accidentId, arr);
            } else {
                casualties.get(accidentId).add(c);
            }
        }
    }

    public void purgeDoneCasualties(Exchange ex) {
        for (String accidentId : accidentIdCompletedList.keySet()) {
            if (casualties.containsKey(accidentId)) {
                casualties.remove(accidentId);
            }
        }
    }

    public void addAccident(Exchange ex) throws FileNotFoundException {

        ArrayList<Accident> aList = (ArrayList<Accident>) ex.getIn().getBody(List.class);

        for(Accident a : aList) {
            //Skip if it looks like first line of csv file, i.e. the header
            if (a.getDay_of_Week().matches("^\\d$")) {
                a.enrichData();
                accidents.put(a.getAccident_Index(), a);
            }
        }
    }

    public void purgeDoneAccidents(Exchange ex) {
        for (String accidentId : accidentIdCompletedList.keySet()) {
            if (accidents.containsKey(accidentId)) {
                accidents.remove(accidentId);
            }
        }
    }

    public void addMakeModel(Exchange ex){

        ArrayList<MakeModel> mList = (ArrayList<MakeModel>) ex.getIn().getBody(List.class);

        for(MakeModel m : mList) {
            String accidentId = m.getAcc_Index();

            if (!makemodels.containsKey(accidentId)) {
                List<MakeModel> arr = new ArrayList<MakeModel>();
                arr.add(m);
                makemodels.put(accidentId, arr);
            } else {
                makemodels.get(accidentId).add(m);
            }
        }
    }

    public void purgeDoneMakeModels(Exchange ex) {
        //List<String> copyAccidentsIdCompletedList = new ArrayList<String>(accidentIdCompletedList);
        for (String accidentId : accidentIdCompletedList.keySet()) {
            if (makemodels.containsKey(accidentId)) {
                makemodels.remove(accidentId);
            }
        }
    }

    // This method will combine and purge only complete data sets from store
    public void combineAndPurge() throws JsonProcessingException {
        //logger.info("Trying to combine Accidents, Vehicle and Casualty records");

        //logger.warn("WARN accidentIdList size={}", accidentIdList.size());
        List<String> copyAccidentIdList = new ArrayList<String>(accidents.keySet());
        Iterator<String> iterator = copyAccidentIdList.iterator();
        while(iterator.hasNext()){

            String accidentId = iterator.next();

            //No need to evaluate this accidentId if its already completed
//            if(accidentIdCompletedList.containsKey(accidentId)){
//                continue;
//            }

                if(casualties.containsKey(accidentId) && vehicles.containsKey(accidentId))
                {
                    logger.info("Combining Accident Id: {}", accidentId);

                    Accident a = accidents.get(accidentId);


                    if(casualties.get(accidentId).size() == a.getNumber_of_Casualties() &&
                            vehicles.get(accidentId).size() == a.getNumber_of_Vehicles()) {
                    boolean infoComplete = false;
                    if(accidentId.matches("^20(10|11|12|13)") && makemodels.get(accidentId).size() == a.getNumber_of_Vehicles()){
                        infoComplete = true;
                    } else if (! accidentId.matches("^20(10|11|12|13)")) {
                        infoComplete = true;
                    }

                    if (infoComplete) {

                        //Add Casualties and remove from memory
                        a.getCasualtyList().addAll(casualties.remove(accidentId));

                        //Enrich vehicle data with make model if present
                        if(accidentId.matches("^20(10|11|12|13)")) {
                            for (Vehicle v : vehicles.get(accidentId)) {
                                for (MakeModel m : makemodels.get(accidentId)) {
                                    if (v.getVehicle_Reference().equals(m.getVehicle_Reference())) {
                                        v.setMake(m.getMake());
                                        v.setModel(m.getModel());
                                    }
                                }
                            }
                        }

                        // Remove from make models
                        if(makemodels.containsKey(accidentId)){
                            makemodels.remove(accidentId);
                        }

                        //Add Vehicles and remove from map
                        a.getVehicleList().addAll(vehicles.remove(accidentId));

                        //Remove accidentId key and add to full list
                        //iterator.remove();

                        // Do something with this data, send to ES
                        //logger.info(a.toString());

                        JsonNode json = mapper.valueToTree(a);
                        logger.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json));

                        // Remove accident
                        accidents.remove(accidentId);
                        //accidentsFullData.add(accidents.remove(accidentId));

                        //Record completion of this accidentId
                        accidentIdCompletedList.put(accidentId, 1);
                    }
                } else {
                    logger.warn("WARN accidentID:{}. casualties.get(accidentId).size()={} NOTEQUAL a.getNumber_of_Casualties()={},\n" +
                                    " vehicles.get(accidentId).size()={} NOTEQUAL a.getNumber_of_Vehicles()={}",
                            accidentId,
                            casualties.get(accidentId).size(), a.getNumber_of_Casualties(),
                                    vehicles.get(accidentId).size(), a.getNumber_of_Vehicles()
                            );
                }
            } else {
                    logger.warn("WARN casualties or vehicles do not contain accidentId:{}", accidentId);
            }
        }
    }

    public void sendDataToES() throws JsonProcessingException {
        for(Accident a: accidentsFullData){
            JsonNode j = mapper.valueToTree(a);
            logger.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(j));
        }
    }


    public Map<String, Accident> getAccidents() {
        return accidents;
    }

    public List<Accident> getAccidentsFullData() {
        return accidentsFullData;
    }

    public Map<String, List<Casualty>> getCasualties() {
        return casualties;
    }

    public Map<String, List<Vehicle>> getVehicles() {
        return vehicles;
    }

    public Map<String, List<MakeModel>> getMakemodels() {
        return makemodels;
    }

    public List<String> getAccidentIdList() {
        return accidentIdList;
    }

    public Map<String, Integer> getAccidentIdCompletedList() {
        return accidentIdCompletedList;
    }
}
