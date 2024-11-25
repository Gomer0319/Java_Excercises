/* 
* What are Assertions?
* Assertions are a way to check that a condition is true at a particular point in your code. 
* If the condition is not true, an AssertionError is thrown. They are mainly used for debugging and testing.
*
* The basic syntax for an assertion is:
* assert condition : message;
* 
* Example: 
* assert 1 + 1 == 2 : "The values are not equal"; // The string "The values are not equal" will be printed if the condition is false
* assert true : "The condition is false";
* 
* Note: Assertions are not checked by the compiler. They are only checked at runtime.
*
* There are two types of assertions:
* - static assertions: Assertions that are checked at compile time
* example of static assertion: assert true : "The condition is false";
*
* - dynamic assertions: Assertions that are checked at runtime
* example of dynamic assertion: assert 1 + 1 == 2 : "The values are not equal";
*
* To enable/disable assertions, you can use the -ea and -da options in the Java command line.
* 
* Example:
* java -ea AssertionDemo.java
* java -da AssertionDemo.java
*
*/

// Sample demo applying static and dynamic assertions, with custom assertion.
public class AssertionDemo {
    public static void validateAge(int age) {
        assert age >= 0 : "Age cannot be negative";
    }

    public static void sortingValidation (int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            assert arr[i] <= arr[i + 1] : "Array is not sorted at index " + i;
        }
    }

    public static void main(String[] args) {
        validateAge(-20);

        int[] sortedArr = {1, 2, 3, 4, 5};
        int [] unsortedArr = {5, 2, 3, 4, 1};
        sortingValidation(sortedArr);
        sortingValidation(unsortedArr);
    }
}

/*
* Using assertion in internal logic
* Explain how assertions can be used to enforce internal invariants or validate complex logic within methods, but not as a replacement for regular error handling or input validation.
*
* Best practices and limitations
* - Use assertion to check for conditions that should never occur if the code is correct.
* - Assertions should be used for debugging and testing only.
* - Assertions should not be used for security purposes.
* - Assertions should not be used for performance optimization.
* - Avoid using assertion-validating user inputs to handle user errors.
* - They are not substitute for error handling, proper exception handling, or input validation.
*/
