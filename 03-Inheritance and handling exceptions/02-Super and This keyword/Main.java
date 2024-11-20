class Person {
    String name;
    int age;

    // Default constructor
    Person() {
        name = " ";
        age = 0;
    }

    // Using this keyword in constructor
    // Parameterized constructor
    Person(String name, int age) {
        this.name = name;  // Refers to the instance variable, distinguished from local variable named name.
        this.age = age;    // Refers to the instance variable, distinguished from local variable named age.
    }

    // Using outside constructors *(p1.updateName("Bob");)*
    // Method to update name
    void updateName(String name) {
        this.name = name;  // Refers to the instance variable
    }

    public void shout() {
        System.out.println("This person says Hello!");
    }   
}


// Using super keyword
class Child extends Person {
    public void talk() {
        super.shout();
        System.out.println("The child laughs!");
    }
}

public class Main {
    public static void main(String[] args) {
        // Calls parameterized constructor
        Person p2 = new Person("Alice", 30);
        // Outputs: Name: Alice, Age: 30
        System.out.println("Name: " + p2.name + ", Age: " + p2.age);   
        
        // What is the outside constructor in this code? the updateName method
        // Calls default constructor
        Person p1 = new Person();
        p1.updateName("Bob");
        // Outputs: Name: Bob
        System.out.println("Name: " + p1.name);

        // Calls talk method
        Child child = new Child();
        child.talk();
    }
}
