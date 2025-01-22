package Main;
import java.util.*;
import java.io.*;

//Create LoginManager class
public class LoginManager {
    private static String loggedUser;

    // Constructor
    public LoginManager() {
        loggedUser = null;
    }

    public static String login() {
        //Store the user name and password
        Map<String, String> userCredentials = new HashMap<>();
        // Get the admin and employee objects through Users.txt file using buffered reader
        String fileName = "Users.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String [] parts = line.split(",");
                if (parts.length == 2) {
                    String username = parts[0].trim();
                    String password = parts[1].trim();
                    userCredentials.put(username, password);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        // Create a scanner object to read user input
        Scanner loginInput = new Scanner(System.in);

        // Try catch block to handle InputMismatchException
        try {
            // Create input for username and password
            System.out.print("\nEnter username: ");
            String username = loginInput.nextLine();
            System.out.print("Enter password: ");
            String password = loginInput.nextLine();

            // Check if the input username and password is valid and if it is for admin or
            // employee
             if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
                loggedUser = username.equals("admin") ? "Admin" : "Employee";
                return loggedUser;
            } 
            else {
                System.out.println("Invalid username or password. Please try again.\n");
                return null;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.\n");
            return null;
        }
    }

    // getter
    public static String getloggedUser() {
        return loggedUser;
    }
}
