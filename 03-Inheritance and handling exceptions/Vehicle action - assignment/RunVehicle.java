import java.util.Scanner;

// Main class
public class RunVehicle {
    public static void main(String[] args) {
        // In the RunVehicle class, use Scanner.nextLine() and String.equalsIgnoreCase() to get user input and produce an output
        Scanner input = new Scanner(System.in);

        // Choose a vehicle
        System.out.println("Choose a vehicle. Press C for Car, M for Motorcycle, or T for Truck");
        String vehicle = input.nextLine();

        // Create an instance of the chosen vehicle
        Vehicle vehicleObject;
        if (vehicle.equalsIgnoreCase("C")) {
            vehicleObject = new Car();
        } else if (vehicle.equalsIgnoreCase("M")) {
            vehicleObject = new Motorcycle();
        } else if (vehicle.equalsIgnoreCase("T")) {
            vehicleObject = new Truck();
        } else {
            System.out.println("Invalid vehicle choice.");
            input.close();
            return;
        }

        vehicleObject.fuel();
        vehicleObject.start();
        vehicleObject.stop();

        input.close();
    }
}