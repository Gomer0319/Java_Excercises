import java.util.*;

// Create a main class DeptStoreInfoSys
public class DeptStoreInfoSys {
    public static void main(String[] args) {
        // Flag login status
        boolean loginStatus = false; // false = not logged in

        // Create a scanner object to read user input
        Scanner userInput = new Scanner(System.in);

        // Create a menu for login
        while (!loginStatus) {
            System.out.println("Welcome to the Department Store Info System");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int userOption = userInput.nextInt();

            // Check if the user wants to login using switch case
            switch (userOption) {
                case 1:
                    // Check if login is admin or employee
                    String userRole = LoginManager.login();
                    if ("Admin".equals(userRole)) {
                        System.out.println("You are logged in as an admin.\n");

                        // Set login status to true
                        loginStatus = true;

                        // Go to admin menu
                        AdminMenu adminMenu = new AdminMenu();
                        adminMenu.displayMenu();
                    }
                    else if ("Employee".equals(userRole)) {
                        System.out.println("You are logged in as an employee.\n");

                        // Set login status to true
                        loginStatus = true;

                        // Go to employee menu
                    }
                    break;
                case 2:
                    // Exit
                    System.out.println("Thanks for using the Department Store Info System.");
                    System.exit(0);
                    break;
                default:
                    // Invalid option
                    System.out.println("Invalid option. Please try again.");
            }
            userInput.close();
        }
    }
}

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
            loginInput.close();
            return "Admin";
        } else if (username.equals(employee.getUsername()) && password.equals(employee.getPassword())) {
            loginInput.close();
            return "Employee";
        } else {
            System.out.println("Invalid username or password.\n");
            loginInput.close();
            return null;
        }
    }
}

// Create user class
class User {
    private String username;
    private String password;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

// Create Admin class
class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }
}

// Create employee class
class Employee extends User {
    public Employee(String username, String password) {
        super(username, password);
    }
}

// Create Admin menu class
class AdminMenu {
    // Create menu for admin side
    public void displayMenu() {
        System.out.println("Admin Menu");
    }
}
