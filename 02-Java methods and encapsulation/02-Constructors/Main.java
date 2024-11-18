//Default constructor
// class Person {
//     String name;
//     int age;

//     Person() {
//         name = "Unknown";
//         age = 0;
//     }
// }

// Constructor with parameters
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 30); // in parametized constructor, we need to put values in the parameters (args)

        System.out.println("Name: " + p1.name + ", Age: " + p1.age);
    }
}
