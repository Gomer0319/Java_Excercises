/* What is Getter and Setter in Java?
 * Getter is a method that returns the value of a private variable.
 * Setter is a method that sets the value of a private variable.
 *
 * Getter and Setter are used to access and modify the value of a private variable.
 * 
 * Basic syntax:
 * - Getters: named with get followed by the name of the variable.
 * - Setters: named with set followed by the name of the variable.
 * 
 * Example:
 * public class Person {    
 *     private String name;
 *
 *      public String getName() {
 *         return name;
 *     }
 * 
 *     public void setName(String name) {
 *         this.name = name;
 *     }    
 *}
 */

 // Example demo of Getter and Setter in Java.

 // Main class which uses the Person class.
public class GetterAndSetterDemo { 
    public static void main(String[] args) {
        Person person = new Person(); // Create an object of the Person class.
        person.setName("John"); // Set the name of the person.
        String name = person.getName(); // Get the name of the person.
        System.out.println("Name: " + name);    // Print the name of the person.
    }
}

class Person {
    private String name; // Private variable

    public String getName() { // Getter
        return name;
    }

    public void setName(String name) { // Setter
        this.name = name;
    }    
}

/* Situations where you might use a Getter and Setter:
 * - Encapsulating private fields: Getters and Setters are used to access and modify the value of a private variable.
 * - Data validation: Getters and Setters are used to validate the value of a private variable.
 * - Read-only fields: Getters are used to access the value of a private variable.
 * - Immutable objects: Getters are used to access the value of a private variable. 
 */