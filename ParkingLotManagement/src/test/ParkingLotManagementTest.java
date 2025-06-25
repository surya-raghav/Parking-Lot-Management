package test;

import model.*;
import Service.ParkingLot;

import java.util.*;

// Test class to validate ParkingLot functionality
public class ParkingLotManagementTest {
    public static void main(String[] args) {
        // Step 1: Create a parking lot configuration with one slot per size
        Map<SlotSize, Integer> config = new HashMap<>();
        config.put(SlotSize.SMALL, 1);
        config.put(SlotSize.LARGE, 1);
        config.put(SlotSize.OVERSIZE, 1);

        // Initialize parking lot with given configuration
        ParkingLot lot = new ParkingLot(config);

        // Step 2: Create sample vehicles
        Vehicle car = new Vehicle(VehicleSize.SMALL, "MH72589");
        Vehicle suv = new Vehicle(VehicleSize.LARGE, "TN96223");
        Vehicle oversizeTruck = new Vehicle(VehicleSize.OVERSIZE, "JP67767");

        // Step 3: Park all vehicles
        System.out.println("--- Test: Parking Vehicles ---");
        lot.parkVehicle(car);             // Should succeed
        lot.parkVehicle(suv);             // Should succeed
        lot.parkVehicle(oversizeTruck);   // Should succeed

        // Step 4: Try duplicate parking of same plate number (should fail)
        System.out.println("--- Test: Duplicate Parking (Should Fail) ---");
        lot.parkVehicle(new Vehicle(VehicleSize.SMALL, "MH72589"));

        // Step 5: Exit a vehicle and repark (with correct plate)
        System.out.println("--- Test: Exit and Repark ---");
        lot.exitVehicle("MH72589");  // Should succeed
        lot.parkVehicle(new Vehicle(VehicleSize.SMALL, "MH72589"));  // Should succeed again

        // Step 6: Final slot status overview
        System.out.println("--- Test: Final Status ---");
        lot.displayStatus();
    }
}
