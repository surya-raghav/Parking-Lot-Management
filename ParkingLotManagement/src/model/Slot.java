package model;

public class Slot {
    private int number;
    private SlotSize size;
    private Vehicle parkedVehicle;

    public Slot(int number, SlotSize size) {
        this.number = number;
        this.size = size;
    }

    public SlotSize getSize() {
        return size;
    }

    public int getNumber() {
        return number;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public boolean isVehicleAvailable() {
        return parkedVehicle == null;
    }

    public void  vacateVehicle() {
        this.parkedVehicle = null;
    }

    public boolean parkTheVehicle(Vehicle vehicle) {
        if (isVehicleAvailable() && size.name().equals(vehicle.getSize().name())) {
            this.parkedVehicle = vehicle;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Slot{ " +
                "Number = " + number +
                ", Size = " + size +
                ", vehicle slot = " + (parkedVehicle != null ? "Occupied" : "Available") +
                '}';

    }
}

