package Sales;

// Create a Cart interface to store cart values in connection with sales and Products
public interface Cart {
    // Create
    int getProductID();

    int getProductQty();

    String getProductName();

    double getProductPrice();

    String getCategory();

    double getTotalCost();

    void setProduct(int ID, String name, double price, int quantity);

    void setProductQty(int quantity);
}