//Derived Class (Truck)
class Truck extends Vehicle {
    private double payloadCapacity;

    // default constructor for Truck
    public Truck () {
        payloadCapacity = 0.0;
    }

    // Create public constructor for Truck
    public Truck(String make, String model, int year, double payloadCapacity) {
        super(make, model, year);
        this.payloadCapacity = payloadCapacity;
    }

    // Override displayDetails method
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Payload capacity: " + payloadCapacity + "\n");
    }
}
