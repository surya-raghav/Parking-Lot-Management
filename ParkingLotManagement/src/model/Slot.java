package model;

/**
 * Represents a parking slot in the parking lot.
 * Each slot has a unique number, a defined size (e.g., SMALL, LARGE),
 * and may or may not be occupied by a vehicle.
 */
public class Slot {
    private int number;                   // Unique identifier for the slot
    private SlotSize size;               // Size type of the slot (e.g., SMALL, LARGE)
    private Vehicle parkedVehicle;       // Vehicle currently parked, null if empty

    // Constructor to create a slot with number and size
    public Slot(int number, SlotSize size) {
        this.number = number;
        this.size = size;
    }

    // Returns the size of the slot
    public SlotSize getSize() {
        return size;
    }

    // Returns the slot number
    public int getNumber() {
        return number;
    }

    // Returns the vehicle parked in this slot
    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    // Checks if the slot is available (i.e., no vehicle is parked)
    public boolean isVehicleAvailable() {
        return parkedVehicle == null;
    }

    // Empties the slot, removing the vehicle
    public void vacateVehicle() {
        this.parkedVehicle = null;
    }

    // Attempts to park a vehicle; only succeeds if slot is free and size matches
    public boolean parkTheVehicle(Vehicle vehicle) {
        if (isVehicleAvailable() && size.name().equals(vehicle.getSize().name())) {
            this.parkedVehicle = vehicle;
            return true;
        }
        return false;
    }

    // Returns a readable summary of the slot status
    @Override
    public String toString() {
        return "Slot{ " +
                "Number = " + number +
                ", Size = " + size +
                ", vehicle slot = " + (parkedVehicle != null ? parkedVehicle.getNumberPlate() : "Available") +
                '}';
    }
}

