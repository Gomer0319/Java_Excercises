package Products;

import java.util.*;
import Sales.*;

// Create Clothings class that implements the Product interface
public class Clothings implements Product {
    private int ID;
    private String name;
    private double price;
    private int quantity;
    private String category = "Clothings";

    // Set a dynamic list to store clothing products
    public static List<Clothings> clothings = new ArrayList<>();

    // Constructor
    public Clothings(int ID, String name, double price, int quantity) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to addProducts from addProduct class
    public static void addProduct(int ID, String name, double price, int quantity) {
        // Check if there is a product with the same ID
        for (int i = 0; i < clothings.size(); i++) {
            Clothings product = clothings.get(i);
            if (product.getProductID() == ID) {
                System.out.println("Product with ID " + ID + " already exists in Clothings category.");
                return;
            }
            // Check if there is a product with the same name through else if statement
            else if (product.getProductName().equals(name)) {
                System.out.println("Product with name " + name + " already exists in Clothings category.");
                return;
            }
            // if the ID and name are unique, continue to add the product
            else {
                continue;
            }
        }
        // Add the product to the clothings list
        clothings.add(new Clothings(ID, name, price, quantity));
        System.out.println("Product " + name + " with ID " + ID + " has been added successfully.");
    }

    // Method to update Products
    public static void editProduct(int ID) {
        // Create a Scanner object to get user input
        Scanner updateProductInput = new Scanner(System.in);

        // Add boolean to check if the admin user wants to keep on editing,else return
        // to manage products
        boolean keepEditing = true;

        // Check if there are any products in the clothings category based on the
        // product ID
        for (int i = 0; i < clothings.size(); i++) {
            Clothings product = clothings.get(i);
            if (product.getProductID() == ID) {
                System.out.println("\nProduct found with ID " + ID + " in Clothings category\n");

                // Keep editing the product until the admin user wants to return to manage
                // products
                while (keepEditing) {
                    // if the product is found, ask what values of the product to be updated
                    System.out.println(
                            "\nWhat values of the product to be updated: \n1. Name \n2. Price \n3. Quantity: \n4. Return to Manage Products");
                    System.out.print(">>> ");
                    int choice = updateProductInput.nextInt();
                    // consume the newline character left in the input buffer
                    updateProductInput.nextLine();

                    // update the values of the product
                    if (choice == 1) {
                        System.out.println("\nEnter the new name: ");
                        String newName = updateProductInput.nextLine();
                        product.setProduct(ID, newName, product.getProductPrice(), product.getProductQty());
                        System.out.println("\nProduct name for ID " + ID + " updated successfully.");
                    } else if (choice == 2) {
                        System.out.println("\nEnter the new price: ");
                        double newPrice = updateProductInput.nextDouble();
                        product.setProduct(ID, product.getProductName(), newPrice, product.getProductQty());
                        System.out
                                .println("\nProduct price for " + product.getProductName() + " updated successfully.");
                    } else if (choice == 3) {
                        System.out.println("\nEnter the new quantity: ");
                        int newQuantity = updateProductInput.nextInt();
                        product.setProduct(ID, product.getProductName(), product.getProductPrice(), newQuantity);
                        System.out.println(
                                "\nProduct quantity for " + product.getProductName() + " updated successfully.");
                    } else if (choice == 4) {
                        // Return to Manage Products display menu
                        keepEditing = false;
                        ManageProducts manageProducts = new ManageProducts();
                        manageProducts.displayMenu();
                    } else {
                        System.out.println("\nInvalid choice.");
                    }
                }
            }
            // If the product is not found, print a message
            else {
                System.out.println("Product with ID " + ID + " not found in Clothings category.");
            }
        }
    }

    // Method to delete product
    public static void deleteProduct(int ID) {
        // Check if there are any products in the clothings category based on the
        // product ID
        for (int i = 0; i < clothings.size(); i++) {
            Clothings product = clothings.get(i);

            // If the product is found, delete it
            if (product.getProductID() == ID) {
                clothings.remove(i);
                System.out.println("Product with ID " + ID + " with name " + product.getProductName()
                        + " has been deleted successfully from Clothings category.");
                return;
            }
        }
        // If the product is not found, print a message
        System.out.println("Product with ID " + ID + " not found in Clothings category.");
    }

    // Method to return product if the purchase is cancelled
    public static void returnProduct() {
        // Check if there are items in the electronics cart
        if (ClothingsCart.clothingsCart.isEmpty()) {
            System.out.println("No items in the Clothings cart to return.");
            return;
        }

        // Iterate through each item in the cart
        for (ClothingsCart cartItem : ClothingsCart.clothingsCart) {
            boolean productFound = false;
            for (Clothings product : clothings) {
                // Match the product ID
                if (product.getProductID() == cartItem.getProductID()) {
                    // Return the quantity from the cart to the inventory
                    product.setProductQty(product.getProductQty() + cartItem.getProductQty());
                    productFound = true;
                    break;
                }
            }
            if (!productFound) {
                System.out.println(
                        "Product with ID " + cartItem.getProductID() + " not found in inventory. Unable to return.");
            }
        }
        System.out.println("Clothings cart items have been returned to inventory.");
    }

    // Method to view or display products from viewProducts class for clothings
    // category
    public static void viewProducts() {
        // Check if there are any products in the clothings category
        if (clothings.size() == 0) {
            System.out.println("No products found in Clothings category.");
        } else {
            System.out.println(
                    "\n==========================================================================================================================================================");
            System.out.println("Products in Clothings category:");
            System.out.printf("|| %-20s || %-40s || %-30s || %-20s ||\n", "ID", "Product Name", "Price", "Quantity");
            System.out.println(
                    "----------------------------------------------------------------------------------------------------------------------------------------------------------");
            // Loop through the clothings list and display the products, one by one, one
            // product per line in the console
            for (int i = 0; i < clothings.size(); i++) {
                Clothings product = clothings.get(i);
                System.out.printf("|| %-20d || %-40s || %30.2f || %-20d ||\n", product.getProductID(),
                        product.getProductName(), product.getProductPrice(), product.getProductQty());
            }
            System.out.println(
                    "\n==========================================================================================================================================================");
        }
    }

    // Implement interface methods
    @Override
    public int getProductID() {
        return ID;
    }

    @Override
    public String getProductName() {
        return name;
    }

    @Override
    public double getProductPrice() {
        return price;
    }

    @Override
    public int getProductQty() {
        return quantity;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public void setProduct(int ID, String name, double price, int quantity) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public void setProductQty(int quantity) {
        this.quantity = quantity;
    }
}
