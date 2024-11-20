class Car extends Vehicle {
    // Provide implementations for the abstract methods (Car)
    @Override
    void fuel () {
        System.out.println("Cars typically use Petrol or Diesel and can start with a key ignition.");
    }

    @Override
    void start () {
        System.out.println("The car has started.");
    }

    @Override
    void stop () {
        System.out.println("The car has stopped.");
    }
}