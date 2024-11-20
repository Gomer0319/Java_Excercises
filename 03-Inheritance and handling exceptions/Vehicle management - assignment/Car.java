//Derived Class (Car)
class Car extends Vehicle {
    private int numDoors;

    // default constructor for Car
    public Car () {
        numDoors = 4;
    }

    // Create public constructor for Car
    public Car(String make, String model, int year, int numDoors) {
        super(make, model, year);
        this.numDoors = numDoors;
    }

    // Override displayDetails method
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of doors: " + numDoors + "\n");
    }
}
