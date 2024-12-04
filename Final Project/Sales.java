import java.util.Scanner;
import java.util.InputMismatchException;

// Create Sales class where we select products to be sold (by their Category and ID), Entering Qty Sold and updating the inventory, and making a reciept of the sale.
class Sales {
    // Create a scanner object to read user input
    Scanner salesInput = new Scanner(System.in);

    // Create menu for sales
    public void salesMenu() {
        // Create a boolean variable to check if the admin wants to keep sales menu until they choose to return to admin menu
        boolean keepSalesMenu = true;

        while (keepSalesMenu) {
            //try-catch block to handle InputMismatchException
            try {
                System.out.println("\nSales Menu");
                System.out.println("1. New Sale");
                System.out.println("2. View Cart");
                System.out.println("3. Edit Cart");
                System.out.println("4. Finalize Sale");
                System.out.println("5. Return to Admin Menu");
                System.out.print("Enter your choice: ");

                int salesOption = salesInput.nextInt();

                // Check if the admin wants to make a new sale, view cart, edit cart, finalize sale, or return to admin menu
                switch (salesOption) {
                    case 1:
                        // Go to sales cart menu
                        NewSale newSale = new NewSale();
                        newSale.addToCart();
                        break;
                    case 2:
                        // Go to view cart menu
                        ViewCart viewCart = new ViewCart();
                        viewCart.displayCart();   
                        break;
                    case 3:
                        // testing code
                        System.out.println("Edit Cart");
                        break;
                    case 4:
                        // testing code
                        System.out.println("Finalize Sale");
                        break;
                    case 5:
                        // Go to admin menu
                        AdminMenu adminMenu = new AdminMenu();
                        adminMenu.displayMenu();
                        break;
                    default:
                        System.out.println("\nInvalid option. Please try again.\n");
                        break;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("\nInvalid input, please enter a number from the menu.\n");
                salesInput.next();
            }
        }
    }
}

// Create a class for New Sale
class NewSale {
    // Create a scanner object to read user input
    Scanner newSaleInput = new Scanner(System.in);

    // Create sales (adding to cart) functions/methods
    public void addToCart() {
        // Create a boolean variable to check if the admin wants to keep new sale menu until they choose to return to sales menu
        boolean keepNewSaleMenu = true;

        while (keepNewSaleMenu) {
            //try-catch block to handle InputMismatchException
            try {
                System.out.println("\nSales Cart");
                System.out.println("Select a Category: \n1. Electronics\n2. Clothings\n3. Toys\n4. Furnitures\n5. Return");
                System.out.print(">>> ");
                int categoryChoice = newSaleInput.nextInt();

                
                switch (categoryChoice) {
                    case 1:
                        // Take input for product ID
                        System.out.print("\nEnter the Product ID Number of the item to be sold: ");
                        int productID = newSaleInput.nextInt();

                        // Check if the product ID is available in the electronics list
                        for (int i = 0; i < Electronics.electronics.size(); i++) {
                            //Check if product ID matches
                            if (Electronics.electronics.get(i).getProductID() == productID) {
                                // Take input for quantity sold
                                System.out.print("\nEnter the quantity sold: ");
                                int quantitySold = newSaleInput.nextInt();

                                // Check if the quantity sold is less than or equal to the product quantity
                                if (quantitySold <= Electronics.electronics.get(i).getProductQty()) {
                                    // get the values of product ID, and quantity sold, and store it in the cart
                                    ElectronicsCart.addedToCart(productID, quantitySold);
                                }
                                else {
                                    System.out.println("The quantity sold is greater than the product quantity.");
                                }
                            }
                            else {
                                System.out.println("Product ID not found.");
                            }   
                        }
                        break;
                    case 2:
                        // Take input for product ID
                        System.out.print("\nEnter the Product ID Number of the item to be sold: ");
                        productID = newSaleInput.nextInt();

                        // Check if the product ID is available in the electronics list
                        for (int i = 0; i < Clothings.clothings.size(); i++) {
                            //Check if product ID matches
                            if (Clothings.clothings.get(i).getProductID() == productID) {
                                // Take input for quantity sold
                                System.out.print("\nEnter the quantity sold: ");
                                int quantitySold = newSaleInput.nextInt();

                                // Check if the quantity sold is less than or equal to the product quantity
                                if (quantitySold <= Clothings.clothings.get(i).getProductQty()) {
                                    // get the values of product ID, and quantity sold, and store it in the cart
                                    ClothingsCart.addedToCart(productID, quantitySold);
                                }
                                else {
                                    System.out.println("The quantity sold is greater than the product quantity.");
                                }
                            }
                            else {
                                System.out.println("Product ID not found.");
                            }   
                        }
                        break;
                    case 3:
                        // Testing code
                        System.out.println("Toys");
                        break;
                    case 4:
                        // Testing code
                        System.out.println("Furnitures");
                        break;
                    case 5:
                        // Go to sales menu
                        System.out.println("Returning to Sales Menu.");
                        keepNewSaleMenu = false;
                        Sales sales = new Sales();
                        sales.salesMenu();
                        break;
                    default:
                        System.out.println("\nInvalid option. Please try again.\n");
                        break;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("\nInvalid input, please enter a number from the menu.\n");
                newSaleInput.next();
            }
        }
    }
}

// Create ViewCart class to view contents of all cart (like a receipt)
class ViewCart {
    public void displayCart() {
        // Display all items in all carts
        ElectronicsCart.viewCart();
        ClothingsCart.viewCart();
    }
}