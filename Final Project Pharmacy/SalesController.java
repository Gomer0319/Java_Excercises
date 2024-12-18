import java.util.*;

public class SalesController {
    private String orderID;
    private String productID;
    private String productName;
    private String productCategory;
    private double productTotalPrice;
    private int productQuantity;
    private String orderDateTime;
    private double salesTotalQty;

    public SalesController(String orderID, String productID, String productName, String productCategory,
            double productTotalPrice,
            int productQuantity,
            String orderDateTime) {
        this.orderID = orderID;
        this.productID = productID;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productTotalPrice = productTotalPrice;
        this.productQuantity = productQuantity;
        this.orderDateTime = orderDateTime;
    }

    public SalesController(String productID, String productName, String productCategory, double salesTotalQty) {
        this.productID = productID;
        this.productName = productName;
        this.productCategory = productCategory;
        this.salesTotalQty = salesTotalQty;
    }

    public SalesController() {
        this.orderID = " ";
        this.productID = " ";
        this.productName = " ";
        this.productCategory = " ";
        this.productTotalPrice = 0.0;
        this.productQuantity = 0;
        this.orderDateTime = " ";
    }

    // Create a list to store the sales
    public static List<SalesController> salesList = new ArrayList<>();

    // Create a list to store checked out sales
    public static List<SalesController> checkedOutSalesList = new ArrayList<>();

    public void sellProduct() {
        // Ask customer if they have a prescription
        System.out.println("\nDoes the customer have a prescription?");
        String hasPrescription = Utility.getString("Prescription (y/n): ").toLowerCase();

        // Get product details from the user
        String productID = Utility.getString("Enter product ID: ");

        // Validate input, if no input or 0 is entered, we return to sell menu
        if (productID.isEmpty() || productID.equals("0")) {
            System.out.println("Invalid input. Please enter a valid product ID and/or quantity.");
            return;
        }

        // Display item to sell
        for (Product product : Product.productList) {
            if (product.getProductId().equals(productID)) {
                System.out.println(
                        "\nName: " + product.getProductName() + "   Price: " + product.getProductPrice()
                                + "   Category: "
                                + product.getProductCategory());
                break; // Exit the loop once a match is found
            }
        }
        int quantity = Utility.getInt("Enter quantity: ");
        Utility.userInput.nextLine(); // Consume the newline character

        // Find the product productID
        for (Product product : Product.productList) {
            // Check if the product ID matches
            if (product.getProductId().equals(productID)) {

                // Check if the product requires a prescription. If the input is neither "y" or
                // "n", the system should throw an exception
                if (!hasPrescription.equals("y") && !hasPrescription.equals("n")) {
                    System.out.println("\nInvalid input. Please enter 'y' or 'n'.");
                    return;
                }

                if (product.getProductPrescription().equalsIgnoreCase("y") && !hasPrescription.equals("y")) {
                    System.out.println("\nThis product requires a prescription. Sale not allowed.");
                    return; // Stop selling this product
                }

                double actualQuantityOnHand = product.calculateActualQuantityOnHand();

                // Check if the quantity is available in the ActualQuantityOnHand
                if (actualQuantityOnHand >= quantity) {
                    // Calculate the total price
                    double totalPrice = product.getProductPrice() * quantity;

                    // Prompt the user the transaction
                    System.out
                            .println("\nOrdering : " + product.getProductName() + " x " + quantity + " = " + totalPrice
                                    + "\n");

                    // generate an order ID
                    String orderID = "S" + IdGenerator.generateID("Sales");

                    // Add the sale to the sales list
                    salesList.add(new SalesController(orderID, product.getProductId(), product.getProductName(),
                            product.getProductCategory(),
                            totalPrice, quantity, Utility.getCurrentDateTime()));
                } else {
                    System.out.println("Quantity not available.");
                }
                break; // Exit the loop once a match is found
            }
        }

        // Ask the user if they want to sell another product
        String anotherProduct = Utility.getString("\nSell another product? (y/n): ");
        if (anotherProduct.equalsIgnoreCase("y")) {
            sellProduct(); // Recursively call the method to sell another product
        }

        else if (anotherProduct.equalsIgnoreCase("n")) {
            // Ask if they want to proceed to checkout
            String proceedToCheckout = Utility.getString("Proceed to checkout? (y/n): ");
            if (proceedToCheckout.equalsIgnoreCase("y")) {
                checkOut(); // Call the checkout method

                Utility.clearScreen();
            }

            else if (proceedToCheckout.equalsIgnoreCase("n")) {
                return; // Exit the method
            }

            else {
                System.out.println("Invalid input. Please try again."); // Invalid input
                sellProduct(); // Recursively call the method to sell another product
            }
        }

        else {
            System.out.println("Invalid input. Please try again."); // Invalid input
            sellProduct(); // Recursively call the method to sell another product
        }

    }

