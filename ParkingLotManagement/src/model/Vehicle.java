package model;

public class Vehicle {
    private VehicleSize size;
    private String NumberPlate;



    public Vehicle (VehicleSize size, String NumberPlate) {
        this.NumberPlate = NumberPlate;
        this.size = size;

    }
    public String getNumberPlate(){
        return NumberPlate;
    }


    public VehicleSize getSize() {
        return size;
    }
}
