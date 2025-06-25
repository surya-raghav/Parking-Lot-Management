package model;

public class Slot {
    private SlotSize size;
    private Vehicle parkedVehicle;

    public Slot(SlotSize size) {
        this.size = size;
    }

    public SlotSize getSize() {
        return size;
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
}
