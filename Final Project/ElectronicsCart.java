import java.util.*;

// Create an Electronics class that implements the Cart interface
class ElectronicsCart implements Cart {
    private int ID;
    private int quantity;
    private String name;
    private double price;
    private String category = "Electronics";
    private double totalCost = 0.0;

    // Set a dynamic list to store electronics products
    static List<ElectronicsCart> electronicsCart = new ArrayList<>();

    // Constructor
    public ElectronicsCart(int ID, String name, double price, int quantity) {
        this.ID = ID;
        this.quantity = quantity;
        this.name = name;
        this.price = price;
    }

    // Method that adds products to the electronics cart
    public static void addedToCart(int ID, int quantity) {
        boolean found = false;

        // Check if the product is already in the electronics cart
        for (ElectronicsCart cartItem : electronicsCart) {
            if (cartItem.getProductID() == ID) {
                // Deduct quantity of the item based on the ID in the quantity available
                for (Product product : Electronics.electronics) {
                    if (product.getProductID() == ID) {
                        product.setProductQty(product.getProductQty() - quantity);
                        break;
                    }
                }
                // Update the quantity in the cart
                cartItem.setProductQty(cartItem.getProductQty() + quantity);
                System.out.println("\nProduct (" + quantity + ") " + cartItem.getProductName() + " added to Electronics Cart successfully.");
                found = true;
                break;
            }
        }
        // If the product is not yet in the electronics cart, add it
        if (!found) {
            for (Product product : Electronics.electronics) {
                if (product.getProductID() == ID) {
                    // Deduct quantity of the item based on the ID in the quantity available
                    product.setProductQty(product.getProductQty() - quantity);
                    
                    // Add the product to the electronics cart
                    ElectronicsCart newCartItem = new ElectronicsCart(ID, product.getProductName(), product.getProductPrice(), quantity);
                    electronicsCart.add(newCartItem);
                    System.out.println("\nProduct (" + quantity + ") " + product.getProductName() + " added to Electronics Cart successfully.");
                    break;
                }
            }
        }
    }

    // Method that displays the products in the electronics cart
    public static void viewCart() {
        // Check if there are any products in the electronics cart
        if (electronicsCart.size() == 0) {
            // If there are none, leave the space with no print
            return;
        }
        else {
            // Display the products in the electronics cart
            for (int i = 0; i < electronicsCart.size(); i++) {
                // Display the product details with category
                System.out.printf("|| %-20s || %-30s || %-10d || %-15f ||%n", electronicsCart.get(i).getCategory() + electronicsCart.get(i).getProductID(), electronicsCart.get(i).getProductName(),  electronicsCart.get(i).getProductQty(), electronicsCart.get(i).getProductPrice() * electronicsCart.get(i).getProductQty());
            } 
        }
    }

    // Create a method to calculate the total cost of the electronics cart
    public static double calculateTotalCost() {
        // Reset the total cost
        double totalCost = 0.0;

        // Calculate the total cost of the products in the electronics cart
        for (int i = 0; i < electronicsCart.size(); i++) {
            totalCost += electronicsCart.get(i).getProductPrice() * electronicsCart.get(i).getProductQty();
        }
        return totalCost;
    }

    // Create a method to empty the electronics cart if the purchase is successful
    public static void emptyCart() {
        electronicsCart.clear();
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