/* Syntax for Inheritance
 * 
 * class SuperClass{
 *  //fields and methods;
 * }
 * 
 * class SubClass extends SuperClass{
 *  //additional fields and methods; 
 * }
 */

 class Animal {
    void eat() {
        System.out.println("This animal eats food.");
    }
 }

 class Dog extends Animal {
    void bark() {
        System.out.println("This dog barks.");
    }
 }

 public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.bark();// Inherited method from the super class
        myDog.eat(); // Method from the sub-class
    }
 }