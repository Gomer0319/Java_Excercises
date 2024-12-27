package Products;

import java.util.*;
import Controllers.*;

// Create manage products class where we add, edit(update), view and delete products. (Products will include ID, name, price, quantity, and category)
public class ManageProducts {
    // Create a scanner object to read user input
    Scanner productInput = new Scanner(System.in);

    // Create menu for manage products
    public void displayMenu() {
        // Create a boolean variable to check if the admin wants to keep managing
        // products until they choose to return to admin menu
        boolean keepManaging = true;

        while (keepManaging) {
            // try-catch block to handle InputMismatchException
            try {
                System.out.println("\n=============================================");
                System.out.println("Manage Products");
                System.out.println("---------------------------------------------");
                System.out.println("1. Add Product");
                System.out.println("2. Edit Product");
                System.out.println("3. View Products");
                System.out.println("4. Delete Product");
                System.out.println("5. Return to Main Menu");
                System.out.println("=============================================");
                System.out.print("Enter your choice: ");

                int productOption = productInput.nextInt();

                // Check if the admin wants to add, edit, view, delete, or return to admin menu
                switch (productOption) {
                    case 1:
                        // Go to Add product menu
                        AddProduct addProduct = new AddProduct();
                        addProduct.addProduct();
                        break;
                    case 2:
                        // Go to Update product menu
                        UpdateProduct updateProduct = new UpdateProduct();
                        updateProduct.updateProduct();
                        break;
                    case 3:
                        // Go to View Products menu
                        DisplayProducts displayProducts = new DisplayProducts();
                        displayProducts.displayProduct();
                        break;
                    case 4:
                        // Go to Delete product menu
                        DeleteProduct deleteProduct = new DeleteProduct();
                        deleteProduct.deleteProduct();
                        break;
                    case 5:
                        // Return to admin menu
                        System.out.println("\nReturning to Admin Menu. \n");
                        keepManaging = false;
                        break;
                    default:
                        System.out.println("\nInvalid choice. Please try again.\n");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a number.\n");
                productInput.next(); // Consume the invalid input
            }
        }
    }
}

// Note: This can be refined/refactored to make it more efficient