import java.util.ArrayList;
import java.util.List;

public class Product {
    private String productId;
    private String productName;
    private String productCategory;
    private double productPrice;
    private double productQuantity;
    private String productPrescription;
    private String productManufacturer;
    private String productDateAdded;

    // Create a Product List to store the products
    public static List<Product> productList = new ArrayList<>();

    // Constructor
    public Product(String productId, String productName, String productCategory, double productPrice, String productPrescription, String productManufacturer, String productDateAdded) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productPrescription = productPrescription;
        this.productManufacturer = productManufacturer;
        this.productDateAdded = productDateAdded;
    }

    // Create a method to add the product added from the ProductController.addProduct method
    public static void addProduct(String productId, String productName, String productCategory, double productPrice, String productPrescription, String productManufacturer, String productDateAdded) {
        // Check if ID already exists
        for (Product product : productList) {
            if (product.getProductId().equals(productId)) {
                System.out.println("Product ID " + productId + " already exists.");
                return;
            }
        }

        // Create a new Product object and add it to the list
        Product newProduct = new Product(productId, productName, productCategory, productPrice, productPrescription, productManufacturer, productDateAdded);
        productList.add(newProduct);

        // Print success message
        System.out.println("Product " + productName + " added successfully.");
    }

    // Getters
    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public double getProductQuantity() {
        return productQuantity;
    }

    public String getProductPrescription() {
        return productPrescription;
    }

    public String getProductManufacturer() {    
        return productManufacturer;
    }

    public String getProductDateAdded() {
        return productDateAdded;
    }
}
