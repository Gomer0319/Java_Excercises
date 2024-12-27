package Sales;

import java.util.*;

import Products.*;

// Create an Furniture class that implements the Cart interface
public class FurnituresCart implements Cart {
    private int ID;
    private int quantity;
    private String name;
    private double price;
    private String category = "Furnitures";
    private double totalCost = 0.0;

    // Set a dynamic list to store furnitures products
    public static List<FurnituresCart> furnituresCart = new ArrayList<>();

    // Constructor
    public FurnituresCart(int ID, String name, double price, int quantity) {
        this.ID = ID;
        this.quantity = quantity;
        this.name = name;
        this.price = price;
    }

    // Method that adds products to the furnitures cart
    public static void addedToCart(int ID, int quantity) {
        boolean found = false;

        // Check if the product is already in the furnitures cart
        for (FurnituresCart cartItem : furnituresCart) {
            if (cartItem.getProductID() == ID) {
                // Deduct quantity of the item based on the ID in the quantity available
                for (Product product : Furnitures.furnitures) {
                    if (product.getProductID() == ID) {
                        product.setProductQty(product.getProductQty() - quantity);
                        break;
                    }
                }
                // Update the quantity in the cart
                cartItem.setProductQty(cartItem.getProductQty() + quantity);
                System.out.println("\nProduct (" + quantity + ") " + cartItem.getProductName()
                        + " added to Furnitures Cart successfully.");
                found = true;
                break;
            }
        }
        // If the product is not yet in the furnitures cart, add it
        if (!found) {
            for (Product product : Furnitures.furnitures) {
                if (product.getProductID() == ID) {
                    // Deduct quantity of the item based on the ID in the quantity available
                    product.setProductQty(product.getProductQty() - quantity);

                    // Add the product to the electronics cart
                    FurnituresCart newCartItem = new FurnituresCart(ID, product.getProductName(),
                            product.getProductPrice(), quantity);
                    furnituresCart.add(newCartItem);
                    System.out.println("\nProduct (" + quantity + ") " + product.getProductName()
                            + " added to Furnitures Cart successfully.");
                    break;
                }
            }
        }
    }

    // Method that displays the products in the furnitures cart
    public static void viewCart() {
        // Check if there are any products in the furnitures cart
        if (furnituresCart.size() == 0) {
            // If there are none, leave the space with no print
            return;
        } else {
            // Display the products in the furnitures cart
            for (int i = 0; i < furnituresCart.size(); i++) {
                // Display the product details with category
                System.out.printf("|| %-20s || %-40s || %-20d || %30.2f ||%n",
                        furnituresCart.get(i).getCategory() + furnituresCart.get(i).getProductID(),
                        furnituresCart.get(i).getProductName(), furnituresCart.get(i).getProductQty(),
                        furnituresCart.get(i).getProductPrice() * furnituresCart.get(i).getProductQty());
            }
        }
    }

    // Create a method to calculate the total cost of the furnitures cart
    public static double calculateTotalCost() {
        // Reset the total cost
        double totalCost = 0.0;

        // Calculate the total cost of the products in the toys cart
        for (int i = 0; i < furnituresCart.size(); i++) {
            totalCost += furnituresCart.get(i).getProductPrice() * furnituresCart.get(i).getProductQty();
        }
        return totalCost;
    }

    // Create a method to empty the furnitures cart if the purchase is successful
    public static void emptyCart() {
        furnituresCart.clear();
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
    public void setProduct(int ID, String name, double price, int quantity) {
        this.ID = ID;
        this.quantity = quantity;
        this.name = name;
        this.price = price;
    }

    @Override
    public void setProductQty(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getTotalCost() {
        return totalCost;
    }
}