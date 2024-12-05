import java.util.*;

// Create Admin menu class
class AdminMenu {
    // Create a scanner object to read user input
    Scanner adminInput = new Scanner(System.in);

    // Create menu for admin side
    public void displayMenu() {
        // Create a boolean variable to check if the admin wants to keep admin menu until they choose to logout
        boolean keepAdminMenu = true;

        while (keepAdminMenu) {
            //try-catch block to handle InputMismatchException
            try {
                System.out.println("\n=============================================");
                System.out.println("Admin Menu");
                System.out.println("---------------------------------------------");
                System.out.println("1. Manage Products");
                System.out.println("2. Sales");
                System.out.println("3. View Reports");
                System.out.println("4. Logout");
                System.out.println("=============================================");
                System.out.print("Enter your choice: ");
                
                int adminOption = adminInput.nextInt();

                // Check if the admin wants to manage products, process sales, view reports, or logout
                switch (adminOption) {
                    case 1:
                        // Go to manage products menu
                        ManageProducts manageProducts = new ManageProducts();
                        manageProducts.displayMenu();
                        break;
                    case 2:
                        // Go to sales menu
                        Sales sales = new Sales();
                        sales.salesMenu();
                        break;
                    case 3:
                        // View reports
                        System.out.println("View Reports");
                        break;
                    case 4:
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
            } 
            catch (InputMismatchException e) {
                System.out.println("\nInvalid input, please enter a number from the menu.\n");
                adminInput.next();
            }
        }
    }
}

