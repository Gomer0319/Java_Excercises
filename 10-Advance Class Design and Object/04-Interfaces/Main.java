/* What are Interfaces in Java?
 * Interfaces in Java are used to define a contract of methods that other classes must implement. 
 * This approach ensures that different classes can be used interchangeably when they adhere to the same interface, 
 * facilitating a flexible and consistent way to manage diverse behaviors in a system.
 * 
 * Interfaces in Java are declared using the interface keyword, followed by the interface name.
 * Methods in an interface are abstract by default, which means they must be implemented by subclasses.
 * The subclasses must implement all the abstract methods of the interface.
 * 
 * In implementation, we can create a class that implements the interface and provide the implementation of the methods.
 * 
 */

 // Sample demo of interfaces in Java and sample implementation

 interface Animal {
    void makeSound(); // Abstract method
}

class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!"); // Implementation of abstract method
    }
}

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.makeSound(); // Calling the implemented method
    }
}

/* Situations requiring interfaces in Java:
* - Common behaviors between different classes. 
* - Flexible method Implementation.
*/
