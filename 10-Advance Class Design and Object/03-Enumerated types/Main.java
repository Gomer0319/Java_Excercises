/* What are Enumerated types in Java?
 * - Enumerated types are a type of data that can have a limited number of values.
 * - They are used to represent a set of possible values. 
 * - They are declared using the enum keyword. 
 * - They are declared inside a class. 
*/

// Sample demo of enumerated types in Java and sample implementation

enum Color { // Enumerated types
    RED,
    GREEN,
    BLUE
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Color.RED); // Accessing enumerated types values using dot operator
        System.out.println(Color.GREEN);
        System.out.println(Color.BLUE);
    }
}


// another example

// enum Month { // Enumerated types
//     JANUARY,
//     FEBRUARY,
//     MARCH,
//     APRIL,  
//     MAY,
//     JUNE,   
//     JULY,
//     AUGUST,
//     SEPTEMBER,
//     OCTOBER,    
//     NOVEMBER,
//     DECEMBER
// }

// public class Main {
//     public static void main(String[] args) {
//         System.out.println(Month.JANUARY); // Accessing enumerated types values using dot operator
//         System.out.println(Month.FEBRUARY);
//         System.out.println(Month.MARCH);
//         System.out.println(Month.APRIL);
//         System.out.println(Month.MAY);
//         System.out.println(Month.JUNE);
//         System.out.println(Month.JULY);
//         System.out.println(Month.AUGUST);
//         System.out.println(Month.SEPTEMBER);
//         System.out.println(Month.OCTOBER);
//         System.out.println(Month.NOVEMBER);
//         System.out.println(Month.DECEMBER);
//     }
// }
