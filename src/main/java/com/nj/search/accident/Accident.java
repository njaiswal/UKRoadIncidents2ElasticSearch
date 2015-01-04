package com.nj.search.accident;

import com.nj.search.casualty.Casualty;
import com.nj.search.mapping.RefDataMgr;
import com.nj.search.vehicle.Vehicle;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.Ref;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CsvRecord(separator = ",")
public class Accident {

    @DataField(pos = 1)
    private String Accident_Index;

    @DataField(pos = 2)
    private String Location_Easting_OSGR;

    @DataField(pos = 3)
    private String Location_Northing_OSGR;

    @DataField(pos = 4)
    private String Longitude;

    @DataField(pos = 5)
    private String Latitude;

    private BigDecimal[] accidentLocation;

    @DataField(pos = 6)
    private String Police_Force;

    @DataField(pos = 7)
    private String Accident_Severity;

    @DataField(pos = 8, defaultValue = "0")
    private String Number_of_Vehicles;

    @DataField(pos = 9, defaultValue = "0")
    private String Number_of_Casualties;

    @DataField(pos = 10)
    private String Date;

    @DataField(pos = 11)
    private String Day_of_Week;

    @DataField(pos = 12)
    private String Time;

    private String DateTime;

    @DataField(pos = 13)
    private String Local_Authority_District;

    @DataField(pos = 14)
    private String Local_Authority_Highway;

    @DataField(pos = 15)
    private String First_Road_Class;

    @DataField(pos = 16)
    private String First_Road_Number;

    @DataField(pos = 17)
    private String Road_Type;

    @DataField(pos = 18)
    private String Speed_limit;

    @DataField(pos = 19)
    private String Junction_Detail;

    @DataField(pos = 20)
    private String Junction_Control;

    @DataField(pos = 21)
    private String Second_Road_Class;

    @DataField(pos = 22)
    private String Second_Road_Number;

    @DataField(pos = 23)
    private String Pedestrian_Crossing_Human_Control;

    @DataField(pos = 24)
    private String Pedestrian_Crossing_Physical_Facilities;

    @DataField(pos = 25)
    private String Light_Conditions;

    @DataField(pos = 26)
    private String Weather_Conditions;

    @DataField(pos = 27)
    private String Road_Surface_Conditions;

    @DataField(pos = 28)
    private String Special_Conditions_at_Site;

    @DataField(pos = 29)
    private String Carriageway_Hazards;

    @DataField(pos = 30)
    private String Urban_or_Rural_Area;

    @DataField(pos = 31)
    private String Did_Police_Officer_Attend_Scene_of_Accident;

    @DataField(pos = 32)
    private String LSOA_of_Accident_Location;

    @DataField(pos = 33)
    private String DataType;

    private List<Vehicle> vehicleList = new ArrayList<Vehicle>();
    private List<Casualty> casualtyList = new ArrayList<Casualty>();

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public List<Casualty> getCasualtyList() {
        return casualtyList;
    }

    public void setCasualtyList(List<Casualty> casualtyList) {
        this.casualtyList = casualtyList;
    }

    public String getAccident_Index() {
        return Accident_Index;
    }

    public void setAccident_Index(String accident_Index) {
        Accident_Index = accident_Index;
    }

    public String getLocation_Easting_OSGR() {
        return Location_Easting_OSGR;
    }

    public void setLocation_Easting_OSGR(String location_Easting_OSGR) {
        Location_Easting_OSGR = location_Easting_OSGR;
    }

    public String getLocation_Northing_OSGR() {
        return Location_Northing_OSGR;
    }

