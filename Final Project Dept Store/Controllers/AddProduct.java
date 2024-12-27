package Controllers;

import java.util.*;
import Products.*;

// Create add product class where we can add products to the system. (Products
// will include ID, name, price, quantity, and category)
public class AddProduct {
    // Create a scanner object to read user input
    Scanner addProductInput = new Scanner(System.in);

    // Create add product menu
    public void addProduct() {
        // try-catch block to handle InputMismatchException
        try {
            System.out.println("\n=============================================");
            System.out.println("Add Product");
            System.out.println("---------------------------------------------");
            System.out.println(
                    "Select product category: \n1. Electronics\n2. Clothings\n3. Toys\n4. Furnitures \n5. Return");
            System.out.print(">>> ");
            int productCategory = addProductInput.nextInt();
            addProductInput.nextLine(); // Consume the newline character
            System.out.print("Enter product ID: ");
            int productID = addProductInput.nextInt();
            addProductInput.nextLine();
            System.out.print("Enter product name: ");
            String productName = addProductInput.nextLine();
            System.out.print("Enter product price: ");
            double productPrice = addProductInput.nextDouble();
            System.out.print("Enter product quantity: ");
            int productQty = addProductInput.nextInt();

            // Check if the product category is valid
            if (productCategory == 1) {
                // Add product to electronics array
                Electronics.addProduct(productID, productName, productPrice, productQty);
            } else if (productCategory == 2) {
                // Add product to clothings array
                Clothings.addProduct(productID, productName, productPrice, productQty);
            } else if (productCategory == 3) {
                // Add product to toys array
                Toys.addProduct(productID, productName, productPrice, productQty);
            } else if (productCategory == 4) {
                // Add product to furnitures array
                Furnitures.addProduct(productID, productName, productPrice, productQty);
            } else if (productCategory == 5) {
                // Return to display menu
                System.out.println("\nReturning...\n");
                ManageProducts manageProducts = new ManageProducts();
                manageProducts.displayMenu();
            } else {
                System.out.println("Invalid product category input.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid input.");
            addProductInput.next();
        }
    }
}
