import java.util.Scanner;
import java.util.InputMismatchException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Create Sales class where we select products to be sold (by their Category and ID), Entering Qty Sold and updating the inventory, and making a reciept of the sale.
class Sales {
    private String loggedUser;
    private int customerID;

    public Sales(String loggedUser, int customerID){
        this.loggedUser = LoginManager.getloggedUser();
        this.customerID = customerID;
    }

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
                System.out.println("4. Return to Main Menu");
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
                        FinalizeSale finalizeSale = new FinalizeSale(loggedUser, 0);
                        finalizeSale.finalizeSale();
                        break;
                    case 4:
                        // Check of logged user is admin or employee and go to appropriate menu
                        if (LoginManager.getloggedUser().equals("Admin")) {
                            AdminMenu adminMenu = new AdminMenu();
                            adminMenu.displayMenu();
                            keepSalesMenu = false;
                            break;
                        }
                        else if (LoginManager.getloggedUser().equals("Employee")) {
                            EmployeeMenu employeeMenu = new EmployeeMenu();
                            employeeMenu.displayMenu();
                            keepSalesMenu = false;
                            break;
                        }
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

    // getter for logged user
    public String getLoggedUser() {
        return loggedUser;
    }

    // getter for customer ID
    public int getCustomerID() {
        return customerID;
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

                // Take input for category
                System.out.println("Select a Category: \n1. Electronics\n2. Clothings\n3. Toys\n4. Furnitures\n5. Proceed to View Cart");
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
                        // Go to view cart menu
                        ViewCart viewCart = new ViewCart();
                        viewCart.displayCart();
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
    private String loggedUser;
    private int customerID;

    public ViewCart(String loggedUser, int customerID) {
        this.loggedUser = LoginManager.getloggedUser();
        this.customerID = customerID;
    }

    public ViewCart() {
        this.loggedUser = null;
        this.customerID = 0;
    }

    public void displayCart() {
        // Scanner object to read user input
        Scanner confirmInput = new Scanner(System.in);

        // Display all items in all carts
        System.out.println("\n==========================================================================================================================================================");
        System.out.printf("|| %-20s || %-40s || %-20s || %-30s ||%n", "ID", "Product Name", "Quantity", "Total");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
        ElectronicsCart.viewCart();
        ClothingsCart.viewCart();
        ToysCart.viewCart();
        FurnituresCart.viewCart();
        System.out.println("==========================================================================================================================================================");

        // Ask admin if they want to finalize the sale
        System.out.println("Should we compute the total cost? (y/n)");
        String confirm = confirmInput.nextLine();

        // Check if the admin wants to finalize the sale
        if (confirm.equals("y")) {
            // Ask the user if they want to associate the sale to a registered customer or not.
            System.out.println("Do you want to associate the sale to a registered customer? (y/n)");
            System.out.print(">>> ");
            String customerChoice = confirmInput.next();

            if (customerChoice.equals("y")) {
                // Ask the user to enter the customer ID
                System.out.print("Enter the customer ID: ");
                int customerID = confirmInput.nextInt();

                // Check if the customer ID is available in the customer list
                for (Customer customer : Customer.customers) {
                    if (customer.getID() == customerID) {
                        // Display a message that the sale has been associated with the customer
                        System.out.println("\nSale has been associated with customer " + customer.getName());

                        // Go to finalize sale menu
                        System.out.println("\nFinalizing Sale...");
                        FinalizeSale finalizeSale = new FinalizeSale(loggedUser,customerID);
                        finalizeSale.finalizeSale();
                        break;
                    }
                    else {
                        System.out.println("Customer ID not found.");
                        continue;
                    }
                }
            }
            else if (customerChoice.equals("n")) {
                // Proceed with the new sale
                System.out.println("\nSale has not been associated with a customer.");

                // Go to finalize sale menu
                System.out.println("\nFinalizing Sale...");
                FinalizeSale finalizeSale = new FinalizeSale();
                finalizeSale.finalizeSale();
                return;
            }
        }
        else if (confirm.equals("n")) {
            // Ask if we return in the addtocart menu or we empty the cart
            System.out.println("Do you want to return to the Add to Cart Menu? (y/n)");
            System.out.print(">>> ");
            String returnChoice = confirmInput.next();

            if (returnChoice.equals("y")) {
                // GO back to addtocart menu
                System.out.println("\nReturning to Add to Cart Menu...");
                NewSale newSale = new NewSale();
                newSale.addToCart();
                return;
            }
            else if (returnChoice.equals("n")) {
                //return the quantity of the products back to the inventory
                System.out.println("\nCanceling Sale...");
                Electronics.returnProduct();
                Clothings.returnProduct();
                Toys.returnProduct();
                Furnitures.returnProduct();

                // Empty the cart
                ElectronicsCart.electronicsCart.clear();
                ClothingsCart.clothingsCart.clear();
                ToysCart.toysCart.clear();
                FurnituresCart.furnituresCart.clear();
                System.out.println("\nCart has been cleared.");

                // Go back to Sales menu
                Sales sales = new Sales(loggedUser, 0);
                sales.salesMenu();
                return;
            }
            else {
                System.out.println("\nInvalid option. Please try again.");
            }
        }
    }

    // getter for loggedUser
    public String getLoggedUser() {
        return loggedUser;
    }

    // getter for customerID
    public int getCustomerID() {
        return customerID;
    }
}

// Create FinalizeSaleclass to finalize sale, compute total cost to be paid, print a receipt, and update Sales (emptying carts and storing sales in Sales List for Reports)
class FinalizeSale {
    private String loggedUser;
    private int customerID;

