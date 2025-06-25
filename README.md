#  Parking Lot Management App (Java)

This is a scalable, object-oriented **Parking Lot Management System** built in Java. 
The system supports managing different vehicle types and parking slot sizes through a **command-line interface**. 
It is designed with flexibility and extensibility in mind.

---

##  Features

- Manage parking for:
  - Small cars
  - Large vehicles
  - Oversized vehicles
- Vehicle operations:
  - Park a vehicle
  - Exit a vehicle
  - Display lot status
- Prevents:
  - Duplicate parking of same vehicle
  - Invalid slot assignments
- Clean and modular design using Java OOP principles

---

##  How to Compile and Run

###  Requirements

- **Java 11 or later**
- **JDK installed and added to PATH**
- Any text editor or IDE (e.g., IntelliJ, VS Code, Eclipse)

### Compilation

Use the terminal or your preferred IDE:

```bash
javac -d out src/model/*.java src/service/*.java src/Main.java

▶ Running the App
java -cp out Main

 CLI Commands
Commands:
  park [PLATE] [SIZE]           → Parks the vehicle if a slot is available
  exit [PLATE]                  → Removes vehicle from lot
  status                        → Displays current slot occupancy
  quit                          → Exits the CLI

 Example:
> park MH55 SMALL
> park EV999 LARGE
> exit MH55
> status
> quit
```

###  How to Debug the Project
- Using Console Print Statements:
Check ParkingLot.java, Slot.java, and Main.java for System.out.println() calls already included

- Example: In parkVehicle() and exitVehicle() methods, logs show where the vehicle is parked or exited

- Using IDE Debugger (IntelliJ / VS Code / Eclipse):
  - Set breakpoints in:

  - ParkingLot.java → parkVehicle() and exitVehicle()

  - Main.java → command processing block

### Run in debug mode

  - Step through the logic line-by-line to inspect slot and vehicle state

###  Dependencies
- No external libraries required

- Entirely Java Standard Library based

###  How to Test
- Use the file test/ParkingLotManagementTest.java to:

  - Initialize a lot with known configuration

  - Simulate parking, exiting, and overflows

  - Confirm expected outputs and slot status

To compile and run the test:
``` bash
  javac -d out src/model/*.java src/service/*.java test/ParkingLotManagementTest.java
  java -cp out test.ParkingLotManagementTest
```
###  Author
Made by Surya Raghav
