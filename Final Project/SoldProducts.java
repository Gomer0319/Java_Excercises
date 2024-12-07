import java.util.ArrayList;
import java.util.List;

// Create a SoldProducts class to store the products sold from the Sales class
class SoldProducts {
    // Create a list to store the products sold
    private static List<SoldProduct> soldProductList = new ArrayList<>();

    // Create a method to add products to the finalizeSale class (items that are sold)
    public static void addSoldProducts(SoldProduct product) {
        soldProductList.add(product);
    }

    // Create a method that displays the products sold
    public void displaySoldProducts() {
        System.out.println("\n=============================================================");
        System.out.println("                            Sales                      ");
        System.out.println("-------------------------------------------------------------");
        System.out.printf("|| %-20s || %-20s || %-30s || %-10s || %-15s ||%n", "Date", "ID", "Product Name", "Quantity", "Total");
        System.out.println("=============================================================");
        // Check if there are any products sold in the SoldProduct list. If there are none, print a message that there are no sales yet, otherwise, print the products sold
        if (soldProductList.size() == 0) {
            System.out.println("There are no sales yet.");
        } else {
            for (SoldProduct product : soldProductList) {

                System.out.printf("|| %-20s || %-20s || %-30s || %-10d || %-15f ||%n", product.getDateTime() ,product.getCategory() + product.getProductID(), product.getProductName(), product.getProductQty(), product.getProductPrice() * product.getProductQty());
            }
        }
        System.out.println("=============================================================");
    }
}
