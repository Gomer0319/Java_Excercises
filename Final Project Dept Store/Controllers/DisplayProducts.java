package Controllers;

import java.util.*;
import Products.*;

// Create a class to display products according to category requested
// (Electronics, Clothings, Toys, Furnitures)
public class DisplayProducts {
    // Create a scanner object to read user input
    Scanner displayProductInput = new Scanner(System.in);

    // Ask user for product category
    public void displayProduct() {
        // try-catch block to handle InputMismatchException
        try {
            System.out.println("\nSelect product category: \n1. Electronics\n2. Clothings\n3. Toys\n4. Furnitures: ");
            System.out.print(">>> ");
            int productCategory = displayProductInput.nextInt();

            // Display products according to category requested
            switch (productCategory) {
                case 1:
                    Electronics.viewProducts();
                    break;
                case 2:
                    Clothings.viewProducts();
                    break;
                case 3:
                    Toys.viewProducts();
                    break;
                case 4:
                    Furnitures.viewProducts();
                    break;
                default:
                    System.out.println("Invalid product category.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number from the list.");
            displayProductInput.next();
        }
    }
}
