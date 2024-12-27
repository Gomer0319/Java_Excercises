package Controllers;

import java.util.*;
import Products.*;

// Create a class to update/edit the values of a product on a certain category
// (Electronics, Clothings, Toys, Furnitures)
public class UpdateProduct {
    // Create a scanner object to read user input
    Scanner updateProductInput = new Scanner(System.in);

    // Ask user for product category
    public void updateProduct() {
        try {
            System.out.println("\nSelect product category: \n1. Electronics\n2. Clothings\n3. Toys\n4. Furnitures");
            System.out.print(">>> ");
            int productCategory = updateProductInput.nextInt();

            // Check if the product category is valid
            if (productCategory == 1) {
                // Ask for the product ID input
                System.out.print("\nEnter the Product Number of the item to be updated: ");
                int productID = updateProductInput.nextInt();

                // Pass the productID to editProduct
                Electronics.editProduct(productID);
            } else if (productCategory == 2) {
                // Ask for the product ID input
                System.out.print("\nEnter the Product Number of the item to be updated: ");
                int productID = updateProductInput.nextInt();

                // Pass the productID to editProduct
                Clothings.editProduct(productID);
            } else if (productCategory == 3) {
                // Ask for the product ID input
                System.out.print("\nEnter the Product Number of the item to be updated: ");
                int productID = updateProductInput.nextInt();

                // Pass the productID to editProduct
                Toys.editProduct(productID);
            } else if (productCategory == 4) {
                // Ask for the product ID input
                System.out.print("\nEnter the Product Number of the item to be updated: ");
                int productID = updateProductInput.nextInt();

                // Pass the productID to editProduct
                Furnitures.editProduct(productID);
            } else {
                System.out.println("Invalid product category input.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number from the list.");
            updateProductInput.next();
        }
    }
}
