import java.util.List;
import java.util.ArrayList;

interface Product {
    // Create Product interface that includes ID, name, price, quantity, and category, that gets and sets the values.
    int getProductID();
    String getProductName();
    double getProductPrice();
    int getProductQty();
    String getCategory();

    void setProduct(int ID, String name, double price, int quantity);
}

// Create Product Category classes (Electronics, Clothings, Toys, Furnitures) that implements the Product interface.
class Electronics implements Product {
    private int ID;
    private String name;
    private double price;
    private int quantity;
    private String category = "Electronics";

    // Set a dynamic list to store electronics products
    static List<Electronics> electronics = new ArrayList<>();

    // Constructor
    public Electronics(int ID, String name, double price, int quantity) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to addProducts from addProduct class
    public static void addProduct(int ID, String name, double price, int quantity) {
        //add product on the list
        electronics.add(new Electronics(ID, name, price, quantity));
        System.out.println("Product " + name + " with ID " + ID + " has been added successfully.");
    }



    // Method to view or display products from viewProducts class for electronics category
    public static void viewProducts() {
        // Check if there are any products in the electronics category
        if (electronics.size() == 0) {
            System.out.println("No products found in Electronics category.");
        }
        else {
            System.out.println("Products in Electronics category:");
            // Loop through the electronics list and display the products, one by one, one product per line in the console
            for (int i = 0; i < electronics.size(); i++) {
                Electronics product = electronics.get(i);
                System.out.println("ID: " + product.getProductID() + "|| Name: " + product.getProductName() + "|| Price: " + product.getProductPrice() + "|| Quantity: " + product.getProductQty());
            }
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
}
