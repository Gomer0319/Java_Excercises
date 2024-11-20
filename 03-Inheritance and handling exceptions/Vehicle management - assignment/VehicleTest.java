// Main Class (public class VehicleTest)
public class VehicleTest {
    public static void main(String[] args) {
        // Create instances for Car and Truck
        Car car = new Car("Toyota", "Corolla", 2020, 4);
        Truck truck = new Truck("Ford", "F-150", 2019, 1300.5);

        // Call displayDetails method
        car.displayDetails();
        truck.displayDetails();
    }
}