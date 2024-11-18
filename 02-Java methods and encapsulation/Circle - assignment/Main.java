import java.util.*;

// Create a class named Circle 
class Circle {
    double radius;
    double pi = 3.1416;

    // Constructor with a parameter for the radius
    public Circle(double r) {
        radius = r;
    }

    // Default constructor
    public Circle() {
        radius = 1.0;
    }

    // Implement getArea() method
    public double getArea() {
        return pi * (radius * radius);
    }

    // Implement getCircumference() method
    public double getCircumference() {
        return 2 * pi * radius;
    }

    // Implement displayDetails() method
    public void displayDetails() {
        System.out.println("\nCircle Details: ");
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getArea());
        System.out.println("Circumference: " + getCircumference());
    }
}

public class Main {
    public static void main(String[] args) {
        
        // Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Initialize default Circle object
        Circle defaultCircle = new Circle();

        // Capture user input for radius
        System.out.println("\nEnter desired radius: ");
        double radius = input.nextDouble();

        Circle circle;

        // Initialize Circle object with user input
        circle = new Circle(radius);

        // Display circle details
        circle.displayDetails();

        // Display default circle details
        defaultCircle.displayDetails();

        input.close();
    }
}