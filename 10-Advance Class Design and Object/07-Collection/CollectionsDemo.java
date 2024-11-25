/*  What are Collections in Java?
* Collections are used to store multiple items in a single variable.
* They provide standardized ways of storing, retrieving and manipulating collections of objects, offering different types of data structures (such as lists, sets, maps, etc.).
*
* Programming syntax:
* - Java Collections framework includes interfaces such as List, Set, Map, etc. which defines standard operations for different types of collections.
* - Classes like ArrayList, HashSet, HashMap, etc. implement these interfaces and provide implementations for different collection data structures.
* 
* Example for ArrayList:(to show syntax)
* import java.util.ArrayList;
* import java.util.List;
*
* public class Example {
*   public static void main(String[] args) {
*     List<String> fruits = new ArrayList<>(); <- List<String> is a generic type
*     fruits.add("apple");
*     fruits.add("banana");
*     fruits.add("orange");
*     System.out.println(fruits);
*   }
* }
*
* Example for HashSet:(to show syntax)
* import java.util.HashSet;
* import java.util.Set;
*
* public class Example {
*   public static void main(String[] args) {
*     Set<Integer> numbers = new HashSet<>(); <- Set<Integer> is a generic type <-Set<Integer> is a generic type
*     numbers.add(1);
*     numbers.add(2);
*     numbers.add(3);
*     System.out.println(numbers);
*   }
* }
*
* Example for HashMap:(to show syntax)
* import java.util.HashMap;
* import java.util.Map;
*
* public class Example {
*   public static void main(String[] args) {
*     Map<String, Integer> scores = new HashMap<>(); <- Map<String, Integer> is a generic type
*     scores.put("Alice", 90);
*     scores.put("Bob", 85);
*     scores.put("Charlie", 95);
*     System.out.println(scores);
*   }
* }
*/

//Sample demo applying Collections with the help of ArrayList, HashSet and HashMap:

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class CollectionsDemo {
    public static void main(String[] args) {
        // Creating ArrayList
        ArrayList<String> hobby = new ArrayList<>();
        hobby.add("Cricket");
        hobby.add("Reading");
        hobby.add("Coding");

        //Creating HashSet
        HashSet<Integer> roll = new HashSet<>();
        roll.add(1);
        roll.add(2);
        roll.add(3);

        //Creating HashMap
        HashMap<String, Integer> student = new HashMap<>();
        student.put("Alice", 90);
        student.put("Bob", 85);
        student.put("Charlie", 95);

        System.out.println("Hobby: " + hobby);
        System.out.println("Roll: " + roll);
        System.out.println("Student: " + student);
    }
}

/* Situations where Collections are used:
* - Collections are used in storing and managing groups of objects. 
* - Collections are used for data organization and manipulation.
* - Ensuring uniqueness of elements.
* - Effiecient lookup and retrieval.
*/
