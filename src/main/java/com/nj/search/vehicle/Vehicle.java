package com.nj.search.vehicle;


import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ",", skipFirstLine=true)
public class Vehicle {

    @DataField(pos = 1)
    private String Acc_Index;

    @DataField(pos = 2)
    private String Vehicle_Reference;

    @DataField(pos = 3)
    private String Vehicle_Type;

    @DataField(pos = 4)
    private String Towing_and_Articulation;

    @DataField(pos = 5)
    private String Vehicle_Manoeuvre;

    @DataField(pos = 6)
    private String Vehicle_Location_Restricted_Lane;

    @DataField(pos = 7)
    private String Junction_Location;

    @DataField(pos = 8)
    private String Skidding_and_Overturning;

    @DataField(pos = 9)
    private String Hit_Object_in_Carriageway;

    @DataField(pos = 10)
    private String Vehicle_Leaving_Carriageway;

    @DataField(pos = 11)
    private String Hit_Object_off_Carriageway;

    @DataField(pos = 12)
    private String First_Point_of_Impact;

    @DataField(pos = 13)
    private String Was_Vehicle_Left_Hand_Drive;

    @DataField(pos = 14)
    private String Journey_Purpose_of_Driver;

    @DataField(pos = 15)
    private String Sex_of_Driver;

    @DataField(pos = 16)
    private String Age_Band_of_Driver;

    @DataField(pos = 17)
    private String Engine_Capacity;

    @DataField(pos = 18)
    private String Propulsion_Code;

    @DataField(pos = 19)
    private String Age_of_Vehicle;

    @DataField(pos = 20)
    private String Driver_IMD_Decile;

    @DataField(pos = 21)
    private String Driver_Home_Area_Type;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @DataField(pos = 22)
    private String Data_type;

    private String make;

    private String model;


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

    public String getVehicle_Type() {
        return Vehicle_Type;
    }

    public void setVehicle_Type(String vehicle_Type) {
        Vehicle_Type = vehicle_Type;
    }

    public String getTowing_and_Articulation() {
        return Towing_and_Articulation;
    }

    public void setTowing_and_Articulation(String towing_and_Articulation) {
        Towing_and_Articulation = towing_and_Articulation;
    }

    public String getVehicle_Manoeuvre() {
        return Vehicle_Manoeuvre;
    }

    public void setVehicle_Manoeuvre(String vehicle_Manoeuvre) {
        Vehicle_Manoeuvre = vehicle_Manoeuvre;
    }

    public String getVehicle_Location_Restricted_Lane() {
        return Vehicle_Location_Restricted_Lane;
    }

    public void setVehicle_Location_Restricted_Lane(String vehicle_Location_Restricted_Lane) {
        Vehicle_Location_Restricted_Lane = vehicle_Location_Restricted_Lane;
    }

    public String getJunction_Location() {
        return Junction_Location;
    }

    public void setJunction_Location(String junction_Location) {
        Junction_Location = junction_Location;
    }

    public String getSkidding_and_Overturning() {
        return Skidding_and_Overturning;
    }

    public void setSkidding_and_Overturning(String skidding_and_Overturning) {
        Skidding_and_Overturning = skidding_and_Overturning;
    }

    public String getHit_Object_in_Carriageway() {
        return Hit_Object_in_Carriageway;
    }

    public void setHit_Object_in_Carriageway(String hit_Object_in_Carriageway) {
        Hit_Object_in_Carriageway = hit_Object_in_Carriageway;
    }

    public String getVehicle_Leaving_Carriageway() {
        return Vehicle_Leaving_Carriageway;
    }

    public void setVehicle_Leaving_Carriageway(String vehicle_Leaving_Carriageway) {
        Vehicle_Leaving_Carriageway = vehicle_Leaving_Carriageway;
    }

    public String getHit_Object_off_Carriageway() {
        return Hit_Object_off_Carriageway;
    }

    public void setHit_Object_off_Carriageway(String hit_Object_off_Carriageway) {
        Hit_Object_off_Carriageway = hit_Object_off_Carriageway;
    }

    public String getFirst_Point_of_Impact() {
        return First_Point_of_Impact;
    }

    public void setFirst_Point_of_Impact(String first_Point_of_Impact) {
        First_Point_of_Impact = first_Point_of_Impact;
    }

