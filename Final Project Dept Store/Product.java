interface Product {
    // Create Product interface that includes ID, name, price, quantity, and category, that gets and sets the values.
    int getProductID();
    String getProductName();
    double getProductPrice();
    int getProductQty();
    String getCategory();

    void setProduct(int ID, String name, double price, int quantity);
    void setProductQty(int qty);
}