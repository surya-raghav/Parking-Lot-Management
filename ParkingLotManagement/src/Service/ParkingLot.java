package Service;

import model.*;

import java.util.*;

public class ParkingLot {
    private final List<Slot> slots;

    public ParkingLot(Map<SlotSize, Integer> slotDistribution) {
        this.slots = new ArrayList<>();
        int num = 1;

        for(Map.Entry<SlotSize, Integer> entry: slotDistribution.entrySet()) {
            SlotSize size = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                slots.add(new Slot(num++, size));
            }
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (Slot slot : slots){
            if (slot.getSize().name().equals(vehicle.getSize().name()) && slot.isVehicleAvailable()) {
                boolean isParked = slot.parkTheVehicle(vehicle);
                if (isParked) {
                    System.out.println("Parked " + "in slot #" + slot.getNumber());
                    return true;
                }
            }
        }
        System.out.println("No available slot for vehicle size: " + vehicle.getSize());
        return false;
    }

    public boolean exitVehicle() {
        for (Slot slot: slots) {
            if (!slot.isVehicleAvailable()) {
                slot.vacateVehicle();
                System.out.println("Vehicle exited from slot # " + slot.getNumber());
                return true;
            }
        }
        System.out.println("Vehicle not found.");
        return false;
    }

    public void displayStatus() {
        System.out.println("---Parking lot Status---");
        for (Slot slot :slots) {
            System.out.println(slot);
        }
        System.out.println();
    }
}