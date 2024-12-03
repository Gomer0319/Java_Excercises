import java.util.*;

// Create Admin menu class
class AdminMenu {
    // Create a scanner object to read user input
    Scanner adminInput = new Scanner(System.in);

    // Create menu for admin side
    public void displayMenu() {
        // Create a boolean variable to check if the admin wants to keep admin menu until they choose to logout
        boolean keepAdminMenu = true;

        while (keepAdminMenu) {
            System.out.println("Admin Menu");
            System.out.println("1. Manage Products");
            System.out.println("2. Process Sales");
            System.out.println("3. View Reports");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");

            int adminOption = adminInput.nextInt();

            // Check if the admin wants to manage products, process sales, view reports, or logout
            switch (adminOption) {
                case 1:
                    // Go to manage products menu
                    ManageProducts manageProducts = new ManageProducts();
                    manageProducts.displayMenu();
                    break;
                case 2:
                    // Process sales
                    System.out.println("Process Sales");
                    break;
                case 3:
                    // View reports
                    System.out.println("View Reports");
                    break;
                case 4:
                    // Logout
                    System.out.println("You are logged out.\n");
                    keepAdminMenu = false;
                    break;
                default:
            }
        }
    }
}

// Create manage products class where we add, edit(update), view and delete products. (Products will include ID, name, price, quantity, and category)
class ManageProducts {
    // Create a scanner object to read user input
    Scanner productInput = new Scanner(System.in);

    // Create menu for manage products
    public void displayMenu() {
        // Create a boolean variable to check if the admin wants to keep managing products until they choose to return to admin menu
        boolean keepManaging = true;

        while (keepManaging) {
            System.out.println("\nManage Products");
            System.out.println("1. Add Product");
            System.out.println("2. Edit Product");
            System.out.println("3. View Products");
            System.out.println("4. Delete Product");
            System.out.println("5. Return to Admin Menu");
            System.out.print("Enter your choice: ");

            int productOption = productInput.nextInt();

            // Check if the admin wants to add, edit, view, delete, or return to admin menu
            switch (productOption) {
                case 1:
                    // Go to Add product menu
                    AddProduct addProduct = new AddProduct();
                    addProduct.addProduct();
                    break;
                case 2:
                    // Update product
                    System.out.println("Update Product");
                    break;
                case 3:
                    // Go to View Products menu
                    displayProducts displayProducts = new displayProducts();
                    displayProducts.displayProduct();
                    break;
                case 4:
                    // Delete product
                    System.out.println("Delete Product");
                    break;
                case 5:
                    // Return to admin menu
                    System.out.println("Returning to Admin Menu. \n");
                    keepManaging = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

// Create add product class where we can add products to the system. (Products will include ID, name, price, quantity, and category)
class AddProduct {
    // Create a scanner object to read user input
    Scanner addProductInput = new Scanner(System.in);

    // Create add product menu
    public void addProduct() {
        System.out.println("\nAdd Product");
        System.out.print("Select product category: \n1. Electronics\n2. Clothings\n3. Toys\n4. Furnitures: ");
        int productCategory = addProductInput.nextInt();
        addProductInput.nextLine(); // Consume the newline character
        System.out.println("\nEnter product ID: ");
        int productID = addProductInput.nextInt();
        addProductInput.nextLine();
        System.out.println("Enter product name: ");
        String productName = addProductInput.nextLine();
        System.out.println("Enter product price: ");
        double productPrice = addProductInput.nextDouble();
        System.out.println("Enter product quantity: ");
        int productQty = addProductInput.nextInt();

        // Check if the product category is valid
        if (productCategory == 1) {
            // Add product to electronics array
            Electronics.addProduct(productID, productName, productPrice, productQty);
        }
        else {
            System.out.println("Invalid product category input.");
        }
    }
}

// Create a class to update/edit the values of a product on a certain category (Electronics, Clothings, Toys, Furnitures)
class UpdateProduct {
    // Create a scanner object to read user input
    Scanner updateProductInput = new Scanner(System.in);

    // Ask user for product category
    System.out.println("");
}

// Create a class to display products according to category requested (Electronics, Clothings, Toys, Furnitures)
class displayProducts {
    // Create a scanner object to read user input
    Scanner displayProductInput = new Scanner(System.in);

    // Ask user for product category
    public void displayProduct() {
        System.out.println("\nSelect product category: \n1. Electronics\n2. Clothings\n3. Toys\n4. Furnitures: ");
        int productCategory = displayProductInput.nextInt();

        // Display products according to category requested
        switch (productCategory) {
            case 1:
                Electronics.viewProducts();
                break;
            default:
                System.out.println("Invalid product category.");
        }
    }
}