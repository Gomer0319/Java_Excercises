package Main;
import java.util.*;
import Miscellanious.*;
import Products.*;
import Sales.*;
import Report.*;

// Create Admin menu class
public class AdminMenu {
    private String loggedUser; // To store the logged user's name or role

    // Constructor to initialize loggedUser
    public AdminMenu(String loggedUser) {
        this.loggedUser = LoginManager.getloggedUser();
    }

    // Default constructor
    public AdminMenu() {
        this.loggedUser = null;
    }

    // Create a scanner object to read user input
    Scanner adminInput = new Scanner(System.in);

    // Create menu for admin side
    public void displayMenu() {
        // Create a boolean variable to check if the admin wants to keep admin menu
        // until they choose to logout
        boolean keepAdminMenu = true;

        // Create a message to greet the user
        String loggedUser = LoginManager.getloggedUser();
        System.out.println("\nWelcome, " + loggedUser + "!\n");

        while (keepAdminMenu) {
            // try-catch block to handle InputMismatchException
            try {
                System.out.println("\n=============================================");
                System.out.println("Admin Menu");
                System.out.println("---------------------------------------------");
                System.out.println("1. Manage Products");
                System.out.println("2. Sales");
                System.out.println("3. View Inventory and Sales");
                System.out.println("4. Customer Menu");
                System.out.println("5. Logout");
                System.out.println("=============================================");
                System.out.print("Enter your choice: ");

                int adminOption = adminInput.nextInt();

                // Check if the admin wants to manage products, process sales, view reports, or
                // logout
                switch (adminOption) {
                    case 1:
                        // Go to manage products menu
                        ManageProducts manageProducts = new ManageProducts();
                        manageProducts.displayMenu();
                        break;
                    case 2:
                        // Go to sales menu
                        Sales sales = new Sales(loggedUser, 0);
                        sales.salesMenu();
                        break;
                    case 3:
                        // View reports
                        ViewReports viewReports = new ViewReports();
                        viewReports.displayMenu();
                        break;
                    case 4:
                        // Go to customer menu
                        Customer customer = new Customer();
                        customer.customerMenu();
                        break;
                    case 5:
                        // Logout and return to Login menu
                        System.out.println("You are logged out.\n");

                        // Set login status to false
                        keepAdminMenu = false;

                        // Return to Login menu
                        DeptStoreInfoSys.main(null);
                        break;
                    default:
                        System.out.println("\nInvalid option. Please try again.\n");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input, please enter a number from the menu.\n");
                adminInput.next();
            }
        }
    }

    // Get the logged user's name or role
    public String getLoggedUser() {
        return loggedUser;
    }
}

// Note: Should have User Class abstracted and let the EmployeeMenu and
// AdminMenu inherit from it to avoid code duplication
