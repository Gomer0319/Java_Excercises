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

 /* Working with File Classes
  * 
  * The File interacts with the file system. It represents a file or directory path and provides methods to perform various operations, such as creating, reading, and deleting files.
  *
  *Key methods in File class:
  * - exist(): Checks if the file or directory exists.
  * - delete(): Deletes the file or directory.
  * - renameTo(): Renames the file or directory.
  * - isDirectory(): Checks if the file represents a directory.
  * - isFile(): Checks if the file represents a file.
  * - listfiles(): Lists the files in the directory.
  * - canRead(): Checks if the file can be read.
  * - length(): Returns the length of the file or directory.
  * - createNewFile(): Creates a new file.
  * - getParent(): Returns the parent directory of the file or directory.
  * - getMessage(): Returns a string describing the exception.
  * 
  * - getAbsolutePath(): Returns the absolute path of the file or directory.
  * - mkdir(): Creates a directory. 
  */

  // Example demonstration of File class: (File, Reader, Writer)
  import java.io.File;
  import java.io.FileWriter;
  import java.io.IOException;
  import java.util.Scanner;

  public class FileDemo {
    public static void main(String[] args) {
        File file = new File("path/to/file.txt"); // Create a new file

        // Writing to a file
        try { 
            FileWriter writer = new FileWriter(file); // Create a file writer to write to the file
            writer.write("Hello, world!");
            writer.close();
        } catch (IOException e) { // Handle any I/O exceptions that may occur
            System.out.println("Error writing to file: " + e.getMessage()); // Print an error message with the exception message. What does e.getMessage() do? It returns the message associated with the exception.
                                                                            // The value of e.getMessage() is "path/to/file.txt". e stands for exception.
            e.printStackTrace(); // Print the stack trace of the exception
        }

        // Reading from a file
        try {
            Scanner scanner = new Scanner(file); // Create a scanner to read from the file
            while (scanner.hasNextLine()) { // Loop through each line in the file
                String line = scanner.nextLine(); // Read the next line
                System.out.println(line);
            }
            scanner.close();
        } catch (IOException e) { // Handle any I/O exceptions that may occur
            System.out.println("Error reading from file: " + e.getMessage()); // Print an error message with the exception message.
            e.printStackTrace(); // Print the stack trace of the exception
        }
    }
}
