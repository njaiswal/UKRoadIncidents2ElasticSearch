package com.nj.search.casualty;


import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ",")
public class Casualty {

    @DataField(pos = 1)
    private String Acc_Index;

    @DataField(pos = 2)
    private String Vehicle_Reference;

    @DataField(pos = 3)
    private String Casualty_Reference;

    @DataField(pos = 4)
    private String Casualty_Class;

    @DataField(pos = 5)
    private String Sex_of_Casualty;

    @DataField(pos = 6)
    private String Age_Band_of_Casualty;

    @DataField(pos = 7)
    private String Casualty_Severity;

    @DataField(pos = 8)
    private String Pedestrian_Location;

    @DataField(pos = 9)
    private String Pedestrian_Movement;

    @DataField(pos = 10)
    private String Car_Passenger;

    @DataField(pos = 11)
    private String Bus_or_Coach_Passenger;

    @DataField(pos = 12)
    private String Pedestrian_Road_Maintenance_Worker;

    @DataField(pos = 13)
    private String Casualty_Type;

    @DataField(pos = 14)
    private String Casualty_Home_Area_Type;

    @DataField(pos = 15)
    private String Data_Type;

    public String getAcc_Index() {
        return Acc_Index;
    }

    public void setAcc_Index(String acc_Index) {
        Acc_Index = acc_Index;
    }

    public String getVehicle_Reference() {
        return Vehicle_Reference;
    }

    public void setVehicle_Reference(String vehicle_Reference) {
        Vehicle_Reference = vehicle_Reference;
    }

    public String getCasualty_Reference() {
        return Casualty_Reference;
    }

    public void setCasualty_Reference(String casualty_Reference) {
        Casualty_Reference = casualty_Reference;
    }

    public String getCasualty_Class() {
        return Casualty_Class;
    }

    public void setCasualty_Class(String casualty_Class) {
        Casualty_Class = casualty_Class;
    }

    public String getSex_of_Casualty() {
        return Sex_of_Casualty;
    }

    public void setSex_of_Casualty(String sex_of_Casualty) {
        Sex_of_Casualty = sex_of_Casualty;
    }

    public String getAge_Band_of_Casualty() {
        return Age_Band_of_Casualty;
    }

    public void setAge_Band_of_Casualty(String age_Band_of_Casualty) {
        Age_Band_of_Casualty = age_Band_of_Casualty;
    }

    public String getCasualty_Severity() {
        return Casualty_Severity;
    }

    public void setCasualty_Severity(String casualty_Severity) {
        Casualty_Severity = casualty_Severity;
    }

    public String getPedestrian_Location() {
        return Pedestrian_Location;
    }

    public void setPedestrian_Location(String pedestrian_Location) {
        Pedestrian_Location = pedestrian_Location;
    }

    public String getPedestrian_Movement() {
        return Pedestrian_Movement;
    }

    public void setPedestrian_Movement(String pedestrian_Movement) {
        Pedestrian_Movement = pedestrian_Movement;
    }

    public String getCar_Passenger() {
        return Car_Passenger;
    }

    public void setCar_Passenger(String car_Passenger) {
        Car_Passenger = car_Passenger;
    }

    public String getBus_or_Coach_Passenger() {
        return Bus_or_Coach_Passenger;
    }

    public void setBus_or_Coach_Passenger(String bus_or_Coach_Passenger) {
        Bus_or_Coach_Passenger = bus_or_Coach_Passenger;
    }

    public String getPedestrian_Road_Maintenance_Worker() {
        return Pedestrian_Road_Maintenance_Worker;
    }

    public void setPedestrian_Road_Maintenance_Worker(String pedestrian_Road_Maintenance_Worker) {
        Pedestrian_Road_Maintenance_Worker = pedestrian_Road_Maintenance_Worker;
    }

    public String getCasualty_Type() {
        return Casualty_Type;
    }

    public void setCasualty_Type(String casualty_Type) {
        Casualty_Type = casualty_Type;
    }

    public String getCasualty_Home_Area_Type() {
        return Casualty_Home_Area_Type;
    }

    public void setCasualty_Home_Area_Type(String casualty_Home_Area_Type) {
        Casualty_Home_Area_Type = casualty_Home_Area_Type;
    }

    public String getData_Type() {
        return Data_Type;
    }

    public void setData_Type(String data_Type) {
        Data_Type = data_Type;
    }

    @Override
    public String toString() {
        return "Casualty{" +
                "Acc_Index='" + Acc_Index + '\'' +
                ", Vehicle_Reference='" + Vehicle_Reference + '\'' +
                ", Casualty_Reference='" + Casualty_Reference + '\'' +
                ", Casualty_Class='" + Casualty_Class + '\'' +
                ", Sex_of_Casualty='" + Sex_of_Casualty + '\'' +
                ", Age_Band_of_Casualty='" + Age_Band_of_Casualty + '\'' +
                ", Casualty_Severity='" + Casualty_Severity + '\'' +
                ", Pedestrian_Location='" + Pedestrian_Location + '\'' +
                ", Pedestrian_Movement='" + Pedestrian_Movement + '\'' +
                ", Car_Passenger='" + Car_Passenger + '\'' +
                ", Bus_or_Coach_Passenger='" + Bus_or_Coach_Passenger + '\'' +
                ", Pedestrian_Road_Maintenance_Worker='" + Pedestrian_Road_Maintenance_Worker + '\'' +
                ", Casualty_Type='" + Casualty_Type + '\'' +
                ", Casualty_Home_Area_Type='" + Casualty_Home_Area_Type + '\'' +
                ", Data_Type='" + Data_Type + '\'' +
                '}';
    }
}
