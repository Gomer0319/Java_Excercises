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
    public static void displaySoldProducts() {
        System.out.println("\n=============================================================");
        System.out.println("                            Sales                      ");
        System.out.println("-------------------------------------------------------------");
        System.out.println("||        ID       ||   Product Name    ||  Qty ||   Total    ||");
        System.out.println("=============================================================");
        for (SoldProduct product : soldProductList) {
            // Check if there are any products in the soldProductList
            if (soldProductList.size() == 0) {
                System.out.println("No products sold yet.");
            }
            else {
                System.out.println("|| " + product.getCategory() + product.getProductID() + " || " + product.getProductName() + " || " + product.getProductQty() + " || " + product.getProductPrice() * product.getProductQty() + " ||");
            }
            System.out.println("=============================================================");
        }
    }
}
