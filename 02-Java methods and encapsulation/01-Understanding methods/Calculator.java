//Calling a method in Java
public class Calculator {
    // Define a method
    public int addNumbers(int num1, int num2) { // Define access modifier, return type and method name and parameters
        return num1 + num2; // Return statement
    }

    public static void main(String[] args) { // Main method
        Calculator calc = new Calculator(); // Create an object of the Calculator class
        int result = calc.addNumbers(5, 10); // Call the addNumbers method and store the result
        System.out.println("Sum: " + result); // Print the result
    }
}

/*
 * Passing data between methods.
 *
 * public class MessagePrinter {
 * public void printMessage(String message) {
 * System.out.println(message);
 * }
 * 
 * public static void main(String[] args) {
 * MessagePrinter printer = new MessagePrinter();
 * printer.printMessage("Hello, World!");
 * }
 * }
 */