    public void voidItem() {
        // Display content of the sales list
        for (SalesController sale : salesList) {
            System.out.println(
                    "\n" + sale.getOrderID() + " | " + sale.getProductID() + " | " + sale.getProductName() + " | "
                            + sale.getProductTotalPrice() + " | " + sale.getProductQuantity() + " | "
                            + sale.getOrderDateTime() + "\n");
        }

        // Prompt the user to enter the order ID of the item to void
        String orderID = Utility.getString("Enter the order ID of the item to void: ");

        // Check if the order ID exists in the sales list
        boolean orderExists = false;
        for (SalesController sale : salesList) {
            if (sale.getOrderID().equals(orderID)) {
                orderExists = true;
                break;
            }
        }

        if (orderExists) {
            // Display the order details
            for (SalesController sale : salesList) {
                if (sale.getOrderID().equals(orderID)) {
                    System.out.println(orderID + " | " + sale.getProductID() + " | " + sale.getProductName() + " | "
                            + sale.getProductTotalPrice() + " | " + sale.getProductQuantity() + " | "
                            + sale.getOrderDateTime());

                    // Ask the user if they want to void the item
                    String voidItem = Utility.getString("Void this item? (y/n): ");
                    if (voidItem.equalsIgnoreCase("y")) {
                        // Remove the item from the sales list
                        salesList.remove(sale);
                        System.out.println("Item voided successfully.");
                        break;
                    } else if (voidItem.equalsIgnoreCase("n")) {
                        System.out.println("Item not voided.");
                        break;
                    } else {
                        System.out.println("Invalid input. Please try again.");
                    }
                }
            }
        }

        else {
            System.out.println("Order ID not found.");
            // Ask the user if they want to void another item
            String voidAnotherItem = Utility.getString("Void another item? (y/n): ");
            if (voidAnotherItem.equalsIgnoreCase("y")) {
                voidItem(); // Recursively call the method to void another item
            }

            else if (voidAnotherItem.equalsIgnoreCase("n")) {
                return; // Exit the method
            }

            else {
                System.out.println("Invalid input. Please try again."); // Invalid input
                voidItem(); // Recursively call the method to void another item
            }
        }
    }

    public void checkOut() {
        System.out.println("\n--------For Checkout--------");

        // Check if there are any sales transactions, if none display an error message
        if (salesList.isEmpty()) {
            System.out.println("\nSales is empty. No sales transactions yet.");
            return;
        }

        System.out.println(
                "||--------------------------------------------------------------------------------------------------------------------------------------------||");
        System.out.printf("|| %-15s | %-15s | %-30s | %-15s | %-15s | %-10s | %-20s ||\n",
                "OrderID", "ProductID",
                "ProductName", "Category",
                "Total Price", "Quantity", "OrderDate");
        System.out.println(
                "||--------------------------------------------------------------------------------------------------------------------------------------------||");
        // Display the total sales
        double totalSales = 0.0;
        for (SalesController sale : salesList) {
            System.out.printf("|| %-15s | %-15s | %-30s | %-15s | %-15.2f | %-10s | %-20s ||\n",
                    sale.getOrderID(),
                    sale.getProductID(),
                    sale.getProductName(),
                    sale.getProductCategory(),
                    sale.getProductTotalPrice(),
                    sale.getProductQuantity(),
                    sale.getOrderDateTime());

            totalSales += sale.getProductTotalPrice();
        }

        System.out.printf("Grand Total: Php %.2f\n", totalSales);

        // Ask the user if they want to checkout
        String checkout = Utility.getString("\nProceed to Payment? (y/n): ");

        Utility.clearScreen();

        if (checkout.equalsIgnoreCase("y")) {
            // Generate a receipt
            System.out.println("\n--------Receipt--------");
            // Display the logged in user's name
            System.out.println("Tendered by: " + Utility.getLoggedInUsername());
            // Display transaction date and time
            System.out.println("Date and Time: " + Utility.getCurrentDateTime());
            System.out.println(
                    "||---------------------------------------------------------------------------------------------------------------------------||");

            System.out.printf("|| %-15s | %-15s | %-30s | %-15s | %-10s | %-20s |\n", "OrderID", "ProductID",
                    "ProductName", "Total Price", "Quantity", "OrderDate");
            System.out.println(
                    "||---------------------------------------------------------------------------------------------------------------------------||");

            for (SalesController sale : salesList) {
                System.out.printf("|| %-15s | %-15s | %-30s | %-15.2f | %-10s | %-20s |\n",
                        sale.getOrderID(),
                        sale.getProductID(),
                        sale.getProductName(),
                        sale.getProductTotalPrice(),
                        sale.getProductQuantity(),
                        sale.getOrderDateTime());
            }

            System.out.println(
                    "||---------------------------------------------------------------------------------------------------------------------------||");

            System.out.printf("Grand Total: Php %.2f\n", totalSales);

            System.out.println("Thank you for purchasing with us!");

            // Add the sales to the checked out sales list
            checkedOutSalesList.addAll(salesList);

            // Clear the sales list
            salesList.clear();

            System.out.println("\n\n\nSales checked out successfully.\n");
        }

        else if (checkout.equalsIgnoreCase("n")) {
            return; // Exit the method
        }

        else {
            System.out.println("Invalid input. Please try again."); // Invalid input
            checkOut(); // Recursively call the method to checkout
        }
    }

    // Method to calculate the total quantity of each product sold
    public static void productTotalSold() {
        // Create a map to group the products by ID, name, and category
        Map<String, Double> salesTotals = new HashMap<>();

        for (SalesController sale : checkedOutSalesList) {
            String productID = sale.getProductID();

            // Add quantity to the existing total or initialize if not found
            salesTotals.put(productID, salesTotals.getOrDefault(productID, 0.0) + sale.getProductQuantity());
        }

        // Update productList with the total quantity sold
        for (Product product : Product.productList) {
            if (salesTotals.containsKey(product.getProductId())) {
                product.setSalesTotalQty(salesTotals.get(product.getProductId()));
            }
        }

    }

    // getters
    public String getOrderID() {
        return orderID;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public double getProductTotalPrice() {
        return productTotalPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public String getOrderDateTime() {
        return orderDateTime;
    }

    public double getSalesTotalQty() {
        return salesTotalQty;
    }

    // setters
    public void setSalesTotalQty(double salesTotalQty) {
        this.salesTotalQty = salesTotalQty;
    }
}
