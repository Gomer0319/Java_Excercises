package Report;

import java.util.*;
import LoginManager;
import AdminMenu;
import EmployeeMenu;
import Controllers.*;
import Products.*;
import Sales.*;

// Create an Inventory class that stores all products and their information and history of sales.
public class ViewReports {
    public void displayMenu() {
        // Scanner for user input
        Scanner reportsInput = new Scanner(System.in);

        boolean keepInventoryMenu = true;

        while (keepInventoryMenu) {
            // Use try-catch block to handle InputMismatchException
            try {
                // Display the inventory menu and get user input
                System.out.println("\n=============================================");
                System.out.println("                Inventory Menu              ");
                System.out.println("---------------------------------------------");
                System.out.println("1. View all products");
                System.out.println("2. View products by category");
                System.out.println("3. Search for a product");
                System.out.println("4. View sales history");
                System.out.println("5. Return to main menu");
                System.out.println("=============================================");
                System.out.print("Enter your choice: ");

                int choice = reportsInput.nextInt();

                switch (choice) {
                    case 1:
                        // View all products
                        System.out.println("\nViewing all products on stock.");
                        Electronics.viewProducts();
                        Clothings.viewProducts();
                        Toys.viewProducts();
                        Furnitures.viewProducts();
                        break;
                    case 2:
                        // View products by category
                        DisplayProducts displayProducts = new DisplayProducts();
                        displayProducts.displayProduct();
                        break;
                    case 3:
                        // Search for a product
                        SearchProduct searchProduct = new SearchProduct();
                        searchProduct.searchProduct();
                        break;
                    case 4:
                        // Go to sold products display
                        SoldProducts soldProducts = new SoldProducts();
                        soldProducts.displaySoldProducts();
                        break;
                    case 5:
                        // Return to main menu
                        System.out.println("\nReturning to Main Menu.");

                        // Check of logged user is admin or employee and go to appropriate menu
                        if (LoginManager.getloggedUser().equals("Admin")) {
                            AdminMenu adminMenu = new AdminMenu();
                            adminMenu.displayMenu();
                        } else if (LoginManager.getloggedUser().equals("Employee")) {
                            EmployeeMenu employeeMenu = new EmployeeMenu();
                            employeeMenu.displayMenu();
                        }
                        keepInventoryMenu = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number from the list.");
                reportsInput.next();
            }
        }
    }
}
