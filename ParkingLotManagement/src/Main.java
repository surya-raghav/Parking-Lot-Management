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
        System.out.println("Commands: park [PLATE] [SIZE], exit, status, quit");

        while (true) {
            System.out.print(">");
            command = scanner.nextLine();
            String[] parts = command.split(" ");

            if (parts[0].equalsIgnoreCase("park")) {
                try {
                    String plate = parts[1];
                    VehicleSize size = VehicleSize.valueOf(parts[2].toUpperCase());
                    parkingLot.parkVehicle(new Vehicle(size, plate));
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid Vehicle Type");
                }
            } else if (parts[0].equalsIgnoreCase("exit")) {
                if (parts.length == 1) {
                    System.out.println("Please enter vehicle number to exit");
                } else {
                    parkingLot.exitVehicle(parts[1]);
                }
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

