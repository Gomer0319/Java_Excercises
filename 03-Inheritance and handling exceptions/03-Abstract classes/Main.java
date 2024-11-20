// Abstract classes are classes that can be declared without an implementation. They can be used as base classes for other classes.
abstract class House {
    // Abstract method for showing the type of the house to be implemented by subclasses
    abstract void showType();

    // concrete method for opening the door.
    public void openDoor() {
        System.out.println("Opening the door...");
    }
}

// Specific house implementations
// Implementing mansion with its own characteristics
class Mansion extends House {
    // Overriding the abstract method to show the type of the mansion
    @Override
    void showType() {
        System.out.println("This is a mansion.\n");
    }
}

// Implementing Villa with its own characteristics
class Villa extends House {
    // Overriding the abstract method to show the type of the villa
    @Override
    void showType() {
        System.out.println("This is a Villa.\n");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // instantiating mansion
        House mansion = new Mansion();
        // calling methods
        mansion.openDoor();
        mansion.showType();

        // instantiating villa
        House villa = new Villa();
        // calling methods
        villa.openDoor();
        villa.showType();
    }
}