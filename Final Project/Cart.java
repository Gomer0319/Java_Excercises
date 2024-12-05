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
            System.out.println("\n -----");
        }
        else {
            // Display the products in the electronics cart
            for (int i = 0; i < electronicsCart.size(); i++) {
                // Display the product details with category
                System.out.println("||  " + electronicsCart.get(i).getCategory() + electronicsCart.get(i).getProductID() + "    ||      " + electronicsCart.get(i).getProductName() + "     ||  " + electronicsCart.get(i).getProductQty() + "  ||  " + electronicsCart.get(i).getProductPrice() * electronicsCart.get(i).getProductQty() + "   ||");
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
                System.out.println("\nProduct (" + quantity + ") " + cartItem.getProductName() + " added to Clothings Cart successfully.");
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
                    ClothingsCart newCartItem = new ClothingsCart(ID, product.getProductName(), product.getProductPrice(), quantity);
                    clothingsCart.add(newCartItem);
                    System.out.println("\nProduct (" + quantity + ") " + product.getProductName() + " added to Clothings Cart successfully.");
                    break;
                }
            }
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
                System.out.println("||  " + clothingsCart.get(i).getCategory() + clothingsCart.get(i).getProductID() + "    ||      " + clothingsCart.get(i).getProductName() + "       ||  " + clothingsCart.get(i).getProductQty() + "    ||  " + clothingsCart.get(i).getProductPrice() * clothingsCart.get(i).getProductQty() + "   ||");
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
            System.out.println("\n -----");
        }
        else {
            // Display the products in the toys cart
            for (int i = 0; i < toysCart.size(); i++) {
                // Display the product details with category
                System.out.println("||  " + toysCart.get(i).getCategory() + toysCart.get(i).getProductID() + "  ||      " + toysCart.get(i).getProductName() + "        ||  " + toysCart.get(i).getProductQty() + " ||  " + toysCart.get(i).getProductPrice() * toysCart.get(i).getProductQty() + " ||");
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
                System.out.println("\nProduct (" + quantity + ") " + cartItem.getProductName() + " added to Furnitures Cart successfully.");
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
                    FurnituresCart newCartItem = new FurnituresCart(ID, product.getProductName(), product.getProductPrice(), quantity);
                    furnituresCart.add(newCartItem);
                    System.out.println("\nProduct (" + quantity + ") " + product.getProductName() + " added to Furnitures Cart successfully.");
                    break;
                }
            }
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
                System.out.println("||  " + furnituresCart.get(i).getCategory() + furnituresCart.get(i).getProductID() + "  ||      " + furnituresCart.get(i).getProductName() + "      ||  " + furnituresCart.get(i).getProductQty() + "   ||  " + furnituresCart.get(i).getProductPrice() * furnituresCart.get(i).getProductQty() + " ||");
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