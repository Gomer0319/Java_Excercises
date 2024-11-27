import java.util.*;

// Create a JAVA class named SimpleArrayOperations that includes methods for insertion and displaying array elements.
public class SimpleArrayOperations {
    // Create a method for inserting elements into the array
    public static void insertElement(int[] array, int index, int value) {
        if (index >= 0 && index < array.length) {
            array[index] = value;
            System.out.println("Element inserted successfully. \n");
        }
        else {
            System.out.println("Invalid index. Element not inserted. \n");
        }
    }

    // Create a method for searching elements in the array
    public static void searchElement(int[] array, int value) {
        boolean found = false; // flag to check if the element is found. 
        for (int i = 0; i < array.length; i++) { // loop through the array
            if (array[i] == value) { // check if the element is found
                found = true; // set the flag to true
                break;
            }
        }
        if (found == true) {
            System.out.println("Element found in position: " + Arrays.binarySearch(array, value) + ". \n"); // Arrays.binarySearch(array, value) returns the index of the element
        }
        else {
            System.out.println("Element not found. \n");
        }
    }

    // Create a method for traversing the array for min and max
    public static void traverseArray(int[] array) {
        // initialize min and max
        int min = array[0];
        int max = array[0];

        // find min and max in the array through a loop
        for (int num : array) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        System.out.print("Minimum element: " + min + ". \n");
        System.out.println("Maximum element: " + max + ". \n");
    }

    // Create a method for displaying the array
    public static void displayArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println("\n");
    }

    // Create a method for deleting an element from the array
    public static void deleteElement(int[] array, int index) {
        if (index >= 0 && index < array.length) { // check if the index is valid
            for (int i = index; i < array.length - 1; i++) { // shift elements to the left to fill the gap at the deleted index
                array[i] = array[i + 1]; // copy the next element to the current index
            }
            array[array.length - 1] = 0; // set the last element to 0
            System.out.println("Element at index " + index + " deleted successfully. \n");
        }
        else {
            System.out.println("Invalid index. Element not deleted. \n");
        }
    }

    public static void main(String[] args) {
        // Initialize scanner for user input
        Scanner userInput = new Scanner(System.in);
        int capacity = 0; // initialize capacity

        // Loop until a valid capacity is entered
        while (true) {
            try { // try to create an array with the specified capacity
                System.out.print("Enter the capacity of the array: ");
                // store the capacity of the array
                capacity = userInput.nextInt();

                // This checks if the capacity is greater than 0
                if (capacity > 0) {
                    break; // exit the loop if a valid capacity is entered
                }
                else {
                    System.out.println("Invalid capacity. Please enter a positive integer. \n");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a positive integer. \n");
                userInput.nextLine(); // clear the input buffer
            }
        }

        // create an array with the specified capacity
        int[] array = new int[capacity];
        
        while (true) {
            // Show the main menu of what to do with the array
            System.out.println("Menu");
            System.out.println("1. Insert an element");
            System.out.println("2. Search an element");
            System.out.println("3. Traverse the array");
            System.out.println("4. Display the array");
            System.out.println("5. Delete an element");
            System.out.println("6. Exit");
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
                    System.out.print("Enter element to search: ");
                    int searchValue = userInput.nextInt();
                    searchElement(array, searchValue);
                    break;
                case 3:
                    traverseArray(array);
                    break;
                case 4:
                    System.out.println("Displaying Array: ");
                    System.out.print("Array elements: ");
                    displayArray(array);
                    break;
                case 5:
                    System.out.print("Enter position to delete: ");
                    int deletePosition = userInput.nextInt();
                    deleteElement(array, deletePosition);
                    break;
                case 6:
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

