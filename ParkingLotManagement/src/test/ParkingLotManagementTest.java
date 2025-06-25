package test;

import model.*;
import Service.ParkingLot;

import java.util.*;

public class ParkingLotManagementTest {
    public static void main(String[] args) {
        Map<SlotSize, Integer> config = new HashMap<>();
        config.put(SlotSize.SMALL, 1);
        config.put(SlotSize.LARGE, 1);
        config.put(SlotSize.OVERSIZE, 1);

        ParkingLot lot = new ParkingLot(config);

        Vehicle car = new Vehicle(VehicleSize.SMALL, "MH72589");
        Vehicle suv = new Vehicle(VehicleSize.LARGE, "TN96223");
        Vehicle oversizeTruck = new Vehicle(VehicleSize.OVERSIZE, "JP67767");

        System.out.println("--- Test: Parking Vehicles ---");
        lot.parkVehicle(car);
        lot.parkVehicle(suv);
        lot.parkVehicle(oversizeTruck);

        System.out.println("--- Test: Duplicate Parking (Should Fail) ---");
        lot.parkVehicle(new Vehicle(VehicleSize.SMALL, "MH72589"));

        System.out.println("--- Test: Exit and Repark ---");
        lot.exitVehicle("KA01AA1111");
        lot.parkVehicle(new Vehicle(VehicleSize.SMALL, "MH72589"));

        System.out.println("--- Test: Final Status ---");
        lot.displayStatus();
    }
}
