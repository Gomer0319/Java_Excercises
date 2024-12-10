import java.util.*;

// Create an Toys class that implements the Cart interface
class ToysCart implements Cart {
    private int ID;
    private int quantity;
    private String name;
    private double price;
    private String category = "Toys";
    private double totalCost = 0.0;

    // Set a dynamic list to store toys products
    static List<ToysCart> toysCart = new ArrayList<>();

    // Constructor
    public ToysCart(int ID, String name, double price, int quantity) {
        this.ID = ID;
        this.quantity = quantity;
        this.name = name;
        this.price = price;
    }

    // Method that adds products to the toys cart
    public static void addedToCart(int ID, int quantity) {
        boolean found = false;

        // Check if the product is already in the toys cart
        for (ToysCart cartItem : toysCart) {
            if (cartItem.getProductID() == ID) {
                // Deduct quantity of the item based on the ID in the quantity available
                for (Product product : Toys.toys) {
                    if (product.getProductID() == ID) {
                        product.setProductQty(product.getProductQty() - quantity);
                        break;
                    }
                }
                // Update the quantity in the cart
                cartItem.setProductQty(cartItem.getProductQty() + quantity);
                System.out.println("\nProduct (" + quantity + ") " + cartItem.getProductName() + " added to Toys Cart successfully.");
                found = true;
                break;
            }
        }
        // If the product is not yet in the toys cart, add it
        if (!found) {
            for (Product product : Toys.toys) {
                if (product.getProductID() == ID) {
                    // Deduct quantity of the item based on the ID in the quantity available
                    product.setProductQty(product.getProductQty() - quantity);
                    
                    // Add the product to the electronics cart
                    ToysCart newCartItem = new ToysCart(ID, product.getProductName(), product.getProductPrice(), quantity);
                    toysCart.add(newCartItem);
                    System.out.println("\nProduct (" + quantity + ") " + product.getProductName() + " added to Toys Cart successfully.");
                    break;
                }
            }
        }
    }

    // Method that displays the products in the toys cart
    public static void viewCart() {
        // Check if there are any products in the toys cart
        if (toysCart.size() == 0) {
            // If there are none, leave the space with no print
            return;
        }
        else {
            // Display the products in the toys cart
            for (int i = 0; i < toysCart.size(); i++) {
                // Display the product details with category
                System.out.printf("|| %-20s || %-40s || %-20d || %30.2f ||%n", toysCart.get(i).getCategory() + toysCart.get(i).getProductID(), toysCart.get(i).getProductName(),  toysCart.get(i).getProductQty(), toysCart.get(i).getProductPrice() * toysCart.get(i).getProductQty());
            } 
        }
    }

    // Create a method to calculate the total cost of the toys cart
    public static double calculateTotalCost() {
        // Reset the total cost
        double totalCost = 0.0;

        // Calculate the total cost of the products in the toys cart
        for (int i = 0; i < toysCart.size(); i++) {
            totalCost += toysCart.get(i).getProductPrice() * toysCart.get(i).getProductQty();
        }
        return totalCost;
    }

    // Create a method to empty the toys cart
    public static void emptyCart() {
        toysCart.clear();
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