    public String getWas_Vehicle_Left_Hand_Drive() {
        return Was_Vehicle_Left_Hand_Drive;
    }

    public void setWas_Vehicle_Left_Hand_Drive(String was_Vehicle_Left_Hand_Drive) {
        Was_Vehicle_Left_Hand_Drive = was_Vehicle_Left_Hand_Drive;
    }

    public String getJourney_Purpose_of_Driver() {
        return Journey_Purpose_of_Driver;
    }

    public void setJourney_Purpose_of_Driver(String journey_Purpose_of_Driver) {
        Journey_Purpose_of_Driver = journey_Purpose_of_Driver;
    }

    public String getSex_of_Driver() {
        return Sex_of_Driver;
    }

    public void setSex_of_Driver(String sex_of_Driver) {
        Sex_of_Driver = sex_of_Driver;
    }

    public String getAge_Band_of_Driver() {
        return Age_Band_of_Driver;
    }

    public void setAge_Band_of_Driver(String age_Band_of_Driver) {
        Age_Band_of_Driver = age_Band_of_Driver;
    }

    public String getEngine_Capacity() {
        return Engine_Capacity;
    }

    public void setEngine_Capacity(String engine_Capacity) {
        Engine_Capacity = engine_Capacity;
    }

    public String getPropulsion_Code() {
        return Propulsion_Code;
    }

    public void setPropulsion_Code(String propulsion_Code) {
        Propulsion_Code = propulsion_Code;
    }

    public String getAge_of_Vehicle() {
        return Age_of_Vehicle;
    }

    public void setAge_of_Vehicle(String age_of_Vehicle) {
        Age_of_Vehicle = age_of_Vehicle;
    }

    public String getDriver_IMD_Decile() {
        return Driver_IMD_Decile;
    }

    public void setDriver_IMD_Decile(String driver_IMD_Decile) {
        Driver_IMD_Decile = driver_IMD_Decile;
    }

    public String getDriver_Home_Area_Type() {
        return Driver_Home_Area_Type;
    }

    public void setDriver_Home_Area_Type(String driver_Home_Area_Type) {
        Driver_Home_Area_Type = driver_Home_Area_Type;
    }

    public String getData_type() {
        return Data_type;
    }

    public void setData_type(String data_type) {
        Data_type = data_type;
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "Acc_Index='" + Acc_Index + '\'' +
                ", Vehicle_Reference='" + Vehicle_Reference + '\'' +
                ", Vehicle_Type='" + Vehicle_Type + '\'' +
                ", Towing_and_Articulation='" + Towing_and_Articulation + '\'' +
                ", Vehicle_Manoeuvre='" + Vehicle_Manoeuvre + '\'' +
                ", Vehicle_Location_Restricted_Lane='" + Vehicle_Location_Restricted_Lane + '\'' +
                ", Junction_Location='" + Junction_Location + '\'' +
                ", Skidding_and_Overturning='" + Skidding_and_Overturning + '\'' +
                ", Hit_Object_in_Carriageway='" + Hit_Object_in_Carriageway + '\'' +
                ", Vehicle_Leaving_Carriageway='" + Vehicle_Leaving_Carriageway + '\'' +
                ", Hit_Object_off_Carriageway='" + Hit_Object_off_Carriageway + '\'' +
                ", First_Point_of_Impact='" + First_Point_of_Impact + '\'' +
                ", Was_Vehicle_Left_Hand_Drive='" + Was_Vehicle_Left_Hand_Drive + '\'' +
                ", Journey_Purpose_of_Driver='" + Journey_Purpose_of_Driver + '\'' +
                ", Sex_of_Driver='" + Sex_of_Driver + '\'' +
                ", Age_Band_of_Driver='" + Age_Band_of_Driver + '\'' +
                ", Engine_Capacity='" + Engine_Capacity + '\'' +
                ", Propulsion_Code='" + Propulsion_Code + '\'' +
                ", Age_of_Vehicle='" + Age_of_Vehicle + '\'' +
                ", Driver_IMD_Decile='" + Driver_IMD_Decile + '\'' +
                ", Driver_Home_Area_Type='" + Driver_Home_Area_Type + '\'' +
                ", Data_type='" + Data_type + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
