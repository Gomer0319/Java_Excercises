import java.util.*;

// Create a main class DeptStoreInfoSys
public class DeptStoreInfoSys {
    public static void main(String[] args) {
        // Flag login status
        boolean loginStatus = false; // false = not logged in

        // Create a scanner object to read user input
        Scanner userInput = new Scanner(System.in);

        // Create a menu for login
        while (!loginStatus) {
            System.out.println("Welcome to the Department Store Info System");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int userOption = userInput.nextInt();

            // Check if the user wants to login using switch case
            switch (userOption) {
                case 1:
                    // Check if login is admin or employee
                    String userRole = LoginManager.login();
                    if ("Admin".equals(userRole)) {
                        System.out.println("You are logged in as an admin.\n");

                        // Set login status to true
                        loginStatus = true;

                        // Go to admin menu
                        AdminMenu adminMenu = new AdminMenu();
                        adminMenu.displayMenu();
                    }
                    else if ("Employee".equals(userRole)) {
                        System.out.println("You are logged in as an employee.\n");

                        // Set login status to true
                        loginStatus = true;

                        // Go to employee menu
                    }
                    break;
                case 2:
                    // Exit
                    System.out.println("\nThanks for using the Department Store Info System.\n");
                    System.exit(0);
                    break;
                default:
                    // Invalid option
                    System.out.println("\nInvalid option. Please try again.\n");
            }
        }
    }
}




