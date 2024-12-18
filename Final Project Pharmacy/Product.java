import java.util.*;

public class Product {
    private String inventoryTransactionId;
    private String productId;
    private String productName;
    private String productCategory;
    private double productPrice;
    private double productQuantity;
    private String productExpiry;
    private String productInvoice;
    private String productPrescription;
    private String productManufacturer;
    private String productDateAdded;
    private double productTotalQuantity;
    private double salesTotalQty;
    private double actualQuantityOnHand;
    private double minimumStockLevel;

    // Create a Product List to store the products and a List for the actual
    // Inventory
    public static List<Product> productList = new ArrayList<>();
    public static List<Product> inventoryList = new ArrayList<>();

    // Add dummy data to the Product List
    static {
        productList.add(new Product(IdGenerator.generateID("Product"), "Amlodipine Besylate 5mg", "Hypertension", 5.5,
                "n", "Viatris Specialty Llc", Utility.getCurrentDateTime(), 1000));
        productList.add(new Product(IdGenerator.generateID("Product"), "Seretide 250mcg", "Corticosteroids", 750.00,
                "y", "GSK plc", Utility.getCurrentDateTime(), 5));
        productList.add(new Product(IdGenerator.generateID("Product"), "Rogin-E", "Supplement", 28.75, "n",
                "Bayer Philippines inc.", Utility.getCurrentDateTime(), 100));
    }

