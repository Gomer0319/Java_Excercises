package Controllers;

import java.util.*;
import Products.*;
import Report.*;

// Create a class to Search for a product on a certain category (Electronics,
// Clothings, Toys, Furnitures) by traverse the array and check if the product
// ID or product name is equal to the user input
public class SearchProduct {
    // Create a scanner object to read user input
    Scanner searchProductInput = new Scanner(System.in);

    boolean found = false;
    boolean keepSearching = true;

    public void searchProduct() {
        try {
            while (keepSearching) {
                // Ask user for product category
                System.out.println(
                        "\nSelect product category: \n1. Electronics\n2. Clothings\n3. Toys\n4. Furnitures \n5. Return");
                System.out.print(">>> ");
                int productCategory = searchProductInput.nextInt();

                // Check if the product category is valid
                if (productCategory == 1) {
                    // Ask for the product ID input or product name
                    System.out.println(
                            "\nHow would you like to search for the product?\n1. Product ID\n2. Product Name: ");
                    System.out.print(">>> ");
                    int searchOption = searchProductInput.nextInt();
                    searchProductInput.nextLine(); // Consume the newline character

                    if (searchOption == 1) {
                        // Ask for the product ID input
                        System.out.print("\nEnter the Product Number of the item to be searched: ");
                        int productID = searchProductInput.nextInt();

                        // Traverse the array and check if the product ID matches the user input
                        for (Electronics product : Electronics.electronics) {
                            if (product.getProductID() == productID) {
                                // Display the product details
                                System.out.println("\nProduct Details: ");
                                System.out.printf("||  %-20s || %-40s || %-20s || %-30s ||%n", "ID", "Product Name",
                                        "Quantity", "Price");
                                System.out.printf("||  %-20s || %-40s || %-20s || %30.2f ||%n", product.getProductID(),
                                        product.getProductName(), product.getProductQty(), product.getProductPrice());
                                found = true;
                                break;
                            }
                            if (!found) {
                                // If the product ID is not found, print a message
                                System.out.println(
                                        "Product with ID " + productID + " not found in Electronics category.");
                            }
                        }
                    } else if (searchOption == 2) {
                        // Ask for the product name input
                        System.out.print("\nEnter the Product Name of the item to be searched: ");
                        String productName = searchProductInput.nextLine();

                        // Traverse the array and check if the product name matches the user input
                        for (Electronics product : Electronics.electronics) {
                            if (product.getProductName().equalsIgnoreCase(productName)) {
                                // Display the product details
                                System.out.println("\nProduct Details: ");
                                System.out.printf("||  %-20s || %-40s || %-20s || %-30s ||%n", "ID", "Product Name",
                                        "Quantity", "Price");
                                System.out.printf("||  %-20s || %-40s || %-20s || %30.2f ||%n", product.getProductID(),
                                        product.getProductName(), product.getProductQty(), product.getProductPrice());
                                found = true;
                                break;
                            }
                            if (!found) {
                                // If the product name is not found, print a message
                                System.out.println(
                                        "Product with name " + productName + " not found in Electronics category.");
                            }
                        }
                    }
                } else if (productCategory == 2) {
                    // Ask for the product ID input or product name
                    System.out.println(
                            "\nHow would you like to search for the product?\n1. Product ID\n2. Product Name: ");
                    System.out.print(">>> ");
                    int searchOption = searchProductInput.nextInt();
                    searchProductInput.nextLine(); // Consume the newline character

                    if (searchOption == 1) {
                        // Ask for the product ID input
                        System.out.print("\nEnter the Product Number of the item to be searched: ");
                        int productID = searchProductInput.nextInt();

                        // Traverse the array and check if the product ID matches the user input
                        for (Clothings product : Clothings.clothings) {
                            if (product.getProductID() == productID) {
                                // Display the product details
                                System.out.println("\nProduct Details: ");
                                System.out.printf("||  %-20s || %-40s || %-20s || %-30s ||%n", "ID", "Product Name",
                                        "Quantity", "Price");
                                System.out.printf("||  %-20s || %-40s || %-20s || %30.2f ||%n", product.getProductID(),
                                        product.getProductName(), product.getProductQty(), product.getProductPrice());
                                found = true;
                                break;
                            }
                            if (!found) {
                                // If the product ID is not found, print a message
                                System.out
                                        .println("Product with ID " + productID + " not found in Clothings category.");
                            }
                        }
                    } else if (searchOption == 2) {
                        // Ask for the product name input
                        System.out.print("\nEnter the Product Name of the item to be searched: ");
                        String productName = searchProductInput.nextLine();

                        // Traverse the array and check if the product name matches the user input
                        for (Clothings product : Clothings.clothings) {
                            if (product.getProductName().equalsIgnoreCase(productName)) {
                                // Display the product details
                                System.out.println("\nProduct Details: ");
                                System.out.printf("||  %-20s || %-40s || %-20s || %-30s ||%n", "ID", "Product Name",
                                        "Quantity", "Price");
                                System.out.printf("||  %-20s || %-40s || %-20s || %30.2f ||%n", product.getProductID(),
                                        product.getProductName(), product.getProductQty(), product.getProductPrice());
                                found = true;
                                break;
                            }
                            if (!found) {
                                // If the product name is not found, print a message
                                System.out.println(
                                        "Product with name " + productName + " not found in Clothings category.");
                            }
                        }
                    }
                } else if (productCategory == 3) {
                    // Ask for the product ID input or product name
                    System.out.println(
                            "\nHow would you like to search for the product?\n1. Product ID\n2. Product Name: ");
                    System.out.print(">>> ");
                    int searchOption = searchProductInput.nextInt();
                    searchProductInput.nextLine(); // Consume the newline character

                    if (searchOption == 1) {
                        // Ask for the product ID input
                        System.out.print("\nEnter the Product Number of the item to be searched: ");
                        int productID = searchProductInput.nextInt();

                        // Traverse the array and check if the product ID matches the user input
                        for (Toys product : Toys.toys) {
                            if (product.getProductID() == productID) {
                                // Display the product details
                                System.out.println("\nProduct Details: ");
                                System.out.printf("||  %-20s || %-40s || %-20s || %-30s ||%n", "ID", "Product Name",
                                        "Quantity", "Price");
                                System.out.printf("||  %-20s || %-40s || %-20s || %30.2f ||%n", product.getProductID(),
                                        product.getProductName(), product.getProductQty(), product.getProductPrice());
                                found = true;
                                break;
                            }
                            if (!found) {
                                // If the product ID is not found, print a message
                                System.out.println("Product with ID " + productID + " not found in Toys category.");
                            }
                        }
                    } else if (searchOption == 2) {
                        // Ask for the product name input
                        System.out.print("\nEnter the Product Name of the item to be searched: ");
                        String productName = searchProductInput.nextLine();

                        // Traverse the array and check if the product name matches the user input
                        for (Toys product : Toys.toys) {
                            if (product.getProductName().equalsIgnoreCase(productName)) {
                                // Display the product details
                                System.out.println("\nProduct Details: ");
                                System.out.printf("||  %-20s || %-40s || %-20s || %-30s ||%n", "ID", "Product Name",
                                        "Quantity", "Price");
                                System.out.printf("||  %-20s || %-40s || %-20s || %30.2f ||%n", product.getProductID(),
                                        product.getProductName(), product.getProductQty(), product.getProductPrice());
                                found = true;
                                break;
                            }
                            if (!found) {
                                // If the product name is not found, print a message
                                System.out.println("Product with name " + productName + " not found in Toys category.");
                            }
                        }
                    }
                } else if (productCategory == 4) {
                    // Ask for the product ID input or product name
                    System.out.println(
                            "\nHow would you like to search for the product?\n1. Product ID\n2. Product Name: ");
                    System.out.print(">>> ");
                    int searchOption = searchProductInput.nextInt();
                    searchProductInput.nextLine(); // Consume the newline character

                    if (searchOption == 1) {
                        // Ask for the product ID input
                        System.out.print("\nEnter the Product Number of the item to be searched: ");
                        int productID = searchProductInput.nextInt();

                        // Traverse the array and check if the product ID matches the user input
                        for (Furnitures product : Furnitures.furnitures) {
                            if (product.getProductID() == productID) {
                                // Display the product details
                                System.out.println("\nProduct Details: ");
                                System.out.printf("||  %-20s || %-40s || %-20s || %-30s ||%n", "ID", "Product Name",
                                        "Quantity", "Price");
                                System.out.printf("||  %-20s || %-40s || %-20s || %30.2f ||%n", product.getProductID(),
                                        product.getProductName(), product.getProductQty(), product.getProductPrice());
                                found = true;
                                break;
                            }
                            if (!found) {
                                // If the product ID is not found, print a message
                                System.out
                                        .println("Product with ID " + productID + " not found in Furnitures category.");
                            }
                        }
                    } else if (searchOption == 2) {
                        // Ask for the product name input
                        System.out.print("\nEnter the Product Name of the item to be searched: ");
                        String productName = searchProductInput.nextLine();

                        // Traverse the array and check if the product name matches the user input
                        for (Furnitures product : Furnitures.furnitures) {
                            if (product.getProductName().equalsIgnoreCase(productName)) {
                                // Display the product details
                                System.out.println("\nProduct Details: ");
                                System.out.printf("||  %-20s || %-30s || %-10s || %-15s ||%n", "ID", "Product Name",
                                        "Quantity", "Price");
                                System.out.printf("||  %-20s || %-30s || %-20s || %20.2f ||%n", product.getProductID(),
                                        product.getProductName(), product.getProductQty(), product.getProductPrice());
                                found = true;
                                break;
                            }
                            if (!found) {
                                // If the product name is not found, print a message
                                System.out.println(
                                        "Product with name " + productName + " not found in Furnitures category.");
                                break;
                            }
                        }
                    }
                } else if (productCategory == 5) {
                    // Return to ViewReports display menu
                    System.out.println("\nReturning to View Reports menu...");
                    keepSearching = false;
                    ViewReports viewReports = new ViewReports();
                    viewReports.displayMenu();
                    break;
                } else {
                    // If the product category is not found, print a message
                    System.out.println("Invalid product category. Please try again.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number from the list.");
            searchProductInput.next(); // Consume the invalid input
        }
    }
}
