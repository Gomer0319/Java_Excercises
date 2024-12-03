import java.util.*;

// Create Admin menu class
class AdminMenu {
    // Create a scanner object to read user input
    Scanner adminInput = new Scanner(System.in);

    // Create menu for admin side
    public void displayMenu() {
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
                adminInput.close();
                break;
            default:
        }
    }
}

// Create manage products class where we add, edit(update), view and delete products. (Products will include ID, name, price, quantity, and category)
class ManageProducts {
    // Create a scanner object to read user input
    Scanner productInput = new Scanner(System.in);

    // Create menu for manage products
    public void displayMenu() {
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
                // Add product
                System.out.println("Add Product");
                break;
            case 2:
                // Edit product
                System.out.println("Edit Product");
                break;
            case 3:
                // View products
                System.out.println("View Products");
                break;
            case 4:
                // Delete product
                System.out.println("Delete Product");
                break;
            case 5:
                // Return to admin menu
                System.out.println("Return to Admin Menu");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}

// Create add product class where we can add products to the system. (Products will include ID, name, price, quantity, and category)
class AddProduct {
    // Create a scanner object to read user input
    Scanner addProductInput = new Scanner(System.in);

    // Create add product menu
    public void addProduct() {
        System.out.println("Add Product");
        System.out.println("Enter product ID: ");
        int productID = addProductInput.nextInt();
        System.out.println("Enter product name: ");
        String productName = addProductInput.next();
        System.out.println("Enter product price: ");
        double productPrice = addProductInput.nextDouble();
        System.out.println("Enter product quantity: ");
        int productQty = addProductInput.nextInt();
        System.out.println("Select product category: \n1. Electronics\n2. Clothings\n3. Toys\n4. Furnitures");
        int productCategory = addProductInput.nextInt();

        // Check if the product category is valid

        
    }
}
