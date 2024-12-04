import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

interface Product {
    // Create Product interface that includes ID, name, price, quantity, and category, that gets and sets the values.
    int getProductID();
    String getProductName();
    double getProductPrice();
    int getProductQty();
    String getCategory();

    void setProduct(int ID, String name, double price, int quantity);
    void setProductQty(int qty);
}

// Create Electronics class that implements the Product interface.
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
        // Check if there is a product with the same ID
        for (int i = 0; i < electronics.size(); i++) {
            Electronics product = electronics.get(i);
            if (product.getProductID() == ID) {
                System.out.println("Product with ID " + ID + " already exists in Electronics category.");
                return;
            }
            // Check if there is a product with the same name through else if statement
            else if (product.getProductName().equals(name)) {
                System.out.println("Product with name " + name + " already exists in Electronics category.");
                return;
            }
            // if the ID and name are unique, continue to add the product
            else {
                continue;
            }
        }
        // Add the product to the electronics list
        electronics.add(new Electronics(ID, name, price, quantity));
        System.out.println("Product " + name + " with ID " + ID + " has been added successfully.");
    }

    // Method to update Products
    public static void editProduct(int ID) {
        // Create a Scanner object to get user input
        Scanner updateProductInput = new Scanner(System.in);

        // Add boolean to check if the admin user wants to keep on editing,else return to manage products
        boolean keepEditing = true;

        // Check if there are any products in the electronics category based on the product ID
        for (int i = 0; i < electronics.size(); i++) {
            Electronics product = electronics.get(i);
            if (product.getProductID() == ID) {
                System.out.println("\nProduct found with ID " + ID + " in Electronics category\n");

                // Keep editing the product until the admin user wants to return to manage products
                while (keepEditing) {
                    //if the product is found, ask what values of the product to be updated
                    System.out.println("\nWhat values of the product to be updated: \n1. Name \n2. Price \n3. Quantity: \n4. Return to Manage Products");
                    System.out.print(">>> ");
                    int choice = updateProductInput.nextInt();
                    // consume the newline character left in the input buffer
                    updateProductInput.nextLine();

                    //update the values of the product
                    if (choice == 1) {
                        System.out.println("\nEnter the new name: ");
                        String newName = updateProductInput.nextLine();
                        product.setProduct(ID, newName, product.getProductPrice(), product.getProductQty());
                        System.out.println("\nProduct name for ID " + ID + " updated successfully.");
                    }
                    else if (choice == 2) {
                        System.out.println("\nEnter the new price: ");
                        double newPrice = updateProductInput.nextDouble();
                        product.setProduct(ID, product.getProductName(), newPrice, product.getProductQty());
                        System.out.println("\nProduct price for " + product.getProductName() + " updated successfully.");
                    }
                    else if (choice == 3) {
                        System.out.println("\nEnter the new quantity: ");
                        int newQuantity = updateProductInput.nextInt();
                        product.setProduct(ID, product.getProductName(), product.getProductPrice(), newQuantity);
                        System.out.println("\nProduct quantity for " + product.getProductName() + " updated successfully.");
                    }
                    else if (choice == 4) {
                        // Return to Manage Products display menu
                        keepEditing = false;
                        ManageProducts manageProducts = new ManageProducts();
                        manageProducts.displayMenu();
                    }
                    else {
                        System.out.println("\nInvalid choice.");
                    }
                }
            }
            // If the product is not found, print a message
            else {
                System.out.println("Product with ID " + ID + " not found in Electronics category.");
            }  
        }      
    }

    // Method to delete product
    public static void deleteProduct(int ID) {
        // Check if there are any products in the electronics category based on the product ID
        for (int i = 0; i < electronics.size(); i++) {
            Electronics product = electronics.get(i);

            // If the product is found, delete it
            if (product.getProductID() == ID) {
                electronics.remove(i);
                System.out.println("Product with ID " + ID + " with name " + product.getProductName() + " has been deleted successfully from Electronics category.");
                return;
            }
        }
        // If the product is not found, print a message
        System.out.println("Product with ID " + ID + " not found in Electronics category.");
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
                System.out.println("|| ID: " + product.getProductID() + " || Name: " + product.getProductName() + " || Price: Php " + product.getProductPrice() + " || Quantity: " + product.getProductQty() + " ||");
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

    @Override
    public void setProductQty(int quantity) {
        this.quantity = quantity;
    }
}

