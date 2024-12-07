import java.util.*;

// Create Admin menu class
class EmployeeMenu {
    private String loggedUser; // To store the logged user's name or role

    // Constructor to initialize loggedUser
    public EmployeeMenu(String loggedUser) {
        this.loggedUser = loggedUser;
    }

    // Default constructor
    public EmployeeMenu() {
        this.loggedUser = null;
    }

    // Create a scanner object to read user input
    Scanner employeeInput = new Scanner(System.in);

    // Create menu for admin side
    public void displayMenu() {
        // Create a boolean variable to check if the admin wants to keep admin menu until they choose to logout
        boolean keepEmployeeMenu = true;

        // Create a message to greet the user
        System.out.println("\nWelcome, " + loggedUser + "!\n");

        while (keepEmployeeMenu) {
            //try-catch block to handle InputMismatchException
            try {
                System.out.println("\n=============================================");
                System.out.println("Employee Menu");
                System.out.println("---------------------------------------------");
                System.out.println("1. Sales");
                System.out.println("2. View Inventory and Sales");
                System.out.println("3. Logout");
                System.out.println("=============================================");
                System.out.print("Enter your choice: ");
                
                int employeeOption = employeeInput.nextInt();

                // Check if the admin wants to manage products, process sales, view reports, or logout
                switch (employeeOption) {
                    case 1:
                        // Go to sales menu
                        Sales sales = new Sales();
                        sales.salesMenu();
                        break;
                    case 2:
                        // View reports
                        ViewReports viewReports = new ViewReports();
                        viewReports.displayMenu();
                        break;
                    case 3:
                        // Logout and return to Login menu
                        System.out.println("You are logged out.\n");

                        // Set login status to false
                        keepEmployeeMenu = false;

                        // Return to Login menu
                        DeptStoreInfoSys.main(null);
                        break;
                    default:
                        System.out.println("\nInvalid option. Please try again.\n");
                        break;
                }
            } 
            catch (InputMismatchException e) {
                System.out.println("\nInvalid input, please enter a number from the menu.\n");
                employeeInput.next();
            }
        }
    }

    // Get the logged user's name or role
    public String getLoggedUser() {
        return loggedUser;
    }
}

//Note: Should have User Class abstracted and let the EmployeeMenu and AdminMenu inherit from it to avoid code duplication