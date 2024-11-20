// Base Class
class Vehicle {
    private String make;
    private String model;
    private int year;
    
    // Default constructor
    public Vehicle() {
        make = "No brand";
        model = "No model";
        year = 2020;
    }
    
    // Constructor public constructor
    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Create public method displayDetails
    public void displayDetails() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
}
