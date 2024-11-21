/* Working with Scanner and File Classes
 * 
 *Packages and imports:
 * 
 *Packages group-related classes and provide a namespace to prevent naming conflicts. Importing classes from these packages allows you to reference them in your code without using their full path.
 * 
 *Example:
 *To use the the Scanner class, you need to import it from the java.util package:
 *import java.util.Scanner;
 *
 *To use the File class, you need to import it from the java.io package:
 *import java.io.File;
 */

 /* Using the Scanner class
  * 
  *The Scanner class is used to read input from various sources, such as user input, files, and console input.
  *
  *Key methods: (Primary methods)
  * - Scanner(System.in): Creates a Scanner object that reads input from the console.
  * - nextLine(): Reads the next line of input from the console.
  * - nextInt(): Reads the next integer from the console.
  * - nextDouble(): Reads the next double from the console.
  * - nextFloat(): Reads the next float from the console.
  * - nextBoolean(): Reads the next boolean from the console.
  * - next(): Reads the next token from the console.
  * 
  *Key methods: (Secondary methods)
  * - hasNext(): Checks if there is more input available.
  * - hasNextLine(): Checks if there is more input available as a line.
  * - hasNextInt(): Checks if there is more input available as an integer.
  * - hasNextDouble(): Checks if there is more input available as a double.
  * - hasNextFloat(): Checks if there is more input available as a float.
  * - hasNextBoolean(): Checks if there is more input available as a boolean.
  * - close(): Closes the Scanner object.
  */

  // Example demonstrating how to use the Scanner class to read various types of input from the console:
  import java.util.Scanner;
  public class ScannerDemo {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter your name: ");
      String name = scanner.nextLine(); // Read a line of input with String type
      System.out.print("Enter your age: ");
      int age = scanner.nextInt(); // Read an integer
      System.out.print("Enter your height: ");  
      double height = scanner.nextDouble(); // Read a double
      System.out.print("Enter your weight: ");
      float weight = scanner.nextFloat(); // Read a float
      System.out.print("Enter your gender: ");
      boolean gender = scanner.nextBoolean();   // Read a boolean
      System.out.println("Name: " + name + ", Age: " + age + ", Height: " + height + ", Weight: " + weight + ", Gender: " + gender);

      scanner.close(); // Close the scanner
    }
  }