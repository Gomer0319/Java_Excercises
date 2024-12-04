import java.util.List;
import java.util.ArrayList;


// Create a Cart interface to store cart values in connection with sales and Products
interface Cart {
    // Create 
    int getProductID();
    int getProductQty();
    String getProductName();
    double getProductPrice();
    String getCategory();

    void setProduct(int ID, String name, double price, int quantity);
}

// Create an Electronics class that implements the Cart interface
class ElectronicsCart implements Cart {
    private int ID;
    private int quantity;
    private String name;
    private double price;
    private String category = "Electronics";

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
        // Deduct quantity of the item based on the ID in the quantity available in Electronics.electronics
        for (int i = 0; i < Electronics.electronics.size(); i++) {
            if (Electronics.electronics.get(i).getProductID() == ID) {
                Electronics.electronics.get(i).setProductQty(Electronics.electronics.get(i).getProductQty() - quantity);
            }

            // Check if the product is already in the cart
            boolean productExistsInCart = false;

            for (ElectronicsCart cartItem : electronicsCart) {
                if (cartItem.getProductID() == ID) {
                    // Update the quantity in the cart
                    cartItem.quantity += quantity;
                    System.out.println("\nProduct " + Electronics.electronics.get(i).getProductName() + " quantity updated in Electronics Cart successfully.");
                    productExistsInCart = true;
                    break;
                }
            }
            
            if (!productExistsInCart) {
                // Add the product to the electronics cart
                electronicsCart.add(new ElectronicsCart(ID, Electronics.electronics.get(i).getProductName(), Electronics.electronics.get(i).getProductPrice(), quantity));
                System.out.println("\nProduct " + Electronics.electronics.get(i).getProductName() + " added to Electronics Cart successfully.");
            }
            return;
        }
    }

    // Method that displays the products in the electronics cart
    public static void viewCart() {
        // Check if there are any products in the clothings cart
        if (electronicsCart.size() == 0) {
            System.out.println("\n -----");
        }
        else {
            // Display the products in the clothings cart
            for (int i = 0; i < electronicsCart.size(); i++) {
                // Display the product details with category
                System.out.println("|| Product ID: " + electronicsCart.get(i).getCategory() + electronicsCart.get(i).getProductID() + " || Product Name: " + electronicsCart.get(i).getProductName() + " || Product Price: $" + electronicsCart.get(i).getProductPrice() + " || Quantity: " + electronicsCart.get(i).getProductQty() + " ||");
            } 
        }
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
}

// Create an Clothings class that implements the Cart interface
class ClothingsCart implements Cart {
    private int ID;
    private int quantity;
    private String name;
    private double price;
    private String category = "Clothings";

    // Set a dynamic list to store clothing products
    static List<ClothingsCart> clothingsCart = new ArrayList<>();

    // Constructor
    public ClothingsCart(int ID, String name, double price, int quantity) {
        this.ID = ID;
        this.quantity = quantity;
        this.name = name;
        this.price = price;
    }

    // Method that adds products to the clothings cart
    public static void addedToCart(int ID, int quantity) {
        // Deduct quantity of the item based on the ID in the quantity available in Clothings.clothings
        for (int i = 0; i < Clothings.clothings.size(); i++) {
            if (Clothings.clothings.get(i).getProductID() == ID) {
                Clothings.clothings.get(i).setProductQty(Clothings.clothings.get(i).getProductQty() - quantity);
            }
            
             // Check if the product is already in the cart
             boolean productExistsInCart = false;

             for (ClothingsCart cartItem : clothingsCart) {
                 if (cartItem.getProductID() == ID) {
                     // Update the quantity in the cart
                     cartItem.quantity += quantity;
                     System.out.println("\nProduct " + Clothings.clothings.get(i).getProductName() + " quantity updated in Electronics Cart successfully.");
                     productExistsInCart = true;
                     break;
                 }
             }
             
             if (!productExistsInCart) {
                 // Add the product to the electronics cart
                 clothingsCart.add(new ClothingsCart(ID, Clothings.clothings.get(i).getProductName(), Clothings.clothings.get(i).getProductPrice(), quantity));
                 System.out.println("\nProduct " + Clothings.clothings.get(i).getProductName() + " added to Electronics Cart successfully.");
             }
             return;
        }
    }

    // Method that displays the products in the clothings cart
    public static void viewCart() {
        // Check if there are any products in the clothings cart
        if (clothingsCart.size() == 0) {
            System.out.println("\n -----");
        }
        else {
            // Display the products in the clothings cart
            for (int i = 0; i < clothingsCart.size(); i++) {
                // Display the product details
                System.out.println("|| Product ID: " + clothingsCart.get(i).getCategory() + clothingsCart.get(i).getProductID() + " || Product Name: " + clothingsCart.get(i).getProductName() + " || Product Price: $" + clothingsCart.get(i).getProductPrice() + " || Quantity: " + clothingsCart.get(i).getProductQty() + " ||");
            } 
        }
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
}