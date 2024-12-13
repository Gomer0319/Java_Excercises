public class SalesManager {
    public void salesMenu() {
        boolean keepSalesMenu = true;

        // Create a SalesController object
        SalesController salesController = new SalesController();

        while (keepSalesMenu) {
            System.out.println("\n--------Sales Menu--------");
            System.out.println("1. Sell Product");
            System.out.println("2. Void item");
            System.out.println("3. Finalize Sale");
            System.out.println("4. Return to Main Menu");
            System.out.println("--------------------------");

            // Get user input
            int choice = Utility.getInt(">>> ");
            Utility.userInput.nextLine(); // Consume the newline character

            // Clear the console
            Utility.clearScreen();

            // Create a switch statement to handle user input
            switch (choice) {
                case 1:
                    // Create a SalesController object and call its sellProduct method
                    salesController.sellProduct();
                    break;
                case 2:
                    // Create a SalesController object and call its voidItem method
                    salesController.voidItem();
                    break;
                case 3:
                    // Create a SalesController object and call its finalizeSale method
                    salesController.finalizeSale();
                    break;
                case 4:
                    // Return to the main menu
                    System.out.println("\nReturning to main menu...\n");
                    keepSalesMenu = false;
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.\n");
            }
        }
    }
}
