import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;

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
                System.out.println("\n=============================================");
                System.out.println("Sales Menu");
                System.out.println("---------------------------------------------");
                System.out.println("1. Sale Cart");
                System.out.println("2. View Cart");
                System.out.println("3. Finalize Sale");
                System.out.println("4. Return to Admin Menu");
                System.out.println("=============================================");
                System.out.print("Enter your choice: ");

                int salesOption = salesInput.nextInt();

                // Check if the admin wants to make a new sale, view cart finalize sale, or return to admin menu
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
                        // Go to finalize sale menu
                        FinalizeSale finalizeSale = new FinalizeSale();
                        finalizeSale.finalizeSale();
                        break;
                    case 4:
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
                System.out.println("\n=============================================");
                System.out.println("Sales Cart");
                System.out.println("---------------------------------------------");
                System.out.println("Select a Category: \n1. Electronics\n2. Clothings\n3. Toys\n4. Furnitures\n5. Return");
                System.out.print(">>> ");
                int categoryChoice = newSaleInput.nextInt();

                boolean productExists = false;

                switch (categoryChoice) {
                    case 1:
                        // Take input for product ID
                        System.out.print("\nEnter the Product ID Number of the item to be sold: ");
                        int productID = newSaleInput.nextInt();
                        productExists = false;

                        // Check if the product ID is available in the electronics list
                        for (int i = 0; i < Electronics.electronics.size(); i++) {
                            //Check if product ID matches
                            if (Electronics.electronics.get(i).getProductID() == productID) {
                                productExists = true;
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
                                break;
                            }   
                        }

                        if (!productExists) {
                            System.out.println("Product ID not found.");
                        }
                        break;
                    case 2:
                        // Take input for product ID
                        System.out.print("\nEnter the Product ID Number of the item to be sold: ");
                        productID = newSaleInput.nextInt();
                        productExists = false;

                        // Check if the product ID is available in the electronics list
                        for (int i = 0; i < Clothings.clothings.size(); i++) {
                            //Check if product ID matches
                            if (Clothings.clothings.get(i).getProductID() == productID) {
                                productExists = true;
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
                                break;
                            }   
                        }

                        if (!productExists) {
                            System.out.println("Product ID not found.");
                        }
                        break;
                    case 3:
                        // Take input for product ID
                        System.out.print("\nEnter the Product ID Number of the item to be sold: ");
                        productID = newSaleInput.nextInt();
                        productExists = false;

                        // Check if the product ID is available in the electronics list
                        for (int i = 0; i < Toys.toys.size(); i++) {
                            //Check if product ID matches
                            if (Toys.toys.get(i).getProductID() == productID) {
                                productExists = true;
                                // Take input for quantity sold
                                System.out.print("\nEnter the quantity sold: ");
                                int quantitySold = newSaleInput.nextInt();

                                // Check if the quantity sold is less than or equal to the product quantity
                                if (quantitySold <= Toys.toys.get(i).getProductQty()) {
                                    // get the values of product ID, and quantity sold, and store it in the cart
                                    ToysCart.addedToCart(productID, quantitySold);
                                }
                                else {
                                    System.out.println("The quantity sold is greater than the product quantity.");
                                }
                                break;
                            }   
                        }

                        if (!productExists) {
                            System.out.println("Product ID not found.");
                        }
                        break;
                    case 4:
                        // Take input for product ID
                        System.out.print("\nEnter the Product ID Number of the item to be sold: ");
                        productID = newSaleInput.nextInt();
                        productExists = false;

                        // Check if the product ID is available in the furnitures list
                        for (int i = 0; i < Furnitures.furnitures.size(); i++) {
                            //Check if product ID matches
                            if (Furnitures.furnitures.get(i).getProductID() == productID) {
                                productExists = true;
                                // Take input for quantity sold
                                System.out.print("\nEnter the quantity sold: ");
                                int quantitySold = newSaleInput.nextInt();

                                // Check if the quantity sold is less than or equal to the product quantity
                                if (quantitySold <= Furnitures.furnitures.get(i).getProductQty()) {
                                    // get the values of product ID, and quantity sold, and store it in the cart
                                    FurnituresCart.addedToCart(productID, quantitySold);
                                }
                                else {
                                    System.out.println("The quantity sold is greater than the product quantity.");
                                }
                                break; 
                            }   
                        }
                        if (!productExists) {
                            System.out.println("Product ID not found.");
                        }
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
        // Scanner object to read user input
        Scanner confirmInput = new Scanner(System.in);

        // Display all items in all carts
        System.out.println("\n=============================================================");
        System.out.println("||          ID         ||     Product Name       ||  Qty ||     Total    ||");
        ElectronicsCart.viewCart();
        ClothingsCart.viewCart();
        ToysCart.viewCart();
        FurnituresCart.viewCart();
        System.out.println("=============================================================");

        // Ask admin if they want to finalize the sale
        System.out.println("Should we finalize the sale? (y/n)");
        String confirm = confirmInput.nextLine();

        // Check if the admin wants to finalize the sale
        if (confirm.equals("y")) {
            // Go to finalize sale menu
            System.out.println("\nFinalizing Sale...");
            FinalizeSale finalizeSale = new FinalizeSale();
            finalizeSale.finalizeSale();
        }
        else {
            // Go to New Sale menu
            System.out.println("\nReturning to Cart.");
            NewSale newSale = new NewSale();
            newSale.addToCart();
        }
    }
}

