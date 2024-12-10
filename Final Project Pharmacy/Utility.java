import java.util.*;

//Create a utility class called Validations, loops, scanners and other repetitive tasks for reusability
public class Utility {
    // Shared scanner instance
    public static final Scanner userInput = new Scanner(System.in);

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

    // On logout, reset session manager variables
    public static void logout() {
        loggedInUsername = null;
        loggedInRole = null;

        System.out.println("\n" + loggedInUsername + " Logged out.\n");
    }
}
