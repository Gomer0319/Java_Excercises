class SoldProduct {
    private int ID;
    private String name;
    private double price;
    private int quantity;
    private String category;
    private String dateTime; 

    // Constructor
    public SoldProduct(int ID, String name, double price, int quantity, String category, String dateTime) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.dateTime = dateTime;
    }

    //getters
    public int getProductID() {
        return ID;
    }

    public String getProductName() {
        return name;
    }

    public double getProductPrice() {
        return price;
    }

    public int getProductQty() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public String getDateTime() {
        return dateTime;
    }

    //setters
    public void setDateTime (String dateTime) {
        this.dateTime = dateTime;
    }
}
