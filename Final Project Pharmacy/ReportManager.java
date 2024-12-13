public class ReportManager {
    public void reportMenu() {
        boolean keepReportMenu = true;

        ReportController reportController = new ReportController();

        while (keepReportMenu) {
            System.out.println("\n--------Report Menu--------");
            System.out.println("1. Sales Report");
            System.out.println("2. Inventory Report");
            System.out.println("3. View Product List");
            System.out.println("4. View Supplier List");
            System.out.println("5. Back to Main Menu");
            System.out.println("--------------------------");

            // Get user input
            int choice = Utility.getInt(">>> ");
            Utility.userInput.nextLine(); // Consume the newline character

            // Clear the console
            Utility.clearScreen();

            // Create a switch statement to handle user input
            switch (choice) {
                case 1:
                    // Create a ReportController object and call its salesReport method
                    reportController.salesReport();
                    break;
                case 2:
                    // Create a ReportController object and call its inventoryReport method
                    reportController.inventoryReport();
                    break;
                case 3:
                    // Create a ReportController object and call its productList method
                    reportController.productList();
                    break;
                case 4:
                    // Create a ReportController object and call its supplierList method
                    reportController.supplierList();
                    break;
                case 5:
                    // Return to the main menu
                    System.out.println("Returning to Main Menu...");
                    keepReportMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
