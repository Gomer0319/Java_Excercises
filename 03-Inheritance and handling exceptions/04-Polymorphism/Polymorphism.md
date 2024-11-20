## 2 kinds of polymorphism:

1. **Compile time polymorphism (method overloading)**
   
    Occurs when multiple methods in the same class have the same name but different parameters. The method to be called is determined at compile time-based on the method signature. Method overloading provides flexibility by allowing the same method name to handle different input types.

    Example: 
    ```java
    class Printer {
       public void print(String text) {
           System.out.println(text);
       }

       public void print(int number) {
           System.out.println(number);
       }
    }
    ```

2. **Runtime polymorphism (method overriding)**
   
   occurs when a subclass provides a specific implementation of a method already defined in its parent class. The method to be invoked is determined at runtime based on the actual object type. Runtime polymorphism allows objects to be treated as instances of their parent class while enabling the execution of subclass-specific behavior.

   Example:
   ```java
    class Animal {
        public void sound() {
            System.out.println("The animal makes a sound");
        }
    }

    class Dog extends Animal {
        @Override
        public void sound() {
            System.out.println("The dog barks");
        }
    }

    class Cat extends Animal {
        @Override
        public void sound() {
            System.out.println("The cat meows");
        }
    }

    public class Main {
        public static void main(String[] args) {
            Animal myAnimal = new Animal();  // Create an Animal object
            Animal myDog = new Dog();        // Create a Dog object
            Animal myCat = new Cat();        // Create a Cat object

            myAnimal.sound();  // Outputs: The animal makes a sound
            myDog.sound();     // Outputs: The dog barks
            myCat.sound();     // Outputs: The cat meows
        }
    }
    ```

## Situations Requiring Polymorphism

1. **Dynamic Behavior Handling:** When using a common method but having different implementations     based on the object type.

   *Example:* In a graphic design application, you might have a common draw() method for various shapes (e.g., circles, squares), each with its drawing logic.



2. **Extensible Code:** When you want to introduce new types or functionalities without changing existing code.

   *Example:* A payment processing system that handles multiple payment methods (e.g., credit card, PayPal) with a shared processPayment() method, but each method has a specific processing logic.