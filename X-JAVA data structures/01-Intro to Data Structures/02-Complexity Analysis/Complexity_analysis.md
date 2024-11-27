## What is Complexity Analysis?

Complexity Analysis is a process of analyzing the time and space complexity of a program. Big O notation is used to represent the complexity of a program.

### What is Big O notation?

Provides a high level overview of the complexity of a program by describing the worst case scenario of its growth rate relative to input size.

#### Purpose

1. To abstract away constants and lower order terms.
2. To compare different algorithms and determine which one is more efficient.
3. To determine the time complexity of an algorithm.

### Common Big O notations

1. O(1) - Constant time: The program runs in constant time regardless of the input size.
2. O(log n) - Logarithmic time: The program runs in logarithmic time, which is faster than O(n).
3. O(n) - Linear time: The program runs in linear time, which is slower than O(log n).
4. O(n log n) - Linearithmic time: The program runs in linearithmic time, which is slower than O(n).
5. O(n^2) - Quadratic time: The program runs in quadratic time, which is slower than O(n).
6. O(2^n) - Exponential time: The program runs in exponential time, which is slower than O(n^2).
7. O(n!) - Factorial time: The program runs in factorial time, which is slower than O(2^n).

---

### Time Complexity

Time complexity is the amount of time it takes to run a program. It is measured in terms of the number of operations performed per unit of input.

Factors that affect time complexity:

1. Input size: The size of the input.
2. Number of operations: The number of operations performed.

Examples:

- Sorting an array of size n takes O(n^2) time.
- Searching for an element in a sorted array of size n takes O(log n) time.
- Searching for an element in an unsorted array of size n takes O(n) time.

---

### Space Complexity

Space complexity is the amount of memory used by a program. It is measured in terms of the number of memory locations used per unit of input.

Factors that affect space complexity:

1. Variable size: The size of each variable.
2. Data structure size: The size of the data structure.
3. Function calls: The number of function calls.

Examples:

- Creating a linked list of size n takes O(n) space.
- Opening a file takes O(1) space.

---

### Big O analysis of common Algorithms

- Linear Search: O(n), O(1)
- Binary Search: O(log n), O(1)
- Merge Sort: O(n log n), O(n)
- Quick Sort: O(n log n), O(n log n)



