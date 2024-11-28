## What is a Stack (Java)?

A stack is a data structure that is used to store data in a LIFO (Last In First Out) manner. This means that the last item added to the stack will be the first item removed from the stack.

> **Analogy:**
> A stack of books on a shelf is a stack. The last book added to the stack is the first book removed from the stack. The books are stacked on top of each other in a LIFO (Last In First Out) manner. This means also the the middle and bottom books are removed from the stacks later respectively than the top book. The concept of **push** and **pop** is also used to add and remove items from the stack.

---

### Intro to Stacks (Java)

A stack is a collection of elements with two main principal operations:

1. Push: Add an element to the top of the stack.
2. Pop: Remove the top element from the stack.

Other common operations include:

1. Peek: Get the top element from the stack without removing it.
2. IsEmpty: Check if the stack is empty.
3. IsFull: Check if the stack is full.

---

Sample implementation of a stack in Java:

```java
public class Stack {
    private int[] stack;
    private int top;
    private int maxSize;

    // Constructor
    public Stack(int maxSize) {
        this.maxSize = maxSize; // Set the maximum size of the stack
        this.stack = new int[maxSize]; // Create an array to store stack elements
        this.top = -1; // Initialize top to -1 to indicate an empty stack
    }

    // Push an element onto the stack
    public void push(int element) {
        if (isEmpty()) { //  Check if the stack is full
            System.out.println("Stack is full. Cannot push element.");
        }
        else {
            stack[++top] = element; // Increment top and add the element to the stack
        }
    }

    // Pop an element from the stack
    public int pop() {
        if (isEmpty()) { // Check if the stack is empty
            System.out.println("Stack is empty. Cannot pop element.");
            return -1; // Return -1 to indicate an empty stack
        }
        else {
            return stack[top--]; // Decrement top and return the element from the stack
        }
    }

    // Peek at the top element of the stack
    public int peek() {
        if (isEmpty()) { // Check if the stack is empty
            System.out.println("Stack is empty. Cannot peek element.");
            return -1; // Return -1 to indicate an empty stack
        }
        else {
            return stack[top]; // Return the top element from the stack
        }
    }

    // isEmpty() method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1; // Return true if top is -1 (empty), false otherwise
    }

    // isFull() method to check if the stack is full
    public boolean isFull() {
        return top == maxSize - 1; // Return true if top is maxSize - 1 (full), false otherwise
    }
}

public class StackExample {
    public class static void main(String[] args) {
        // Initialize a stack with a maximum size of 5
        Stack stack = new Stack(5); // Create a stack with a maximum size of 5

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        // Display the stack 
        System.out.println("Stack after push: ");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        // Push more elements onto the stack
        stack.push(4);
        stack.push(5);
        stack.push(6);

        // Peek at the top element of the stack
        System.out.println("Top element: " + stack.peek());

        // pop elements from the stack
        System.out.println("Pop element: " + stack.pop());
    }
}
```