// Create Clothings class that implements the Product interface
class Clothings implements Product {
    private int ID;
    private String name;
    private double price;
    private int quantity;
    private String category = "Clothings";

    // Set a dynamic list to store clothing products
    static List<Clothings> clothings = new ArrayList<>();

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

        // Add boolean to check if the admin user wants to keep on editing,else return to manage products
        boolean keepEditing = true;

        // Check if there are any products in the clothings category based on the product ID
        for (int i = 0; i < clothings.size(); i++) {
            Clothings product = clothings.get(i);
            if (product.getProductID() == ID) {
                System.out.println("\nProduct found with ID " + ID + " in Clothings category\n");

                // Keep editing the product until the admin user wants to return to manage products
                while (keepEditing) {
                    //if the product is found, ask what values of the product to be updated
                    System.out.println("\nWhat values of the product to be updated: \n1. Name \n2. Price \n3. Quantity: \n4. Return to Manage Products");
                    System.out.print(">>> ");
                    int choice = updateProductInput.nextInt();
                    // consume the newline character left in the input buffer
                    updateProductInput.nextLine();

                    //update the values of the product
                    if (choice == 1) {
                        System.out.println("\nEnter the new name: ");
                        String newName = updateProductInput.nextLine();
                        product.setProduct(ID, newName, product.getProductPrice(), product.getProductQty());
                        System.out.println("\nProduct name for ID " + ID + " updated successfully.");
                    }
                    else if (choice == 2) {
                        System.out.println("\nEnter the new price: ");
                        double newPrice = updateProductInput.nextDouble();
                        product.setProduct(ID, product.getProductName(), newPrice, product.getProductQty());
                        System.out.println("\nProduct price for " + product.getProductName() + " updated successfully.");
                    }
                    else if (choice == 3) {
                        System.out.println("\nEnter the new quantity: ");
                        int newQuantity = updateProductInput.nextInt();
                        product.setProduct(ID, product.getProductName(), product.getProductPrice(), newQuantity);
                        System.out.println("\nProduct quantity for " + product.getProductName() + " updated successfully.");
                    }
                    else if (choice == 4) {
                        // Return to Manage Products display menu
                        keepEditing = false;
                        ManageProducts manageProducts = new ManageProducts();
                        manageProducts.displayMenu();
                    }
                    else {
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
        // Check if there are any products in the clothings category based on the product ID
        for (int i = 0; i < clothings.size(); i++) {
            Clothings product = clothings.get(i);

            // If the product is found, delete it
            if (product.getProductID() == ID) {
                clothings.remove(i);
                System.out.println("Product with ID " + ID + " with name " + product.getProductName() + " has been deleted successfully from Clothings category.");
                return;
            }
        }
        // If the product is not found, print a message
        System.out.println("Product with ID " + ID + " not found in Clothings category.");
    }



    // Method to view or display products from viewProducts class for clothings category
    public static void viewProducts() {
        // Check if there are any products in the clothings category
        if (clothings.size() == 0) {
            System.out.println("No products found in Clothings category.");
        }
        else {
            System.out.println("Products in Clothings category:");
            // Loop through the clothings list and display the products, one by one, one product per line in the console
            for (int i = 0; i < clothings.size(); i++) {
                Clothings product = clothings.get(i);
                System.out.println("|| ID: " + product.getProductID() + " || Name: " + product.getProductName() + " || Price: Php " + product.getProductPrice() + " || Quantity: " + product.getProductQty() + " ||");
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

    @Override
    public void setProductQty(int quantity) {
        this.quantity = quantity;
    }
}

// Create Toys class that implements the Product interface
class Toys implements Product {
    private int ID;
    private String name;
    private double price;
    private int quantity;
    private String category = "Toys";

    // Set a dynamic list to store toy products
    static List<Toys> toys = new ArrayList<>();

    // Constructor
    public Toys(int ID, String name, double price, int quantity) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to addProducts from addProduct class
    public static void addProduct(int ID, String name, double price, int quantity) {
        // Check if there is a product with the same ID
        for (int i = 0; i < toys.size(); i++) {
            Toys product = toys.get(i);
            if (product.getProductID() == ID) {
                System.out.println("Product with ID " + ID + " already exists in Toys category.");
                return;
            }
            // Check if there is a product with the same name through else if statement
            else if (product.getProductName().equals(name)) {
                System.out.println("Product with name " + name + " already exists in Toys category.");
                return;
            }
            // if the ID and name are unique, continue to add the product
            else {
                continue;
            }
        }
        // Add the product to the toys list
        toys.add(new Toys(ID, name, price, quantity));
        System.out.println("Product " + name + " with ID " + ID + " has been added successfully.");
    }

    // Method to update Products
    public static void editProduct(int ID) {
        // Create a Scanner object to get user input
        Scanner updateProductInput = new Scanner(System.in);

        // Add boolean to check if the admin user wants to keep on editing,else return to manage products
        boolean keepEditing = true;

        // Check if there are any products in the toys category based on the product ID
        for (int i = 0; i < toys.size(); i++) {
            Toys product = toys.get(i);
            if (product.getProductID() == ID) {
                System.out.println("\nProduct found with ID " + ID + " in Toys category\n");

                // Keep editing the product until the admin user wants to return to manage products
                while (keepEditing) {
                    //if the product is found, ask what values of the product to be updated
                    System.out.println("\nWhat values of the product to be updated: \n1. Name \n2. Price \n3. Quantity: \n4. Return to Manage Products");
                    System.out.print(">>> ");
                    int choice = updateProductInput.nextInt();
                    // consume the newline character left in the input buffer
                    updateProductInput.nextLine();

                    //update the values of the product
                    if (choice == 1) {
                        System.out.println("\nEnter the new name: ");
                        String newName = updateProductInput.nextLine();
                        product.setProduct(ID, newName, product.getProductPrice(), product.getProductQty());
                        System.out.println("\nProduct name for ID " + ID + " updated successfully.");
                    }
                    else if (choice == 2) {
                        System.out.println("\nEnter the new price: ");
                        double newPrice = updateProductInput.nextDouble();
                        product.setProduct(ID, product.getProductName(), newPrice, product.getProductQty());
                        System.out.println("\nProduct price for " + product.getProductName() + " updated successfully.");
                    }
                    else if (choice == 3) {
                        System.out.println("\nEnter the new quantity: ");
                        int newQuantity = updateProductInput.nextInt();
                        product.setProduct(ID, product.getProductName(), product.getProductPrice(), newQuantity);
                        System.out.println("\nProduct quantity for " + product.getProductName() + " updated successfully.");
                    }
                    else if (choice == 4) {
                        // Return to Manage Products display menu
                        keepEditing = false;
                        ManageProducts manageProducts = new ManageProducts();
                        manageProducts.displayMenu();
                    }
                    else {
                        System.out.println("\nInvalid choice.");
                    }
                }
            }
            // If the product is not found, print a message
            else {
                System.out.println("Product with ID " + ID + " not found in Toys category.");
            }  
        }      
    }

    // Method to delete product
    public static void deleteProduct(int ID) {
        // Check if there are any products in the toys category based on the product ID
        for (int i = 0; i < toys.size(); i++) {
            Toys product = toys.get(i);

            // If the product is found, delete it
            if (product.getProductID() == ID) {
                toys.remove(i);
                System.out.println("Product with ID " + ID + " with name " + product.getProductName() + " has been deleted successfully from Toys category.");
                return;
            }
        }
        // If the product is not found, print a message
        System.out.println("Product with ID " + ID + " not found in Toys category.");
    }



    // Method to view or display products from viewProducts class for toys category
    public static void viewProducts() {
        // Check if there are any products in the toys category
        if (toys.size() == 0) {
            System.out.println("No products found in Toys category.");
        }
        else {
            System.out.println("Products in Toys category:");
            // Loop through the toys list and display the products, one by one, one product per line in the console
            for (int i = 0; i < toys.size(); i++) {
                Toys product = toys.get(i);
                System.out.println("|| ID: " + product.getProductID() + " || Name: " + product.getProductName() + " || Price: Php " + product.getProductPrice() + " || Quantity: " + product.getProductQty() + " ||");
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

    @Override
    public void setProductQty(int quantity) {
        this.quantity = quantity;
    }
}

// Create Furnitures class that implements the Product interface
class Furnitures implements Product {
    private int ID;
    private String name;
    private double price;
    private int quantity;
    private String category = "Furnitures";

    // Set a dynamic list to store furniture products
    static List<Furnitures> furnitures = new ArrayList<>();

    // Constructor
    public Furnitures(int ID, String name, double price, int quantity) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to addProducts from addProduct class
    public static void addProduct(int ID, String name, double price, int quantity) {
        // Check if there is a product with the same ID
        for (int i = 0; i < furnitures.size(); i++) {
            Furnitures product = furnitures.get(i);
            if (product.getProductID() == ID) {
                System.out.println("Product with ID " + ID + " already exists in Furnitures category.");
                return;
            }
            // Check if there is a product with the same name through else if statement
            else if (product.getProductName().equals(name)) {
                System.out.println("Product with name " + name + " already exists in Furnitures category.");
                return;
            }
            // if the ID and name are unique, continue to add the product
            else {
                continue;
            }
        }
        // Add the product to the Furnitures list
        furnitures.add(new Furnitures(ID, name, price, quantity));
        System.out.println("Product " + name + " with ID " + ID + " has been added successfully.");
    }

    // Method to update Products
    public static void editProduct(int ID) {
        // Create a Scanner object to get user input
        Scanner updateProductInput = new Scanner(System.in);

        // Add boolean to check if the admin user wants to keep on editing,else return to manage products
        boolean keepEditing = true;

        // Check if there are any products in the furnitures category based on the product ID
        for (int i = 0; i < furnitures.size(); i++) {
            Furnitures product = furnitures.get(i);
            if (product.getProductID() == ID) {
                System.out.println("\nProduct found with ID " + ID + " in Furnitures category\n");

                // Keep editing the product until the admin user wants to return to manage products
                while (keepEditing) {
                    //if the product is found, ask what values of the product to be updated
                    System.out.println("\nWhat values of the product to be updated: \n1. Name \n2. Price \n3. Quantity: \n4. Return to Manage Products");
                    System.out.print(">>> ");
                    int choice = updateProductInput.nextInt();
                    // consume the newline character left in the input buffer
                    updateProductInput.nextLine();

                    //update the values of the product
                    if (choice == 1) {
                        System.out.println("\nEnter the new name: ");
                        String newName = updateProductInput.nextLine();
                        product.setProduct(ID, newName, product.getProductPrice(), product.getProductQty());
                        System.out.println("\nProduct name for ID " + ID + " updated successfully.");
                    }
                    else if (choice == 2) {
                        System.out.println("\nEnter the new price: ");
                        double newPrice = updateProductInput.nextDouble();
                        product.setProduct(ID, product.getProductName(), newPrice, product.getProductQty());
                        System.out.println("\nProduct price for " + product.getProductName() + " updated successfully.");
                    }
                    else if (choice == 3) {
                        System.out.println("\nEnter the new quantity: ");
                        int newQuantity = updateProductInput.nextInt();
                        product.setProduct(ID, product.getProductName(), product.getProductPrice(), newQuantity);
                        System.out.println("\nProduct quantity for " + product.getProductName() + " updated successfully.");
                    }
                    else if (choice == 4) {
                        // Return to Manage Products display menu
                        keepEditing = false;
                        ManageProducts manageProducts = new ManageProducts();
                        manageProducts.displayMenu();
                    }
                    else {
                        System.out.println("\nInvalid choice.");
                    }
                }
            }
            // If the product is not found, print a message
            else {
                System.out.println("Product with ID " + ID + " not found in Furnitures category.");
            }  
        }      
    }

    // Method to delete product
    public static void deleteProduct(int ID) {
        // Check if there are any products in the toys category based on the product ID
        for (int i = 0; i < furnitures.size(); i++) {
            Furnitures product = furnitures.get(i);

            // If the product is found, delete it
            if (product.getProductID() == ID) {
                furnitures.remove(i);
                System.out.println("Product with ID " + ID + " with name " + product.getProductName() + " has been deleted successfully from Furnitures category.");
                return;
            }
        }
        // If the product is not found, print a message
        System.out.println("Product with ID " + ID + " not found in Furnitures category.");
    }



    // Method to view or display products from viewProducts class for Furnitures category
    public static void viewProducts() {
        // Check if there are any products in the toys category
        if (furnitures.size() == 0) {
            System.out.println("No products found in Furnitures category.");
        }
        else {
            System.out.println("Products in Toys category:");
            // Loop through the toys list and display the products, one by one, one product per line in the console
            for (int i = 0; i < furnitures.size(); i++) {
                Furnitures product = furnitures.get(i);
                System.out.println("|| ID: " + product.getProductID() + " || Name: " + product.getProductName() + " || Price: Php " + product.getProductPrice() + " || Quantity: " + product.getProductQty() + " ||");
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

    @Override
    public void setProductQty(int quantity) {
        this.quantity = quantity;
    }
}