    public void setLocation_Northing_OSGR(String location_Northing_OSGR) {
        Location_Northing_OSGR = location_Northing_OSGR;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getPolice_Force() {
        return Police_Force;
    }

    public void setPolice_Force(String police_Force) {
        Police_Force = police_Force;
    }

    public String getAccident_Severity() {
        return Accident_Severity;
    }

    public void setAccident_Severity(String accident_Severity) {
        Accident_Severity = accident_Severity;
    }

    public int getNumber_of_Vehicles() {
        return Integer.parseInt(Number_of_Vehicles);
    }

    public void setNumber_of_Vehicles(String number_of_Vehicles) {
        if(number_of_Vehicles.matches("\\d+")) {
            Number_of_Vehicles = number_of_Vehicles;
        } else {
            Number_of_Vehicles = "0";
        }
    }

    public int getNumber_of_Casualties() {
        return Integer.parseInt(Number_of_Casualties);
    }

    public void setNumber_of_Casualties(String number_of_Casualties) {
        if(number_of_Casualties.matches("\\d+")) {
            Number_of_Casualties = number_of_Casualties;
        } else {
            Number_of_Casualties = "0";
        }
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getDay_of_Week() {
        return Day_of_Week;
    }

    public void setDay_of_Week(String day_of_Week) {
        Day_of_Week = day_of_Week;
    }

    public String getTime() {
        if(this.Time == null){
            return "00:00";
        } else {
            return Time;
        }
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getLocal_Authority_District() {
        return Local_Authority_District;
    }

    public void setLocal_Authority_District(String local_Authority_District) {
        Local_Authority_District = local_Authority_District;
    }

    public String getLocal_Authority_Highway() {
        return Local_Authority_Highway;
    }

    public void setLocal_Authority_Highway(String local_Authority_Highway) {
        Local_Authority_Highway = local_Authority_Highway;
    }

    public String getFirst_Road_Class() {
        return First_Road_Class;
    }

    public void setFirst_Road_Class(String first_Road_Class) {
        First_Road_Class = first_Road_Class;
    }

    public String getFirst_Road_Number() {
        return First_Road_Number;
    }

    public void setFirst_Road_Number(String first_Road_Number) {
        First_Road_Number = first_Road_Number;
    }

    public String getRoad_Type() {
        return Road_Type;
    }

    public void setRoad_Type(String road_Type) {
        Road_Type = road_Type;
    }

    public String getSpeed_limit() {
        return Speed_limit;
    }

    public void setSpeed_limit(String speed_limit) {
        Speed_limit = speed_limit;
    }

    public String getJunction_Detail() {
        return Junction_Detail;
    }

    public void setJunction_Detail(String junction_Detail) {
        Junction_Detail = junction_Detail;
    }

    public String getJunction_Control() {
        return Junction_Control;
    }

    public void setJunction_Control(String junction_Control) {
        Junction_Control = junction_Control;
    }

    public String getSecond_Road_Class() {
        return Second_Road_Class;
    }

    public void setSecond_Road_Class(String second_Road_Class) {
        Second_Road_Class = second_Road_Class;
    }

    public String getSecond_Road_Number() {
        return Second_Road_Number;
    }

    public void setSecond_Road_Number(String second_Road_Number) {
        Second_Road_Number = second_Road_Number;
    }

    public String getPedestrian_Crossing_Human_Control() {
        return Pedestrian_Crossing_Human_Control;
    }

    public void setPedestrian_Crossing_Human_Control(String pedestrian_Crossing_Human_Control) {
        Pedestrian_Crossing_Human_Control = pedestrian_Crossing_Human_Control;
    }

    public String getPedestrian_Crossing_Physical_Facilities() {
        return Pedestrian_Crossing_Physical_Facilities;
    }

    public void setPedestrian_Crossing_Physical_Facilities(String pedestrian_Crossing_Physical_Facilities) {
        Pedestrian_Crossing_Physical_Facilities = pedestrian_Crossing_Physical_Facilities;
    }

    public String getLight_Conditions() {
        return Light_Conditions;
    }

    public void setLight_Conditions(String light_Conditions) {
        Light_Conditions = light_Conditions;
    }

    public String getWeather_Conditions() {
        return Weather_Conditions;
    }

    public void setWeather_Conditions(String weather_Conditions) {
        Weather_Conditions = weather_Conditions;
    }

    public String getRoad_Surface_Conditions() {
        return Road_Surface_Conditions;
    }

    public void setRoad_Surface_Conditions(String road_Surface_Conditions) {
        Road_Surface_Conditions = road_Surface_Conditions;
    }

    public String getSpecial_Conditions_at_Site() {
        return Special_Conditions_at_Site;
    }

    public void setSpecial_Conditions_at_Site(String special_Conditions_at_Site) {
        Special_Conditions_at_Site = special_Conditions_at_Site;
    }

    public String getCarriageway_Hazards() {
        return Carriageway_Hazards;
    }

    public void setCarriageway_Hazards(String carriageway_Hazards) {
        Carriageway_Hazards = carriageway_Hazards;
    }

    public String getUrban_or_Rural_Area() {
        return Urban_or_Rural_Area;
    }

    public void setUrban_or_Rural_Area(String urban_or_Rural_Area) {
        Urban_or_Rural_Area = urban_or_Rural_Area;
    }

    public String getDid_Police_Officer_Attend_Scene_of_Accident() {
        return Did_Police_Officer_Attend_Scene_of_Accident;
    }

    public void setDid_Police_Officer_Attend_Scene_of_Accident(String did_Police_Officer_Attend_Scene_of_Accident) {
        Did_Police_Officer_Attend_Scene_of_Accident = did_Police_Officer_Attend_Scene_of_Accident;
    }

    public String getLSOA_of_Accident_Location() {
        return LSOA_of_Accident_Location;
    }

    public void setLSOA_of_Accident_Location(String LSOA_of_Accident_Location) {
        this.LSOA_of_Accident_Location = LSOA_of_Accident_Location;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public BigDecimal[] getAccidentLocation() {
        return accidentLocation;
    }

    public void setAccidentLocation(BigDecimal[] accidentLocation) {
        this.accidentLocation = accidentLocation;
    }

    public void enrichData() throws FileNotFoundException {
        RefDataMgr refDataMgr = RefDataMgr.getInstance();
        this.DateTime = this.getDate() + " " + this.getTime();

        if(this.getLatitude() != null || this.getLongitude() != null) {
            this.accidentLocation = new BigDecimal[2];
            this.accidentLocation[0] = new BigDecimal(this.getLongitude()).setScale(6);
            this.accidentLocation[1] = new BigDecimal(this.getLatitude()).setScale(6);
        } else {
            this.accidentLocation = new BigDecimal[2];
            this.accidentLocation[0] = new BigDecimal(0).setScale(6);
            this.accidentLocation[1] = new BigDecimal(0).setScale(6);
        }

        this.Day_of_Week = refDataMgr.data().Day_Of_Week.get(Integer.parseInt(this.Day_of_Week));
        this.Road_Type = refDataMgr.data().Road_Type.get(Integer.parseInt(this.Road_Type));
        this.Junction_Detail = refDataMgr.data().Junction_Detail.get(Integer.parseInt(this.Junction_Detail));
        this.Junction_Control = refDataMgr.data().Junction_Control.get(Integer.parseInt(this.Junction_Control));
        this.Pedestrian_Crossing_Human_Control = refDataMgr.data().Pedestrian_Crossing_Human_Control.get(Integer.parseInt(this.Pedestrian_Crossing_Human_Control));
        this.Pedestrian_Crossing_Physical_Facilities = refDataMgr.data().Pedestrian_Crossing_Physical_Facilities.get(Integer.parseInt(this.Pedestrian_Crossing_Physical_Facilities));
        this.Light_Conditions = refDataMgr.data().Light_Conditions.get(Integer.parseInt(this.Light_Conditions));
        this.Weather_Conditions = refDataMgr.data().Weather_Conditions.get(Integer.parseInt(this.Weather_Conditions));
        this.Road_Surface_Conditions = refDataMgr.data().Road_Surface_Conditions.get(Integer.parseInt(this.Road_Surface_Conditions));
        this.Special_Conditions_at_Site = refDataMgr.data().Special_Conditions_at_Site.get(Integer.parseInt(this.Special_Conditions_at_Site));
        this.Carriageway_Hazards = refDataMgr.data().Carriageway_Hazards.get(Integer.parseInt(this.Carriageway_Hazards));
        this.Did_Police_Officer_Attend_Scene_of_Accident = refDataMgr.data().Did_Police_Officer_Attend_Scene_of_Accident.get(Integer.parseInt(this.Did_Police_Officer_Attend_Scene_of_Accident));
    }

    @Override
    public String toString() {
        return "Accident{" +
                "Accident_Index='" + Accident_Index + '\'' +
                ", Location_Easting_OSGR='" + Location_Easting_OSGR + '\'' +
                ", Location_Northing_OSGR='" + Location_Northing_OSGR + '\'' +
                ", Longitude='" + Longitude + '\'' +
                ", Latitude='" + Latitude + '\'' +
                ", Police_Force='" + Police_Force + '\'' +
                ", Accident_Severity='" + Accident_Severity + '\'' +
                ", Number_of_Vehicles='" + Number_of_Vehicles + '\'' +
                ", Number_of_Casualties='" + Number_of_Casualties + '\'' +
                ", Date='" + Date + '\'' +
                ", Day_of_Week='" + Day_of_Week + '\'' +
                ", Time='" + Time + '\'' +
                ", Local_Authority_District='" + Local_Authority_District + '\'' +
                ", Local_Authority_Highway='" + Local_Authority_Highway + '\'' +
                ", First_Road_Class='" + First_Road_Class + '\'' +
                ", First_Road_Number='" + First_Road_Number + '\'' +
                ", Road_Type='" + Road_Type + '\'' +
                ", Speed_limit='" + Speed_limit + '\'' +
                ", Junction_Detail='" + Junction_Detail + '\'' +
                ", Junction_Control='" + Junction_Control + '\'' +
                ", Second_Road_Class='" + Second_Road_Class + '\'' +
                ", Second_Road_Number='" + Second_Road_Number + '\'' +
                ", Pedestrian_Crossing_Human_Control='" + Pedestrian_Crossing_Human_Control + '\'' +
                ", Pedestrian_Crossing_Physical_Facilities='" + Pedestrian_Crossing_Physical_Facilities + '\'' +
                ", Light_Conditions='" + Light_Conditions + '\'' +
                ", Weather_Conditions='" + Weather_Conditions + '\'' +
                ", Road_Surface_Conditions='" + Road_Surface_Conditions + '\'' +
                ", Special_Conditions_at_Site='" + Special_Conditions_at_Site + '\'' +
                ", Carriageway_Hazards='" + Carriageway_Hazards + '\'' +
                ", Urban_or_Rural_Area='" + Urban_or_Rural_Area + '\'' +
                ", Did_Police_Officer_Attend_Scene_of_Accident='" + Did_Police_Officer_Attend_Scene_of_Accident + '\'' +
                ", LSOA_of_Accident_Location='" + LSOA_of_Accident_Location + '\'' +
                ", vehicleList=" + vehicleList +
                ", casualtyList=" + casualtyList +
                '}';
    }
}
