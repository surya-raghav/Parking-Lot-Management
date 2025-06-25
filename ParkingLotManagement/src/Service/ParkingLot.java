package Service;

import model.*;

import java.util.*;

// Manages the entire parking lot logic: slot allocation, parking, exit, and status
public class ParkingLot {
    private final List<Slot> slots;                        // List of all parking slots
    private final Map<String, Slot> parkedVehicles;        // Map to track vehicles by number plate

    // Constructor to initialize parking lot with a distribution of slot sizes
    public ParkingLot(Map<SlotSize, Integer> slotDistribution) {
        this.slots = new ArrayList<>();
        this.parkedVehicles = new HashMap<>();
        int num = 1;

        // Create slots based on provided distribution (e.g., 2 SMALL, 1 LARGE)
        for (Map.Entry<SlotSize, Integer> entry : slotDistribution.entrySet()) {
            SlotSize size = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                slots.add(new Slot(num++, size));  // Assign unique slot number
            }
        }
    }

    // Parks a vehicle into the first matching available slot
    public boolean parkVehicle(Vehicle vehicle) {
        String plate = vehicle.getNumberPlate();

        // Check if vehicle is already parked
        if (parkedVehicles.containsKey(plate)) {
            System.out.println("Vehicle " + plate + " is already parked in slot #" + parkedVehicles.get(plate).getNumber());
            return false;
        }

        // Try to find an available slot of the same size
        for (Slot slot : slots) {
            if (slot.isVehicleAvailable() && slot.getSize().name().equals(vehicle.getSize().name())) {
                boolean isParked = slot.parkTheVehicle(vehicle);
                if (isParked) {
                    parkedVehicles.put(plate, slot);  // Track parked vehicle
                    System.out.println("Parked " + plate + " in slot #" + slot.getNumber());
                    return true;
                }
            }
        }

        // No suitable slot found
        System.out.println("No available slot for vehicle size: " + vehicle.getSize());
        return false;
    }

    // Exits a vehicle from the parking lot
    public boolean exitVehicle(String numberplate) {
        for (Slot slot : slots) {
            if (!slot.isVehicleAvailable() &&
                    slot.getParkedVehicle().getNumberPlate().equals(numberplate)) {

                slot.vacateVehicle();  // Remove vehicle from slot
                parkedVehicles.remove(numberplate);  // Remove from tracking map
                System.out.println("Vehicle with " + numberplate + " exited from slot # " + slot.getNumber());
                return true;
            }
        }

        // Vehicle not found
        System.out.println("Vehicle not found.");
        return false;
    }

    // Displays the current status of the parking lot
    public void displayStatus() {
        System.out.println("---Parking lot Status---");
        for (Slot slot : slots) {
            System.out.println(slot);
        }
        System.out.println();
    }
}