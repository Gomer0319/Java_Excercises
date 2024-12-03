interface Product {
    // Create Product interface that includes ID, name, price, quantity, and category, that gets and sets the values.
    int getProductID();
    String getProductName();
    double getProductPrice();
    int getProductQty();
    String getCategory();

    void setProduct(int ID, String name, double price, int quantity);
}

// Create Product Category classes (Electronics, Clothings, Toys, Furnitures) that implements the Product interface.
class Electronics implements Product {
    private int ID;
    private String name;
    private double price;
    private int quantity;
    private String category = "Electronics";

    // Set an array to store the Electronics products to be added (Open quantity)
    Electronics[] electronics = new Electronics[100];

    // Constructor
    public Electronics(int ID, String name, double price, int quantity) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Implement interface methods
    @Override
    public int getProductID() {
        return ID;
    }

    @Override
    public String getProductName() {
        return name;
    }

    @Override
    public double getProductPrice() {
        return price;
    }

    @Override
    public int getProductQty() {
        return quantity;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public void setProduct(int ID, String name, double price, int quantity) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
