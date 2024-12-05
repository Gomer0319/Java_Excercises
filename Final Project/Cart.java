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
    double getTotalCost();

    void setProduct(int ID, String name, double price, int quantity);
    void setProductQty(int quantity);
}

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
                    System.out.println("\nProduct (" + quantity + ") " + Electronics.electronics.get(i).getProductName() + " added to Electronics Cart successfully.");
                    productExistsInCart = true;
                    break;
                }
            }
            
            if (!productExistsInCart) {
                // Add the product to the electronics cart
                electronicsCart.add(new ElectronicsCart(ID, Electronics.electronics.get(i).getProductName(), Electronics.electronics.get(i).getProductPrice(), quantity));
                System.out.println("\nProduct (" + quantity + ") " + Electronics.electronics.get(i).getProductName() + " added to Electronics Cart successfully.");
            }
            return;
        }
    }

    // Method that displays the products in the electronics cart
    public static void viewCart() {
        // Check if there are any products in the electronics cart
        if (electronicsCart.size() == 0) {
            System.out.println("\n -----");
        }
        else {
            // Display the products in the electronics cart
            for (int i = 0; i < electronicsCart.size(); i++) {
                // Display the product details with category
                System.out.println("|| Product ID: " + electronicsCart.get(i).getCategory() + electronicsCart.get(i).getProductID() + " || Product Name: " + electronicsCart.get(i).getProductName() + " || Product Unit Price: Php" + electronicsCart.get(i).getProductPrice() + " || Quantity: " + electronicsCart.get(i).getProductQty() + " ||");
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

// Create an Clothings class that implements the Cart interface
class ClothingsCart implements Cart {
    private int ID;
    private int quantity;
    private String name;
    private double price;
    private String category = "Clothings";
    private double totalCost;

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
        // Deduct quantity of the item based on the ID in the quantity available
        for (int i = 0; i < ClothingsCart.clothingsCart.size(); i++) {
            if (ClothingsCart.clothingsCart.get(i).getProductID() == ID) {
                ClothingsCart.clothingsCart.get(i).setProductQty(ClothingsCart.clothingsCart.get(i).getProductQty() - quantity);
            }

            // Check if the product is already in the cart
            boolean productExistsInCart = false;

            for (ClothingsCart cartItem : clothingsCart) {
                if (cartItem.getProductID() == ID) {
                    // Update the quantity in the cart
                    cartItem.quantity += quantity;
                    System.out.println("\nProduct (" + quantity + ") " + ClothingsCart.clothingsCart.get(i).getProductName() + " added to Clothings Cart successfully.");
                    productExistsInCart = true;
                    break;
                }
            }
            
            if (!productExistsInCart) {
                // Add the product to the clothings cart
                clothingsCart.add(new ClothingsCart(ID, ClothingsCart.clothingsCart.get(i).getProductName(), ClothingsCart.clothingsCart.get(i).getProductPrice(), quantity));
                System.out.println("\nProduct (" + quantity + ") " + ClothingsCart.clothingsCart.get(i).getProductName() + " added to Clothings Cart successfully.");
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
                System.out.println("|| Product ID: " + clothingsCart.get(i).getCategory() + clothingsCart.get(i).getProductID() + " || Product Name: " + clothingsCart.get(i).getProductName() + " || Product Unit Price: Php" + clothingsCart.get(i).getProductPrice() + " || Quantity: " + clothingsCart.get(i).getProductQty() + " ||");
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
        // Deduct quantity of the item based on the ID in the quantity available
        for (int i = 0; i < ToysCart.toysCart.size(); i++) {
            if (ToysCart.toysCart.get(i).getProductID() == ID) {
                ToysCart.toysCart.get(i).setProductQty(ToysCart.toysCart.get(i).getProductQty() - quantity);
            }

            // Check if the product is already in the cart
            boolean productExistsInCart = false;

            for (ToysCart cartItem : toysCart) {
                if (cartItem.getProductID() == ID) {
                    // Update the quantity in the cart
                    cartItem.quantity += quantity;
                    System.out.println("\nProduct (" + quantity + ") " + ToysCart.toysCart.get(i).getProductName() + " added to Toys Cart successfully.");
                    productExistsInCart = true;
                    break;
                }
            }
            
            if (!productExistsInCart) {
                // Add the product to the toys cart
                toysCart.add(new ToysCart(ID, ToysCart.toysCart.get(i).getProductName(), ToysCart.toysCart.get(i).getProductPrice(), quantity));
                System.out.println("\nProduct (" + quantity + ") " + ToysCart.toysCart.get(i).getProductName() + " added to Toys Cart successfully.");
            }
            return;
        }
    }

    // Method that displays the products in the toys cart
    public static void viewCart() {
        // Check if there are any products in the toys cart
        if (toysCart.size() == 0) {
            System.out.println("\n -----");
        }
        else {
            // Display the products in the toys cart
            for (int i = 0; i < toysCart.size(); i++) {
                // Display the product details with category
                System.out.println("|| Product ID: " + toysCart.get(i).getCategory() + toysCart.get(i).getProductID() + " || Product Name: " + toysCart.get(i).getProductName() + " || Product Unit Price: Php" + toysCart.get(i).getProductPrice() + " || Quantity: " + toysCart.get(i).getProductQty() + " ||");
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

// Create an Furniture class that implements the Cart interface
class FurnituresCart implements Cart {
    private int ID;
    private int quantity;
    private String name;
    private double price;
    private String category = "Furnitures";
    private double totalCost = 0.0;

    // Set a dynamic list to store furnitures products
    static List<FurnituresCart> furnituresCart = new ArrayList<>();

    // Constructor
    public FurnituresCart(int ID, String name, double price, int quantity) {
        this.ID = ID;
        this.quantity = quantity;
        this.name = name;
        this.price = price;
    }

    // Method that adds products to the furnitures cart
    public static void addedToCart(int ID, int quantity) {
        // Deduct quantity of the item based on the ID in the quantity available
        for (int i = 0; i < FurnituresCart.furnituresCart.size(); i++) {
            if (FurnituresCart.furnituresCart.get(i).getProductID() == ID) {
                FurnituresCart.furnituresCart.get(i).setProductQty(FurnituresCart.furnituresCart.get(i).getProductQty() - quantity);
            }

            // Check if the product is already in the cart
            boolean productExistsInCart = false;

            for (FurnituresCart cartItem : furnituresCart) {
                if (cartItem.getProductID() == ID) {
                    // Update the quantity in the cart
                    cartItem.quantity += quantity;
                    System.out.println("\nProduct (" + quantity + ") " + FurnituresCart.furnituresCart.get(i).getProductName() + " added to Furnitures Cart successfully.");
                    productExistsInCart = true;
                    break;
                }
            }
            
            if (!productExistsInCart) {
                // Add the product to the toys cart
                furnituresCart.add(new FurnituresCart(ID, FurnituresCart.furnituresCart.get(i).getProductName(), FurnituresCart.furnituresCart.get(i).getProductPrice(), quantity));
                System.out.println("\nProduct (" + quantity + ") " + FurnituresCart.furnituresCart.get(i).getProductName() + " added to Furnitures Cart successfully.");
            }
            return;
        }
    }

    // Method that displays the products in the furnitures cart
    public static void viewCart() {
        // Check if there are any products in the furnitures cart
        if (furnituresCart.size() == 0) {
            System.out.println("\n -----");
        }
        else {
            // Display the products in the furnitures cart
            for (int i = 0; i < furnituresCart.size(); i++) {
                // Display the product details with category
                System.out.println("|| Product ID: " + furnituresCart.get(i).getCategory() + furnituresCart.get(i).getProductID() + " || Product Name: " + furnituresCart.get(i).getProductName() + " || Product Unit Price: Php" + furnituresCart.get(i).getProductPrice() + " || Quantity: " + furnituresCart.get(i).getProductQty() + " ||");
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