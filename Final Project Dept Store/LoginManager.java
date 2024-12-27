import java.util.*;
import Miscellanious.*;

//Create LoginManager class
public class LoginManager {
    private static String loggedUser;

    // Constructor
    public LoginManager() {
        loggedUser = null;
    }

    public static String login() {
        // Create dummy admin and employee accounts
        Admin admin = new Admin("admin", "143");
        Employee employee = new Employee("employee", "214");

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
            if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
                loggedUser = "Admin";
                return loggedUser;
            } else if (username.equals(employee.getUsername()) && password.equals(employee.getPassword())) {
                loggedUser = "Employee";
                return loggedUser;
            } else {
                System.out.println("Invalid username or password.\n");
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