// Create FinalizeSaleclass to finalize sale, compute total cost to be paid, print a receipt, and update Sales (emptying carts and storing sales in Sales List for Reports)
class FinalizeSale {
    public void finalizeSale() {
        // Scanner object to read user input
        Scanner finalizeSaleInput = new Scanner(System.in);

        // Check if there are any items in the cart
        if (ElectronicsCart.electronicsCart.size() == 0 && ClothingsCart.clothingsCart.size() == 0) {
            // Go to sales menu
            System.out.println("There are no items in the cart. Returning to Sales Menu.");
            Sales sales = new Sales();
            sales.salesMenu();
        }
        else {
            double electronicsTotal = ElectronicsCart.calculateTotalCost();
            double clothingsTotal = ClothingsCart.calculateTotalCost();
            double toysTotal = ToysCart.calculateTotalCost();
            double furnituresTotal = FurnituresCart.calculateTotalCost();

            System.out.println("\nGrand Total to be paid: Php" + (electronicsTotal + clothingsTotal + toysTotal + furnituresTotal));

            // Ask admin if they want to finalize the sale
            System.out.println("Should we finalize the sale? (y/n)");
            String confirm = finalizeSaleInput.nextLine();

            // Check if the admin wants to finalize the sale and print a receipt
            if (confirm.equals("y")) {
                // Print receipt
                System.out.println("\n=============================================================");
                System.out.println("                            Receipt                    ");
                System.out.println("-------------------------------------------------------------");
                System.out.println("||        ID       ||   Product Name    ||  Qty ||   Total    ||");
                ElectronicsCart.viewCart();
                ClothingsCart.viewCart();
                ToysCart.viewCart();
                FurnituresCart.viewCart();
                System.out.println("=============================================================");
                System.out.println("Grand Total:                           >>> Php" + (electronicsTotal + clothingsTotal + toysTotal + furnituresTotal));

                System.out.println("\nThank you for shopping with us!\n");

                // Pass the data of the sold products to the soldProducts class before the cart is emptied
                for (ElectronicsCart product : ElectronicsCart.electronicsCart) {
                    SoldProducts.addSoldProducts(new SoldProduct(product.getProductID(), product.getProductName(), product.getProductPrice(), product.getProductQty(), product.getCategory()));
                }

                for (ClothingsCart product : ClothingsCart.clothingsCart) {
                    SoldProducts.addSoldProducts(new SoldProduct(product.getProductID(), product.getProductName(), product.getProductPrice(), product.getProductQty(), product.getCategory()));
                }   

                for (ToysCart product : ToysCart.toysCart) {
                    SoldProducts.addSoldProducts(new SoldProduct(product.getProductID(), product.getProductName(), product.getProductPrice(), product.getProductQty(), product.getCategory()));
                }

                for (FurnituresCart product : FurnituresCart.furnituresCart) {
                    SoldProducts.addSoldProducts(new SoldProduct(product.getProductID(), product.getProductName(), product.getProductPrice(), product.getProductQty(), product.getCategory()));
                }
            }

                // empty all carts
                ElectronicsCart.emptyCart();
                ClothingsCart.emptyCart();
                ToysCart.emptyCart();
                FurnituresCart.emptyCart();
        }  
    }  
}