    // Constructor
    public FinalizeSale(String loggedUser, int customerID) {
        this.customerID = customerID;
        this.loggedUser = LoginManager.getloggedUser();
    }

    // Default constructor
    public FinalizeSale() {
        this.loggedUser = null;
        this.customerID = 0;
    }


    public void finalizeSale() {
        // Scanner object to read user input
        Scanner finalizeSaleInput = new Scanner(System.in);

        // Check if there are any items in the cart
        if (ElectronicsCart.electronicsCart.size() == 0 && ClothingsCart.clothingsCart.size() == 0 && ToysCart.toysCart.size() == 0 && FurnituresCart.furnituresCart.size() == 0) {
            // Go to sales menu
            System.out.println("There are no items in the cart. Returning to Sales Menu.");
            Sales sales = new Sales(loggedUser, customerID);
            sales.salesMenu();
        }
        else {
            double electronicsTotal = ElectronicsCart.calculateTotalCost();
            double clothingsTotal = ClothingsCart.calculateTotalCost();
            double toysTotal = ToysCart.calculateTotalCost();
            double furnituresTotal = FurnituresCart.calculateTotalCost();

            System.out.printf("\nGrand Total to be paid: %40s Php %30.2f \n", " " ,(electronicsTotal + clothingsTotal + toysTotal + furnituresTotal)); 

            // Ask admin if they want to finalize the sale
            System.out.println("Should we finalize the sale? (y/n)");
            String confirm = finalizeSaleInput.nextLine();

            // Check if the admin wants to finalize the sale and print a receipt
            if (confirm.equals("y")) {
                // Get current date and time
                LocalDateTime currentDateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String dateTimeString = currentDateTime.format(formatter);

                // Print receipt
                System.out.println("\n==========================================================================================================================================================");
                System.out.printf("%70s %-10s \n", " ", "Receipt");
                System.out.printf("Tendered by: %s%n", loggedUser);
                System.out.printf("Customer ID: %d%n", customerID);
                System.out.printf("Date and Time: %s%n", dateTimeString);
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("|| %-20s || %-40s || %-20s || %-30s ||%n", "ID", "Product Name", "Quantity", "Total");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
                ElectronicsCart.viewCart();
                ClothingsCart.viewCart();
                ToysCart.viewCart();
                FurnituresCart.viewCart();
                System.out.println("==========================================================================================================================================================");
                System.out.printf("Grand Total: %75s >>> Php %30.2f \n", " ", (electronicsTotal + clothingsTotal + toysTotal + furnituresTotal));

                System.out.println("\nThank you for shopping with us!\n\n\n");

                // Update the points of the customer with the corresponding ID. For every 1000 php spent, there is 1 point (example, if spent is 6500, there are 6.5 points). It is accumulative.
                // Check if the customer exists in the database
                boolean customerExists = false;
                for (int i = 0; i < Customer.customers.size(); i++) {
                    if (Customer.customers.get(i).getID() == customerID) {
                        customerExists = true;
                        // Update the points of the customer
                        double computedPoints = (electronicsTotal + clothingsTotal + toysTotal + furnituresTotal) / 1000;
                        Customer.updatePoints(customerID, computedPoints);
                        break;
                    }
                }

                if (!customerExists) {
                    // If the customer does not exist, create an error message
                    System.out.println("Customer with ID " + customerID + " does not exist in the database.");
                }

                // Pass the data of the sold products to the soldProducts class before the cart is emptied, add the dateTimeString to the soldProduct class, then empty the cart
                for (ElectronicsCart product : ElectronicsCart.electronicsCart) {
                    SoldProducts.addSoldProducts(new SoldProduct(product.getProductID(), product.getProductName(), product.getProductPrice(), product.getProductQty(), product.getCategory(), dateTimeString));
                }

                for (ClothingsCart product : ClothingsCart.clothingsCart) {
                    SoldProducts.addSoldProducts(new SoldProduct(product.getProductID(), product.getProductName(), product.getProductPrice(), product.getProductQty(), product.getCategory(), dateTimeString));
                }   

                for (ToysCart product : ToysCart.toysCart) {
                    SoldProducts.addSoldProducts(new SoldProduct(product.getProductID(), product.getProductName(), product.getProductPrice(), product.getProductQty(), product.getCategory(), dateTimeString));
                }

                for (FurnituresCart product : FurnituresCart.furnituresCart) {
                    SoldProducts.addSoldProducts(new SoldProduct(product.getProductID(), product.getProductName(), product.getProductPrice(), product.getProductQty(), product.getCategory(), dateTimeString));
                }

                // empty all carts
                ElectronicsCart.emptyCart();
                ClothingsCart.emptyCart();
                ToysCart.emptyCart();
                FurnituresCart.emptyCart();

                // Go to sales menu
                System.out.println("\nReturning to Sales Menu...");
                Sales sales = new Sales(LoginManager.getloggedUser(), 0);
                sales.salesMenu();

            } else if (confirm.equals("n")) {
                // Ask if we return in the addtocart menu or we empty the cart
                System.out.println("Do you want to return to the Add to Cart Menu? (y/n)");
                System.out.print(">>> ");
                String returnChoice = finalizeSaleInput.next();

                if (returnChoice.equals("y")) {
                    // GO back to addtocart menu
                    System.out.println("\nReturning to Add to Cart Menu...");
                    NewSale newSale = new NewSale();
                    newSale.addToCart();
                    return;
                }
                else if (returnChoice.equals("n")) {
                    //return the quantity of the products back to the inventory
                    System.out.println("\nCanceling the sale. Returning the quantity of the products back to the inventory.");
                    Electronics.returnProduct();
                    Clothings.returnProduct();
                    Toys.returnProduct();
                    Furnitures.returnProduct();
                    
                    // Empty the cart
                    ElectronicsCart.electronicsCart.clear();
                    ClothingsCart.clothingsCart.clear();
                    ToysCart.toysCart.clear();
                    FurnituresCart.furnituresCart.clear();
                    System.out.println("\nCart has been cleared.");

                    // Go back to Sales menu
                    Sales sales = new Sales(LoginManager.getloggedUser(), 0);
                    sales.salesMenu();
                    return;
                }
                else {
                    System.out.println("Invalid choice. Returning to Add to Cart Menu...");
                    NewSale newSale = new NewSale();
                    newSale.addToCart();
                    return;
                }
            }
        }  
    }
    
    // Getter
    public String getloggedUser() {
        return loggedUser;
    }

    public int getCustomerID() {
        return customerID;
    }
}

