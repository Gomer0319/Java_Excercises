import java.util.*;

// Abstract class
abstract class Animal {
    public void makeSound() {
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

// Add 3 more classes: Bird, Parrot, and Penguin
// Bird should inherit from Animal, and be the new parent class of Parrot and Penguin
class Bird extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Chirp!");
        super.makeSound();
    }
}

// Parrot should inherit from Bird
class Parrot extends Bird {
    @Override
    public void makeSound() {
        System.out.println("I can mimic sounds!");
        super.makeSound();
    }
}

// Penguin should inherit from Bird
class Penguin extends Bird {
    @Override
    public void makeSound() {
        System.out.println("Squawk!");
        super.makeSound();
    }
}

// Main method
public class RunInheritance {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // User input
        System.out.println("Select from the Following: \nD - Dog \nC - Cat \nB - Bird \nP - Parrot \nG - Penguin");
        String choice = input.next();

        // Check user input
        if (choice.equalsIgnoreCase("D")) {
            System.out.println("A dog makes a sound:");
            Dog dog = new Dog();
            dog.makeSound();
        } 
        else if (choice.equalsIgnoreCase("C")) {
            System.out.println("A cat makes a sound:");
            Cat cat = new Cat();
            cat.makeSound();
        }
        else if (choice.equalsIgnoreCase("B")) {
            System.out.println("A bird makes a sound:");
            Bird bird = new Bird();
            bird.makeSound();
        }
        else if (choice.equalsIgnoreCase("P")) {
            System.out.println("A parrot makes a sound:");
            Parrot parrot = new Parrot();
            parrot.makeSound();
        }
        else if (choice.equalsIgnoreCase("G")) {
            System.out.println("A penguin makes a sound:");
            Penguin penguin = new Penguin();
            penguin.makeSound();
        } 
        else {
            System.out.println("Invalid choice.");
        }

        input.close();
    }
}