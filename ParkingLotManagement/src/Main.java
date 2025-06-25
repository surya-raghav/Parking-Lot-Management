import  model.*;
import Service.ParkingLot;

import java.util.*;
import java.util.Scanner;

// Entry point for the Parking Lot CLI application
public class Main {
    public static void main(String[] args) {
        // Step 1: Define the parking lot slot distribution
        Map<SlotSize, Integer> slotDistribution = new HashMap<>();
        slotDistribution.put(SlotSize.SMALL, 5);     // 5 small slots
        slotDistribution.put(SlotSize.LARGE, 5);     // 5 large slots
        slotDistribution.put(SlotSize.OVERSIZE, 2);  // 2 oversize slots

        // Step 2: Initialize the ParkingLot with the slot configuration
        ParkingLot parkingLot = new ParkingLot(slotDistribution);

        // Step 3: Setup scanner for CLI commands
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to Parking Lot");
        System.out.println("Commands: park [PLATE] [SIZE], exit [PLATE], status, quit");

        // Step 4: CLI loop to accept user commands
        while (true) {
            System.out.print(">");                  // Prompt
            command = scanner.nextLine();           // Read full command
            String[] parts = command.split(" ");    // Tokenize by space

            // Handle 'park' command
            if (parts[0].equalsIgnoreCase("park")) {
                try {
                    String plate = parts[1];                        // Plate number
                    VehicleSize size = VehicleSize.valueOf(parts[2].toUpperCase()); // Vehicle size
                    parkingLot.parkVehicle(new Vehicle(size, plate));  // Attempt to park
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid Vehicle Type");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Usage: park [PLATE] [SIZE]");
                }

                // Handle 'exit' command
            } else if (parts[0].equalsIgnoreCase("exit")) {
                if (parts.length == 1) {
                    System.out.println("Please enter vehicle number to exit");
                } else {
                    parkingLot.exitVehicle(parts[1]); // Exit vehicle
                }

                // Handle 'status' command
            } else if (parts[0].equalsIgnoreCase("status")) {
                parkingLot.displayStatus(); // Show current slot status

                // Handle 'quit' command
            } else if (parts[0].equalsIgnoreCase("quit")) {
                break;

                // Invalid command handler
            } else {
                System.out.println("Invalid command");
            }
        }

        // Step 5: Close input scanner
        scanner.close();
    }
}

