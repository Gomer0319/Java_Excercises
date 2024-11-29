/* Write a Java program to reverse words by implementing stack to hold the letters of the word.
* Other requirements:
* 1. Prompt the user to input a word
* 2. Use the custom stack to reverse the word.
* 3. Print the original and reversed word
*/

import java.util.*;

// Create a Class for the Custom Stack
class CustomStack {
    private int top;
    private char[] stack;

    // Constructor
    public CustomStack(int size) {
        top = -1;
        stack = new char[size];
    }

    // Push Method
    public void push (char ch) {
        // Check if the stack is full
        if (isFull()) {
            System.out.println("Stack is full");
        }
        else {
            // Implement push by incrementing top and storing the character in the stack
            stack[++top] = ch;
        }
    }

    // Pop Method
    public char pop() {
        // Check if the stack is empty
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return '\0'; // Return a null character
        }
        else {
            // Implement pop by decrementing top and returning the character from the stack
            return stack[top--];
        }
    }

    // Check if the stack is full
    public boolean isFull() {
        return top == stack.length - 1; // Return true if top is at the last index
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1; // Return true if top is -1
    }
}

// Create the main class named ReversedWord
public class ReversedWord {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner sc = new Scanner(System.in);

        // Prompt the user to input a word
        System.out.print("Enter a word: ");

        // Store the user input
        String word = sc.nextLine();

        // Create a CustomStack object to hold the letters of the word
        CustomStack stack = new CustomStack(word.length());

        // Push the letters of the word to the stack
        for (char ch : word.toCharArray()) {
            stack.push(ch);
        }
    
        // Pop each character from the stack to reverse the word
        String reversedWord = "";
        while (!stack.isEmpty()) {
            reversedWord += stack.pop();
        }

        // Print the original and reversed word
        System.out.println("Original word: " + word);
        System.out.println("Reversed word: " + reversedWord);
    }
}