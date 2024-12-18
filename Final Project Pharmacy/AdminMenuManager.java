// Create a class called AdminMenuManager
public class AdminMenuManager {
    public void adminMenu() {
        // Prompt logged in user (admin)
        System.out.println("\nWelcome " + Utility.getLoggedInUsername() + "!\n");

        boolean keepAdminMenu = true;

        while (keepAdminMenu) {
            // Display admin menu
            System.out.println("\n--------Admin Menu--------");
            System.out.println("1. Manage Products");
            System.out.println("2. Sales");
            System.out.println("3. View Reports");
            System.out.println("4. Customer Menu");
            System.out.println("5. Logout");
            System.out.println("--------------------------");

            // Get user input
            int choice = Utility.getInt(">>> ");
            Utility.userInput.nextLine(); // Consume the newline character

            // Clear the console
            Utility.clearScreen();

            // Create a switch statement to handle user input
            switch (choice) {

                case 1:
                    // Create a ProductManager object and call its productMenu method
                    ProductManager productManager = new ProductManager();
                    productManager.productMenu();
                    break;

                case 2:
                    // Create a SalesManager object and call its salesMenu method
                    SalesManager salesManager = new SalesManager();
                    salesManager.salesMenu();
                    break;

                case 3:
                    // Create a ReportManager object and call its reportMenu method
                    ReportManager reportManager = new ReportManager();
                    reportManager.reportMenu();
                    break;

                case 4:
                    // Create a CustomerMenuManager object and call its customerMenu method
                    CustomerManager customerManager = new CustomerManager();
                    customerManager.customerMenu();
                    break;

                case 5:
                    // Ask user if they really want to logout and if they do, call the logout
                    // method.
                    if (Utility.getString("Are you sure you want to logout? (y/n) ").equalsIgnoreCase("y")) {
                        System.out.println("Logging out...");
                        Utility.logout();
                        keepAdminMenu = false;
                    } else {
                        System.out.println("Logout cancelled.");
                        break;
                    }
                    break;
                default:

                    // Print an error message for invalid input
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
