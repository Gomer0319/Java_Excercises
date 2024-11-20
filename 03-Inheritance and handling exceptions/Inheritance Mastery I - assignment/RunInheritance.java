import java.util.*;

// Abstract class
abstract class Animal {
    void makeSound() {
        System.out.println("Some generic animal sound.");
    }
}

// Child class dog and cat
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark!");
        super.makeSound();
    }  
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
        super.makeSound();
    }
}

// Main method
public class RunInheritance {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // User input
        System.out.println("Press D for Dog, or C for Cat");
        String choice = input.next();

        // Check user input
        if (choice.equalsIgnoreCase("D")) {
            Dog dog = new Dog();
            dog.makeSound();
        } else if (choice.equalsIgnoreCase("C")) {
            Cat cat = new Cat();
            cat.makeSound();
        }

        input.close();
    }
}