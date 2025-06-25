package model;

// Represents a vehicle attempting to park in the lot
public class Vehicle {
    private VehicleSize size;           // Size category of the vehicle (SMALL, LARGE, etc.)
    private String NumberPlate;        // Unique vehicle identifier (license plate)

    // Constructor to initialize vehicle with size and plate number
    public Vehicle(VehicleSize size, String NumberPlate) {
        this.NumberPlate = NumberPlate;
        this.size = size;
    }

    // Returns the license plate of the vehicle
    public String getNumberPlate() {
        return NumberPlate;
    }

    // Returns the size of the vehicle
    public VehicleSize getSize() {
        return size;
    }
}
