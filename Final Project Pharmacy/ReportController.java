public class ReportController {
    
    public void salesReport() {
        // Code to generate a sales report goes here
    }
    
    public void inventoryReport() {
        // Code to generate an inventory report goes here
    }
    
    public void productList() {
        System.out.println("\nList of Products ");
        System.out.println("||-----------------------------------------------------------------------------------------------------------------------------------------||");
        System.out.printf("|| %-10s || %-15s || %-30s || %-10s || %-30s || %-20s ||\n", "ID", "Category", "Name", "Price", "Manufacturer", "Date Added");
        System.out.println("||-----------------------------------------------------------------------------------------------------------------------------------------||");

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
        System.out.println("||-----------------------------------------------------------------------------------------------------------------------------------------||");
    }
    
    public void supplierList() {
        // Code to display a list of suppliers goes here
    }
}
