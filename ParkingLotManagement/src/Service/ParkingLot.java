package Service;

import model.*;

import java.util.*;

public class ParkingLot {
    private final List<Slot> slots;
    private final Map<String, Slot> parkedVehicles;

    public ParkingLot(Map<SlotSize, Integer> slotDistribution) {
        this.slots = new ArrayList<>();
        this.parkedVehicles = new HashMap<>();
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
        String plate = vehicle.getNumberPlate();
        if (parkedVehicles.containsKey(plate)) {
            System.out.println("Vehicle " + plate + " is already parked in slot #" + parkedVehicles.get(plate).getNumber());
            return false;
        }
        for (Slot slot : slots) {
            if (slot.isVehicleAvailable() && slot.getSize().name().equals(vehicle.getSize().name())) {
                boolean isParked = slot.parkTheVehicle(vehicle);
                if (isParked) {
                    parkedVehicles.put(plate, slot);
                    System.out.println("Parked " + plate + " in slot #" + slot.getNumber());
                    return true;
                }
            }
        }
        System.out.println("No available slot for vehicle size: " + vehicle.getSize());
        return false;
    }

    public boolean exitVehicle(String numberplate) {
        for (Slot slot: slots) {
            if (!slot.isVehicleAvailable() && slot.getParkedVehicle().getNumberPlate().equals(numberplate)) {
                slot.vacateVehicle();
                System.out.println("Vehicle with " + numberplate + " exited from slot # " + slot.getNumber());
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