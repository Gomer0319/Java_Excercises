import java.util.*;

// Create a JAVA class named SimpleArrayOperations that includes methods for insertion and displaying array elements.
public class SimpleArrayOperations {
    // Create a method for inserting elements into the array
    public static void insertElement(int[] array, int index, int value) {
        if (index >= 0 && index <= array.length) {
            array[index] = value;
            System.out.println("Element inserted successfully. \n");
        }
        else {
            System.out.println("Invalid index. Element not inserted. \n");
        }
    }

    // Create a method for displaying the array
    public static void displayArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Initialize scanner for user input
        Scanner userInput = new Scanner(System.in);

        // Create a menu-driven approach in the main method to allow user to perform operations on the array.
        System.out.print("Enter the capacity of the array: ");
        // store the capacity of the array
        int capacity = userInput.nextInt();

        // check if there is an input
        if (capacity == 0) {
            System.out.println("Invalid input. Please enter a valid capacity.");
        }
        // check if the input is a String instead of a number
        // else if (userInput.hasNextLine()) {
        //     System.out.println("Invalid input. Please enter a valid capacity.");
        // }
        else {
            // create an array with the specified capacity
            int[] array = new int[capacity];
        
            while (true) {
                // Show the main menu of what to do with the array
                System.out.println("Menu");
                System.out.println("1. Insert an element");
                System.out.println("2. Display the array");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                // Get the user's choice
                int choice = userInput.nextInt();

                // Perform the selected operation based on the user's choice
                switch (choice) {
                    case 1:
                        System.out.print("Enter element to insert: ");
                        int valueInput = userInput.nextInt();
                        System.out.print("Enter position to insert: ");
                        int positionInput = userInput.nextInt();
                        insertElement(array, positionInput, valueInput);
                        break;
                    case 2:
                        System.out.println("Displaying Array: ");
                        System.out.print("Array elements: ");
                        displayArray(array);
                        break;
                    case 3:
                        System.out.println("Exiting the program.");
                        System.exit(0);
                        userInput.close();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        }
    }
}

