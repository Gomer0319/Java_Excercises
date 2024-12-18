public class EmployeeMenuManager {
    public void employeeMenu() {
        // Prompt logged in user (Employee)
        System.out.println("\nWelcome " + Utility.getLoggedInUsername() + "!\n");

        boolean keepEmployeeMenu = true;

        while (keepEmployeeMenu) {
            // Display admin menu
            System.out.println("\n--------Employee Menu--------");
            System.out.println("1. Sales");
            System.out.println("2. View Reports");
            System.out.println("3. Customer Menu");
            System.out.println("4. Logout");
            System.out.println("--------------------------");

            // Get user input
            int choice = Utility.getInt(">>> ");
            Utility.userInput.nextLine(); // Consume the newline character

            // Clear the console
            Utility.clearScreen();

            // Create a switch statement to handle user input
            switch (choice) {

                case 1:
                    // Create a SalesManager object and call its salesMenu method
                    SalesManager salesManager = new SalesManager();
                    salesManager.salesMenu();
                    break;

                case 2:
                    // Create a ReportManager object and call its reportMenu method
                    ReportManager reportManager = new ReportManager();
                    reportManager.reportMenu();
                    break;

                case 3:
                    // Create a CustomerMenuManager object and call its customerMenu method
                    CustomerManager customerManager = new CustomerManager();
                    customerManager.customerMenu();
                    break;

                case 4:
                    // Ask user if they really want to logout and if they do, call the logout
                    // method.
                    if (Utility.getString("Are you sure you want to logout? (y/n) ").equalsIgnoreCase("y")) {
                        System.out.println("Logging out...");
                        Utility.logout();
                        keepEmployeeMenu = false;
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
