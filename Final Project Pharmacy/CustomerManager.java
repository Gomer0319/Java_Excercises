public class CustomerManager {
    public void customerMenu() {
        boolean keepCustomerMenu = true;

        while (keepCustomerMenu) {
            System.out.println("\n--------Customer Menu--------");
            System.out.println("1. Add Customer");
            System.out.println("2. Update Customer");
            System.out.println("3. Delete Customer");
            System.out.println("4. Search Customer");
            System.out.println("5. View Customer List");
            System.out.println("6. Back to Main Menu");
            System.out.println("--------------------------");

            // Get user input
            int choice = Utility.getInt(">>> ");
            Utility.userInput.nextLine(); // Consume the newline character

            // Clear the console
            Utility.clearScreen();

            // Create a switch statement to handle user input
            switch (choice) {
                case 1:
                    System.out.println("Enter customer details: ");
                    String customerName = Utility.getString("Enter customer name: ");
                    String birthday = Utility.getString("Enter customer birthday(YYYY-MM-DD): ");
                    String contactNumber = Utility.getString("Enter customer contact number: ");

                    // Create a customer ID generator
                    String customerGeneratedID = "CUS" + IdGenerator.generateID("Customer");

                    // Create a Customer object and call its addCustomer method
                    Customer.addCustomer(customerGeneratedID, customerName, birthday, contactNumber);
                    break;
                case 2:
                    // Create a Customer object and call its updateCustomer method
                    Customer.updateCustomer();
                    break;
                case 3:
                    // Create a Customer object and call its deleteCustomer method
                    Customer.deleteCustomer();
                    break;
                case 4:
                    // Create a Customer object and call its searchCustomer method
                    Customer.searchCustomer();
                    break;
                case 5:
                    // Create a Customer object and call its viewCustomerList method
                    Customer.viewCustomerList();
                    break;
                case 6:
                    // Return to the main menu
                    System.out.println("Returning to main menu...");
                    keepCustomerMenu = false;
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
