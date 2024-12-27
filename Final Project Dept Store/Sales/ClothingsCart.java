package Sales;

import java.util.*;

import Products.*;

// Create an Clothings class that implements the Cart interface
public class ClothingsCart implements Cart {
    private int ID;
    private int quantity;
    private String name;
    private double price;
    private String category = "Clothings";
    private double totalCost;

    // Set a dynamic list to store clothing products
    public static List<ClothingsCart> clothingsCart = new ArrayList<>();

    // Constructor
    public ClothingsCart(int ID, String name, double price, int quantity) {
        this.ID = ID;
        this.quantity = quantity;
        this.name = name;
        this.price = price;
    }

    // Method that adds products to the clothings cart
    public static void addedToCart(int ID, int quantity) {
        boolean found = false;

        // Check if the product is already in the clothings cart
        for (ClothingsCart cartItem : clothingsCart) {
            if (cartItem.getProductID() == ID) {
                // Deduct quantity of the item based on the ID in the quantity available
                for (Product product : Clothings.clothings) {
                    if (product.getProductID() == ID) {
                        product.setProductQty(product.getProductQty() - quantity);
                        break;
                    }
                }
                // Update the quantity in the cart
                cartItem.setProductQty(cartItem.getProductQty() + quantity);
                System.out.println("\nProduct (" + quantity + ") " + cartItem.getProductName()
                        + " added to Clothings Cart successfully.");
                found = true;
                break;
            }
        }
        // If the product is not yet in the clothings cart, add it
        if (!found) {
            for (Product product : Clothings.clothings) {
                if (product.getProductID() == ID) {
                    // Deduct quantity of the item based on the ID in the quantity available
                    product.setProductQty(product.getProductQty() - quantity);

                    // Add the product to the electronics cart
                    ClothingsCart newCartItem = new ClothingsCart(ID, product.getProductName(),
                            product.getProductPrice(), quantity);
                    clothingsCart.add(newCartItem);
                    System.out.println("\nProduct (" + quantity + ") " + product.getProductName()
                            + " added to Clothings Cart successfully.");
                    break;
                }
            }
        }
    }

    // Method that displays the products in the clothings cart
    public static void viewCart() {
        // Check if there are any products in the clothings cart
        if (clothingsCart.size() == 0) {
            // If there are none, leave the space with no print
            return;
        } else {
            // Display the products in the clothings cart
            for (int i = 0; i < clothingsCart.size(); i++) {
                // Display the product details
                System.out.printf("|| %-20s || %-40s || %-20d || %30.2f ||%n",
                        clothingsCart.get(i).getCategory() + clothingsCart.get(i).getProductID(),
                        clothingsCart.get(i).getProductName(), clothingsCart.get(i).getProductQty(),
                        clothingsCart.get(i).getProductPrice() * clothingsCart.get(i).getProductQty());
            }
        }
    }

    // Method that calculates the total cost of the clothings cart
    public static double calculateTotalCost() {
        // Reset the total cost
        double totalCost = 0.0;

        // Calculate the total cost of the products in the clothings cart
        for (int i = 0; i < clothingsCart.size(); i++) {
            totalCost += clothingsCart.get(i).getProductPrice() * clothingsCart.get(i).getProductQty();
        }
        return totalCost;
    }

    // Create a method to empty the clothings cart if the purchase is successful
    public static void emptyCart() {
        clothingsCart.clear();
    }

    // implement interface methods
    @Override
    public int getProductID() {
        return ID;
    }

    @Override
    public int getProductQty() {
        return quantity;
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
    public String getCategory() {
        return category;
    }

    @Override
    public void setProductQty(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void setProduct(int ID, String name, double price, int quantity) {
        this.ID = ID;
        this.quantity = quantity;
        this.name = name;
        this.price = price;
    }

    @Override
    public double getTotalCost() {
        return totalCost;
    }
}