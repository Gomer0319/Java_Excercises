class Motorcycle extends Vehicle {
    // Provide implementations for the abstract methods (Motorcycle)
    @Override
    void fuel () {
        System.out.println("Motorcycles typically use Gasoline and can start with a kickstart.");
    }

    @Override  
    void start () {
        System.out.println("The motorcycle has started.");
    }

    @Override
    void stop () {
        System.out.println("The motorcycle has stopped.");
    }
}
