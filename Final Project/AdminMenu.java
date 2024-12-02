import java.util.*;

// Create Admin menu class
class AdminMenu {
    // Create a scanner object to read user input
    Scanner adminInput = new Scanner(System.in);

    // Create menu for admin side
    public void displayMenu() {
        System.out.println("Admin Menu");
        System.out.println("1. Manage Products");
        System.out.println("2. Process Sales");
        System.out.println("3. View Reports");
        System.out.println("4. Logout");
        System.out.print("Enter your choice: ");

        int adminOption = adminInput.nextInt();

        // Check if the admin wants to manage products, process sales, view reports, or logout
        switch (adminOption) {
            case 1:
                // Manage products
                System.out.println("Manage Products");

                // Go to manage products menu
                break;
            case 2:
                // Process sales
                System.out.println("Process Sales");
                break;
            case 3:
                // View reports
                System.out.println("View Reports");
                break;
            case 4:
                // Logout
                System.out.println("You are logged out.\n");
                adminInput.close();
                break;
            default:
        }
    }
}