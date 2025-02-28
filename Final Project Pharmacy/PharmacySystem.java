
//Create Main class PharmacySystem (contains main method that starts the program that includes all other classes)
import java.util.*;

public class PharmacySystem {
    public static void main(String[] args) {
        boolean keepRunning = true;

        while (keepRunning) {
            try {
                displayMenu();

                // Use userInput method to get user input
                int choice = Utility.getInt(">>> ");
                Utility.userInput.nextLine();

                // Clear the console
                Utility.clearScreen();

                // Create a switch statement to handle user input
                switch (choice) {
                    case 1:
                        // Create a LoginManager object and call its login method
                        LoginManager loginManager = new LoginManager();
                        loginManager.login();
                        break;
                    case 2:
                        // Exit the program
                        // Message to user that they have logged out
                        System.out.println("\nYou have exited the program.");
                        System.out.println("Thank you for using Remog Pharmacy Management System! Goodbye!\n");
                        keepRunning = false;
                        System.exit(0);
                        break;
                    default:
                        // Print an error message for invalid input
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                // Print an error message for invalid input
                System.out.println("Invalid input. Please try again.");
                // Clear the input buffer
                Utility.userInput.nextLine();
            }
        }
    }

    public static void displayMenu() {
        // Create a welcome message and a login menu options
        System.out.println("\nWelcome to Remog Pharmacy Management System!\n");
        System.out.println("--------------------------");
        System.out.println("1. Login");
        System.out.println("2. Exit");
        System.out.println("--------------------------");
    }
}