/*  What is the Generic class? 
 *  - A generic class is a class that can be instantiated with a type parameter.
 *  - By using generics, you can create a class that can be used with different types of data without having to write multiple classes for each type of data.
 *  - To declare a generic class, use the <T> syntax, where T is the type parameter.
 * 
 * Generic Method
 * - A generic method is a method that can be used with different types of data without having to write multiple methods for each type of data.
 * - By using generics, you can create a method that can be used with different types of data without having to write multiple methods for each type of data.
 * - To declare a generic method, use the <T> syntax, where T is the type parameter.
 * 
 * Bounded Type Parameters
 * - A bounded type parameter is a type parameter that can only be used with a specific type.
 * - To declare a bounded type parameter, use the extends keyword, followed by the type that the type parameter can only be used with.
 *
*/

// Sample demo code using generic class, method, and bounded type parameters (with main method Generics.java)
import java.util.ArrayList;
import java.util.List;

// Generic class declaration with type parameter T for the value to be stored in the class
class GenericClass<T> { // T is the type parameter
    private T value; // The value to be stored in the class 

    public GenericClass(T value) { // Constructor to initialize the value of the class 
        this.value = value; // Assign the value to the class 
    }

    public T getValue() { // Method to get the value of the class
        return value; // Return the value
    }
}

// Generic method declaration with type parameter T for the value to be printed
class GenericMethod<T> { // T is the type parameter
    public void print(T value) { // Method to print the value
        System.out.println(value); // Print the value
    }
}

// Bounded type parameter declaration with type parameter T for the value to be printed
class BoundedTypeParameter<T extends Number> { // T is the type parameter and extends Number. Where is Number? Number is a class that is used to represent numeric values.
    public void print(T value) { // Method to print the value
        System.out.println(value);
    }
}

// Main method to test the generic class, method, and bounded type parameters
public class Generics {
    public static void main(String[] args) {
        GenericClass<String> stringClass = new GenericClass<>("Hello"); // Create a generic class with a string value 
        System.out.println(stringClass.getValue()); // Output: Hello

        GenericMethod<Integer> integerMethod = new GenericMethod<>(); // Create a generic method with an integer value 
        integerMethod.print(42); // Output: 42

        BoundedTypeParameter<Double> doubleBounded = new BoundedTypeParameter<>(); // Create a bounded type parameter with a double value 
        doubleBounded.print(3.14); // Output: 3.14

        List<GenericClass<String>> stringList = new ArrayList<>(); // Create a list of generic classes with strings 
        stringList.add(new GenericClass<>("Hello")); // Add two generic classes to the list
        stringList.add(new GenericClass<>("World")); // Add two generic classes to the list
        System.out.println(stringList.get(0).getValue()); // Output: Hello
        System.out.println(stringList.get(1).getValue()); // Output: World
    }
}




