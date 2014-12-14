package com.nj.search.processor;


import com.nj.search.utils.CsvDataStore;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CsvDataProcessor {

    private Logger logger = LoggerFactory.getLogger(CsvDataProcessor.class);

    @Autowired
    private CsvDataStore dataStore;

    public void handleCsvData(Exchange ex){

        Message m = ex.getIn();
        //logger.info(m.getHeaders().toString());

//        if(ex.getIn().getBody().getClass().isAssignableFrom(Vehicle.class)){
//            dataStore.addVehicle(ex.getIn().getBody(Vehicle.class));
//        } else if(ex.getIn().getBody().getClass().isAssignableFrom(Accident.class)){
//            dataStore.addAccident(ex.getIn().getBody(Accident.class));
//        } else if(ex.getIn().getBody().getClass().isAssignableFrom(Casualty.class)){
//            dataStore.addCasualty(ex.getIn().getBody(Casualty.class));
//        }
    }
}
