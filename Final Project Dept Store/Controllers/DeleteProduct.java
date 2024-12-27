package Controllers;

import java.util.*;
import Products.*;

// Create a class to Delete a product on a certain category (Electronics,
// Clothings, Toys, Furnitures)
public class DeleteProduct {
    // Create a scanner object to read user input
    Scanner deleteProductInput = new Scanner(System.in);

    // Ask user for product category
    public void deleteProduct() {
        // try-catch block to handle InputMismatchException
        try {
            System.out.println("\nSelect product category: \n1. Electronics\n2. Clothings\n3. Toys\n4. Furnitures");
            System.out.print(">>> ");
            int productCategory = deleteProductInput.nextInt();

            // Check if the product category is valid
            if (productCategory == 1) {
                // Ask for the product ID input
                System.out.print("\nEnter the Product Number of the item to be deleted: ");
                int productID = deleteProductInput.nextInt();

                // Pass the productID to deleteProduct
                Electronics.deleteProduct(productID);
            } else if (productCategory == 2) {
                // Ask for the product ID input
                System.out.print("\nEnter the Product Number of the item to be deleted: ");
                int productID = deleteProductInput.nextInt();

                // Pass the productID to deleteProduct
                Clothings.deleteProduct(productID);
            } else if (productCategory == 3) {
                // Ask for the product ID input
                System.out.print("\nEnter the Product Number of the item to be deleted: ");
                int productID = deleteProductInput.nextInt();

                // Pass the productID to deleteProduct
                Toys.deleteProduct(productID);
            } else if (productCategory == 4) {
                // Ask for the product ID input
                System.out.print("\nEnter the Product Number of the item to be deleted: ");
                int productID = deleteProductInput.nextInt();

                // Pass the productID to deleteProduct
                Furnitures.deleteProduct(productID);
            } else {
                System.out.println("Invalid product category input.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number from the list.");
            deleteProductInput.next();
        }
    }
}
