import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

//Create a utility class called Validations, loops, scanners and other repetitive tasks for reusability
public class Utility {
    // Shared scanner instance
    public static final Scanner userInput = new Scanner(System.in);

    // // Formatter for date
    // private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    // Formatter for time
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    // Formatter for date and time
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    // Session Manager variables
    private static String loggedInUsername;
    private static String loggedInRole;
    
    // Method to get String input from user
    public static String getString(String prompt) {
        // Validate user input
        while (true) {
            try {
                System.out.print(prompt);
                return userInput.nextLine();
            }
            catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please try again.\n");
                userInput.next();
            }
        }
    }

    // Method to get Integer input from user
    public static int getInt(String prompt) {
        // Validate user input
        while (true) {
            try {
                System.out.print(prompt);
                return userInput.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please try again.\n");
                userInput.next();
            }
        }
    }

    // Method to get Double input from user
    public static double getDouble(String prompt) {
        // Validate user input
        while (true) {
            try {
                System.out.print(prompt);
                return userInput.nextDouble();
            }
            catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please try again.\n");
                userInput.next();
            }
        }
    }

    // Session manager methods
    public static void setUsername(String username, String role) {
        loggedInUsername = username;
        loggedInRole = role;
    }

    // Method to check if a date is valid
    public static boolean isValidDate(String date) {
        try {
            LocalDate.parse(date);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    // Method to check if a date is expired
    public static boolean isDateExpired(String expiryDate, String currentDate) {
        LocalDate expiry = LocalDate.parse(expiryDate);
        LocalDate current = LocalDate.parse(currentDate);
        return expiry.isBefore(current);
    }

    // Method to clear the console
    public static void clearScreen() {
        try {
            // For Windows
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } 
            // For macOS and Linux
            else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error clearing console: " + e.getMessage());
        }
    }

    // On logout, reset session manager variables
    public static void logout() {
        loggedInUsername = null;
        loggedInRole = null;

        System.out.println("\nLogged out.\n");
    }

    public static String getLoggedInUsername() {
        return loggedInUsername;
    }

    public static String getLoggedInRole() {
        return loggedInRole;
    }

    public static boolean isLoggedIn() {
        return loggedInUsername != null && loggedInRole != null;
    }

    //Setter
    public static void setLoggedInUsername(String username) {
        loggedInUsername = username;
    }

    public static void setLoggedInRole(String role) {
        loggedInRole = role;
    }

    public static String getCurrentDate() {
        return LocalDate.now().toString();
    }

    // Method to get the current time
    public static String getCurrentTime() {
        return LocalDateTime.now().format(TIME_FORMATTER);
    }

    // Method to get the current date and time
    public static String getCurrentDateTime() {
        return LocalDateTime.now().format(DATE_TIME_FORMATTER);
    } 
}
