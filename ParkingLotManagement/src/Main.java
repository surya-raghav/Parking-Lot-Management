import  model.*;
import Service.ParkingLot;

import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<SlotSize, Integer> slotDistribution = new HashMap<>();
        slotDistribution.put(SlotSize.SMALL, 5);
        slotDistribution.put(SlotSize.LARGE, 5);
        slotDistribution.put(SlotSize.OVERSIZE, 2);

        ParkingLot parkingLot = new ParkingLot(slotDistribution);

        Scanner scanner = new Scanner(System.in);
        String command;
        System.out.println("Welcome to Prking Lot");
        System.out.println("Commands: park [SIZE], exit, status, quit");

        while (true) {
            System.out.print(">");
            command = scanner.nextLine();
            String[] parts = command.split(" ");

            if (parts[0].equalsIgnoreCase("park")) {
                try {
                    VehicleSize size = VehicleSize.valueOf(parts[1].toUpperCase());
                    parkingLot.parkVehicle(new Vehicle(size));
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid Vehicle Type");
                }
            } else if (parts[0].equalsIgnoreCase("exit")) {
                parkingLot.exitVehicle();
            } else if (parts[0].equalsIgnoreCase("status")) {
                parkingLot.displayStatus();
            } else if (parts[0].equalsIgnoreCase("quit")) {
                break;
            } else {
                System.out.println("Invalid command");
            }
        }
        scanner.close();
    }
}