    // Constructor
    public Product(String productId, String productName, String productCategory, double productPrice,
            String productPrescription, String productManufacturer, String productDateAdded, double minimumStockLevel) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productPrescription = productPrescription;
        this.productManufacturer = productManufacturer;
        this.productDateAdded = productDateAdded;
        this.minimumStockLevel = minimumStockLevel;
    }

    public Product(String productId, String productName, String productCategory, double productPrice,
            double productTotalQuantity, double salesTotalQty, double actualQuantityOnHand,
            String productPrescription, String productManufacturer, String productDateAdded) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productTotalQuantity = productTotalQuantity;
        this.salesTotalQty = salesTotalQty;
        this.actualQuantityOnHand = actualQuantityOnHand;
        this.productPrescription = productPrescription;
        this.productManufacturer = productManufacturer;
        this.productDateAdded = productDateAdded;
    }

    public Product(String inventoryTransactionId, String productId, String productInvoice, String productName,
            String productCategory, double productPrice, double productQuantity, String productExpiry,
            String productPrescription, String productManufacturer, String productDateAdded) {
        this.inventoryTransactionId = inventoryTransactionId;
        this.productId = productId;
        this.productInvoice = productInvoice;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productExpiry = productExpiry;
        this.productPrescription = productPrescription;
        this.productManufacturer = productManufacturer;
        this.productDateAdded = productDateAdded;
    }

    // Create a method to add the product added from the
    // ProductController.addProduct method
    public static void addProduct(String productId, String productName, String productCategory, double productPrice,
            String productPrescription, String productManufacturer, String productDateAdded, double minimumStockLevel) {
        // Check if ID already exists
        for (Product product : productList) {
            if (product.getProductId().equals(productId)) {
                System.out.println("Product ID " + productId + " already exists.");
                return;
            }
        }

        // Create a new Product object and add it to the list
        Product newProduct = new Product(productId, productName, productCategory, productPrice, productPrescription,
                productManufacturer, productDateAdded, minimumStockLevel);
        productList.add(newProduct);

        // Print success message
        System.out.println("Product " + productName + " added successfully.");
    }

    public static void addToInventory(String inventoryTransactionId, String productId, String productInvoice,
            String productName,
            String productCategory, double productPrice, double productQuantity, String productExpiry,
            String productPrescription, String productManufacturer, String productDateAdded) {
        // Create a new Product object and add it to the list
        Product newProduct = new Product(inventoryTransactionId, productId, productInvoice, productName,
                productCategory, productPrice,
                productQuantity, productExpiry, productPrescription, productManufacturer, productDateAdded);
        inventoryList.add(newProduct);

        // Print success message
        System.out.println("Quantity " + productQuantity + " of " + productName + " added to inventory successfully.");
    }

    public static void updateProduct(String productId) {
        // Find the product by ID
        for (Product product : productList) {
            if (product.getProductId().equals(productId)) {
                // Ask if what value to update
                System.out.println(
                        "\nWhat value do you want to update? \n1. Product Name \n2. Product Category \n3. Product Price \n4. Product Prescription \n5. Product Manufacturer \n6. Expiry Date \n7. Return to Product Menu");

                // Get user input
                int choice = Utility.getInt("Enter your choice: ");
                Utility.userInput.nextLine();

                switch (choice) {
                    case 1:
                        // Update product name
                        System.out.println("\nEnter new product name: ");
                        String productName = Utility.getString("Product Name: ");
                        product.setProductName(productName);
                        System.out.println("\nProduct name updated successfully.");
                        break;
                    case 2:
                        // Update product category
                        System.out.println("\nEnter new product category: ");
                        String productCategory = Utility.getString("Product Category: ");
                        product.setProductCategory(productCategory);
                        System.out.println("\nProduct category updated successfully.");
                        break;
                    case 3:
                        // Update product price
                        System.out.println("\nEnter new product price: ");
                        double productPrice = Utility.getDouble("Product Price: ");
                        product.setProductPrice(productPrice);
                        System.out.println("\nProduct price updated successfully.");
                        break;
                    case 4:
                        // Update product prescription
                        System.out.println("\nEnter new product prescription: ");
                        String productPrescription = Utility.getString("Product Prescription: ");
                        product.setProductPrescription(productPrescription);
                        System.out.println("\nProduct prescription updated successfully.");
                        break;
                    case 5:
                        // Update product manufacturer
                        System.out.println("\nEnter new product manufacturer: ");
                        String productManufacturer = Utility.getString("Product Manufacturer: ");
                        product.setProductManufacturer(productManufacturer);
                        System.out.println("\nProduct manufacturer updated successfully.");
                        break;
                    case 6:
                        // Go to an specific transaction using the transaction ID
                        System.out.println("\nEnter Inventory Transaction ID: ");
                        String inventoryTransactionId = Utility.getString("Inventory Transaction ID: ");
                        for (Product transaction : Product.inventoryList) {
                            if (transaction.getInventoryTransactionId().equals(inventoryTransactionId)) {
                                // Update product expiry date
                                System.out.println("\nEnter new product expiry date: ");
                                String productExpiry = Utility.getString("Product Expiry Date: ");
                                product.setProductExpiry(productExpiry);
                                System.out.println("\nProduct expiry date updated successfully.");
                            }
                        }
                        break;
                    case 7:
                        // Return to product menu
                        System.out.println("\nReturning to product menu.");
                        break;
                    default:
                        // Invalid choice
                        System.out.println("\nInvalid choice. Please try again.");
                        break;
                }
            }
        }
    }

    // Method to calculate the total quantity of each product received
    public static void productTotalQuantity() {
        // Create a map to group the products by ID, name, and category
        Map<String, Double> productTotals = new HashMap<>();

        for (Product product : inventoryList) {
            // Use a combination of productID, name, and category as key
            String productId = product.getProductId();

            // Add quantity to the existing total or initialize if not found
            productTotals.put(productId, productTotals.getOrDefault(productId, 0.0) + product.getProductQuantity());
        }

        // Update productList with the total quantity received
        for (Product product : productList) {
            if (productTotals.containsKey(product.getProductId())) {
                product.setProductTotalQuantity(productTotals.get(product.getProductId()));
            }
        }
    }

    public double calculateActualQuantityOnHand() {
        Product.productTotalQuantity();
        SalesController.productTotalSold();
        return this.productTotalQuantity - this.salesTotalQty;
    }

    // Getters
    public String getInventoryTransactionId() {
        return inventoryTransactionId;
    }

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

    public String getproductExpiry() {
        return productExpiry;
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

    public String getProductInvoice() {
        return productInvoice;
    }

    public double getProductTotalQuantity() {
        return productTotalQuantity;
    }

    public double getSalesTotalQty() {
        return salesTotalQty;
    }

    public double getActualQuantityOnHand() {
        return actualQuantityOnHand;
    }

    public double getMinimumStockLevel() {
        return minimumStockLevel;
    }

    // Setters
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductQuantity(double productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void setProductPrescription(String productPrescription) {
        this.productPrescription = productPrescription;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public void setProductExpiry(String productExpiry) {
        this.productExpiry = productExpiry;
    }

    public void setProductTotalQuantity(double productTotalQuantity) {
        this.productTotalQuantity = productTotalQuantity;
    }

    public void setSalesTotalQty(double salesTotalQty) {
        this.salesTotalQty = salesTotalQty;
    }

    public void setActualQuantityOnHand(double actualQuantityOnHand) {
        this.actualQuantityOnHand = actualQuantityOnHand;
    }

    public void setMinimumStockLevel(double minimumStockLevel) {
        this.minimumStockLevel = minimumStockLevel;
    }
}
