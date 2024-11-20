class Truck extends Vehicle {
    // Provide implementations for the abstract methods (Truck)
    @Override
    void fuel () {
        System.out.println("Trucks typically use Diesel and can start with a key ignition.");
    }

    @Override
    void start () {
        System.out.println("The truck has started.");
    }

    @Override
    void stop () {
        System.out.println("The truck has stopped.");
    }
}
