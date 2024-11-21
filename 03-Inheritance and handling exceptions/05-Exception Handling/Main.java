// Example of exception handling (try, catch, finally)

class Main {
    public static void main(String[] args) {
        try { // try block contains the code that might throw an exception
            int a = 10;
            int b = 0;
            int c = a / b;
            System.out.println(c);
        } catch (ArithmeticException e) { // catch block contains the code to handle the exception
            System.out.println(e);
        } finally { // finally block contains the code that will be executed regardless of whether an exception is thrown or not
            System.out.println("finally block");
        }
    }
}

/* List of common Java exceptions and explanations (and how to handle them, with samples):
 * 
 * ArithmeticException: Thrown when an arithmetic operation results in an overflow or underflow (or an error).
 * ex: int a = 10 / 0;
 * 
 * NullPointerException: Thrown when an object reference is null.
 * ex: String s = null;
 *     System.out.println(s.length());
 * 
 * ArrayIndexOutOfBoundsException: Thrown when an array index is out of bounds (invalid index).
 * ex: int[] arr = {1, 2, 3};
 *     System.out.println(arr[3]);
 * 
 * ClassNotFoundException: Thrown when trying to cast an object to a class that does not exist.
 * ex: Object obj = "text";
 *     Integer i = (Integer) obj; 
 * 
 * FileNotFoundException: Thrown when a file is not found.
 * ex: FileInputStream fis = new FileInputStream("file.txt");
 * 
 * IOException: Thrown when an input or output operation fails.
 * ex: BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 * 
 * NumberFormatException: Thrown when a string cannot be converted to a number.
 * ex: String s = "abc";
 *     int i = Integer.parseInt(s);
 * 
 */

 /* Situations Requiring Exception Handling:
  * 
  * 1. Invalid input from the user. For example, if the user enters a string instead of an integer.
  * 2. File not found. For example, if the user enters a file name that does not exist.
  * 3. Network connection error. For example, if the user tries to connect to a server that is not available.
  * 4. Database connection error. For example, if the user tries to connect to a database that is not available.
  * 5. Security error. For example, if the user tries to access a file that is not allowed.
  * 6. Other errors. For example, if the user tries to access a file that is not allowed.
  * 
  */