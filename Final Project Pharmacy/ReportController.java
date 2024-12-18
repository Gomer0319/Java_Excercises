import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class ReportController {

        public void salesReport() {
                // Generate sales report
                System.out.println("\n--------Sales Report--------");

                // Check if there are any checked out sales transactions, if none display an
                // error message
                if (SalesController.checkedOutSalesList.isEmpty()) {
                        System.out.println("\nSales is empty. No sales transactions yet.");
                        return;
                }

                System.out.println(
                                "||-------------------------------------------------------------------------------------------------------------------------------------------------||");
                System.out.printf("|| %-15s || %-15s || %-30s || %-15s || %-15s || %-10s || %-20s ||\n", "OrderID",
                                "ProductID",
                                "ProductName", "Category", "Total Price", "Quantity", "OrderDate");
                System.out.println(
                                "||-------------------------------------------------------------------------------------------------------------------------------------------------||");

                // Get sales data from the <Sales> List from SalesController.java and display it
                for (SalesController sales : SalesController.checkedOutSalesList) {
                        // Display the sales data in the sales list
                        // Check if there are any sales transactions, if none display an error message
                        System.out.printf("|| %-15s || %-15s || %-30s || %-15s || %-15.2f || %-10d || %-20s ||\n",
                                        sales.getOrderID(),
                                        sales.getProductID(),
                                        sales.getProductName(),
                                        sales.getProductCategory(),
                                        sales.getProductTotalPrice(),
                                        sales.getProductQuantity(),
                                        sales.getOrderDateTime());
                }
                System.out.println(
                                "||-------------------------------------------------------------------------------------------------------------------------------------------------||");

        }

        public void receivingReport() {
                // Generate an inventory report of available products
                System.out.println("\n--------Receiving Report--------");
                System.out.println(
                                "||-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------||");
                System.out.printf(
                                "|| %-15s || %-10s || %-10s || %-15s || %-30s || %-10s || %-10s || %-10s || %-15s || %-30s || %-20s ||\n",
                                "InvtyTransID", "ID", "Invoice", "Category", "Name", "Price", "Qty", "Expiry",
                                "Prescription",
                                "Manufacturer", "Date Added");
                System.out.println(
                                "||-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------||");

                // Get product data from the <Product> List from Product.java and display it
                for (Product transaction : Product.inventoryList) {
                        // Display the product data in the inventory list
                        // Check if there are any inventory transactions, if none, display an error
                        // message
                        if (Product.inventoryList.isEmpty()) {
                                System.out.println("\nInventory is empty. No inventory transactions yet.");
                                return;
                        } else {
                                System.out.printf(
                                                "|| %-15s || %-10s || %-10s || %-15s || %-30s || %-10.2f || %-10.2f || %-10s || %-15s || %-30s || %-20s ||\n",
                                                transaction.getInventoryTransactionId(),
                                                transaction.getProductId(),
                                                transaction.getProductInvoice(),
                                                transaction.getProductCategory(),
                                                transaction.getProductName(),
                                                transaction.getProductPrice(),
                                                transaction.getProductQuantity(),
                                                transaction.getproductExpiry(),
                                                transaction.getProductPrescription(),
                                                transaction.getProductManufacturer(),
                                                transaction.getProductDateAdded());
                        }
                }
                System.out.println(
                                "||-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------||\n");
        }

        public void productList() {
                System.out.println("\nList of Products ");
                System.out.println(
                                "||-----------------------------------------------------------------------------------------------------------------------------------------||");
                System.out.printf("|| %-10s || %-15s || %-30s || %-10s || %-30s || %-20s ||\n", "ID", "Category",
                                "Name",
                                "Price", "Manufacturer", "Date Added");
                System.out.println(
                                "||-----------------------------------------------------------------------------------------------------------------------------------------||");

                // Display a list of products that is enrolled in the Product list
                for (Product product : Product.productList) {
                        System.out.printf("|| %-10s || %-15s || %-30s || %10.2f || %-30s || %-20s ||\n",
                                        product.getProductId(),
                                        product.getProductCategory(),
                                        product.getProductName(),
                                        product.getProductPrice(),
                                        product.getProductManufacturer(),
                                        product.getProductDateAdded());
                }
                System.out.println(
                                "||-----------------------------------------------------------------------------------------------------------------------------------------||");
        }

        public void supplierList() {
                // Check if there are any products in the product list
                if (Product.productList.isEmpty()) {
                        System.out.println("\nSupplier list is empty. No suppliers yet.");
                        return;
                }

                // Create a Set to store unique supplier names
                Set<String> uniqueSupplierNames = new HashSet<>();

                // Display the header
                System.out.println("\nList of Suppliers/Manufacturers");
                System.out.println(
                                "||-----------------------------------------------------------------------------------------------------------------------------------------||");
                System.out.printf("|| %-20s || %-30s ||\n", "Date Added", "Name of Supplier/Mfgr");
                System.out.println(
                                "||-----------------------------------------------------------------------------------------------------------------------------------------||");

                // Iterate through the product list and display suppliers
                for (Product product : Product.productList) {
                        String supplierName = product.getProductManufacturer();

                        // Check if the supplier name is already in the set
                        if (!uniqueSupplierNames.contains(supplierName)) {
                                // Add to the set and display the supplier details
                                uniqueSupplierNames.add(supplierName);
                                System.out.printf("|| %-20s || %-30s ||\n", product.getProductDateAdded(),
                                                supplierName);
                        }
                }

                System.out.println(
                                "||-----------------------------------------------------------------------------------------------------------------------------------------||");
        }

        // Create a method named inventoryReport where we get the overall qty received
        // of an item, and the overall sales of the item, to get the actual qty on hand
        public static void inventoryReport() {
                Product.productTotalQuantity();
                SalesController.productTotalSold();

                // Alert for expiring items
                System.out.println("\nChecking for expiring items...");
                boolean expiringItemsFound = false;

                // Define the range for "expiring soon" (e.g., within 30 days)
                final int EXPIRY_ALERT_DAYS = 30;
                LocalDate currentDate = LocalDate.now();

                System.out.println(
                                "||------------------------------------------------------------------------------------------------------------------------------------------------------------------||");
                System.out.printf("|| %-15s || %-30s || %-15s || %-15s || %-10s || %-15s || %-10s || %-22s ||\n",
                                "InvtyTransID", "Name", "Category", "RcvInvoice", "Qty", "Expiry Date", "Days Left",
                                "Manufacturer");
                System.out.println(
                                "||------------------------------------------------------------------------------------------------------------------------------------------------------------------||");
                for (Product transaction : Product.inventoryList) {
                        LocalDate expiryDate = LocalDate.parse(transaction.getproductExpiry());
                        long daysUntilExpiry = ChronoUnit.DAYS.between(currentDate, expiryDate);

                        if (daysUntilExpiry > 0 && daysUntilExpiry <= EXPIRY_ALERT_DAYS) {
                                expiringItemsFound = true;
                                System.out.printf(
                                                "|| %-15s || %-30s || %-15s || %-15s || %-10.2f || %-15s || %-10d || %-22s ||\n",
                                                transaction.getInventoryTransactionId(),
                                                transaction.getProductName(),
                                                transaction.getProductCategory(),
                                                transaction.getProductInvoice(),
                                                transaction.getProductQuantity(),
                                                transaction.getproductExpiry(),
                                                daysUntilExpiry,
                                                transaction.getProductManufacturer());
                        }
                }

                if (!expiringItemsFound) {
                        System.out.printf("\n %70s \n",
                                        "No items are expiring within the next " + EXPIRY_ALERT_DAYS + " days.");
                }

                System.out.println(
                                "||------------------------------------------------------------------------------------------------------------------------------------------------------------------||");

                // Display the actual inventory
                System.out.println("\nActual Inventory");
                System.out.println(
                                "||--------------------------------------------------------------------------------------------------------------------------------------------||");
                System.out.printf("|| %-10s || %-30s || %-15s || %-10s || %-10s || %-15s || %-10s || %-10s ||\n", "ID",
                                "Name",
                                "Category", "Received",
                                "Sold", "Qty On Hand", "mSL", "Status");
                System.out.println(
                                "||--------------------------------------------------------------------------------------------------------------------------------------------||");

                for (Product product : Product.productList) {
                        double actualQty = product.calculateActualQuantityOnHand();
                        String status = (actualQty <= product.getMinimumStockLevel()) ? "Restock" : "OK";

                        System.out.printf(
                                        "|| %-10s || %-30s || %-15s || %-10s || %-10s || %-15s || %-10s || %-10s ||\n",
                                        product.getProductId(),
                                        product.getProductName(),
                                        product.getProductCategory(),
                                        product.getProductTotalQuantity(),
                                        product.getSalesTotalQty(),
                                        actualQty,
                                        product.getMinimumStockLevel(),
                                        status);
                }
                System.out.println(
                                "||--------------------------------------------------------------------------------------------------------------------------------------------||");
        }
}
