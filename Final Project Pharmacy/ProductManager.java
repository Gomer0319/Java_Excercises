public class ProductManager {
    
    public void productMenu() {
        boolean keepProductMenu = true;
        ProductController productController = new ProductController();

        while(keepProductMenu) {
            // Create a product menu that allows the user to add a product, update a product, or delete a product, and search for a product
            System.out.println("\n--------Product Menu--------");
            System.out.println(" 1. Add Product");
            System.out.println(" 2. Add Inventory");
            System.out.println(" 3. Offset Inventory");
            System.out.println(" 4. Update Product");
            System.out.println(" 5. Delete Product");
            System.out.println(" 6. Search Products"); //will be search products later on development
            System.out.println(" 7. Back to Main Menu");
            System.out.println("--------------------------");

            // Get user input
            int choice = Utility.getInt(">>> ");
            Utility.userInput.nextLine(); // Consume the newline character

            // Clear the console
            Utility.clearScreen();

            // Create a switch statement to handle user input
            switch (choice) {
                case 1:
                    // Create a ProductController object and call its addProduct method
                    productController.addProduct();
                    break;
                case 2:
                    // Create a ProductController object and call its addToInventory method
                    productController.addToInventory();
                    break;
                case 3:
                    // Create a ProductController object and call its offsetInventory method
                    productController.offsetInventoryTransaction();
                    break;
                case 4:
                    // Create a ProductController object and call its updateProduct method
                    productController.updateProduct();
                    break;
                case 5:
                    // Create a ProductController object and call its deleteProduct method
                    productController.deleteProduct();
                    break;
                case 6:
                    // Create a ProductController object and call its searchProduct method
                    productController.searchProduct(); 
                    break;
                case 7:
                    // Return to the main menu
                    keepProductMenu = false;
                    break;
                default:
                    // Print an error message for invalid input
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }
    }
}
