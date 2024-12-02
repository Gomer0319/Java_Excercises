import java.util.*;

//Create LoginManager class
class LoginManager {
    public static String login() {
        // Create dummy admin and employee accounts
        Admin admin = new Admin("admin", "143");
        Employee employee = new Employee("employee", "214");

        // Create a scanner object to read user input
        Scanner loginInput = new Scanner(System.in);

        // Create input for username and password
        System.out.print("\nEnter username: ");
        String username = loginInput.nextLine();
        System.out.print("Enter password: ");
        String password = loginInput.nextLine();

        // Check if the input username and password is valid and if it is for admin or employee
        if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
            return "Admin";
        } else if (username.equals(employee.getUsername()) && password.equals(employee.getPassword())) {
            return "Employee";
        } else {
            System.out.println("Invalid username or password.\n");
            return null;
        }
    }
}


