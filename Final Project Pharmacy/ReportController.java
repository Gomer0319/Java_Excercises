public class ReportController {

    public void salesReport() {
        // Code to generate a sales report goes here
    }

    public void inventoryReport() {
        // Generate an inventory report of available products
        System.out.println("\n--------Inventory Report--------");
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
        System.out.printf("|| %-10s || %-15s || %-30s || %-10s || %-30s || %-20s ||\n", "ID", "Category", "Name",
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
        // Check if there are any suppliers, if none, display an error message
        if (Product.productList.isEmpty()) {
            System.out.println("\nSupplier list is empty. No suppliers yet.");
            return;
        } else {
            // Display list of suppliers/Manufacturers that is enrolled in the products list
            System.out.println("\nList of Suppliers/Manufacturers ");
            System.out.println(
                    "||-----------------------------------------------------------------------------------------------------------------------------------------||");
            System.out.printf("|| %-20s || %-30s ||\n", "Date Added", "Name of Supplier/Mfgr");
            System.out.println(
                    "||-----------------------------------------------------------------------------------------------------------------------------------------||");

            // Display a list of suppliers that is enrolled in the Product list
            for (Product product : Product.productList) {
                System.out.printf("|| %-20s || %-30s ||\n", product.getProductDateAdded(),
                        product.getProductManufacturer());
            }
            System.out.println(
                    "||-----------------------------------------------------------------------------------------------------------------------------------------||");
        }
    }
}
