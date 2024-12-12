//Create a class called Login (contains username and password)
public class LoginManager {
    //Create a method to login
    public boolean login() {
        // Set attempts to 3
        int maxAttempts = 3;
        int attempts = 0;

        while (attempts < maxAttempts) {
            System.out.println("\n--------Login--------");

            //Get username and password from user
            String inputUsername = Utility.getString("Enter your username: ");
            String inputPassword = Utility.getString("Enter your password: ");

            //Handle empty username and password
            if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
                System.out.println("\nUsername or password cannot be empty. Please try again.\n");
                continue;
            }

            // Clear the console
            Utility.clearScreen();
    
            //Check if the username and password are correct. If the match is for an admin, Go to the Admin page. If the match is for an employee, Go to the Employee page. Else, print an error message.
            for (Users user : UsersManager.getUsersList()) {
                if (user.authenticate(inputUsername, inputPassword)) {
                    // Store the logged username for the session manager before redirecting to the menu
                    Utility.setUsername(user.getUsername(), user.getRole());

                    // If username and password match admin, go to admin page, and store the logged username for the session manager
                    if (user.getUsername().equalsIgnoreCase("admin")) {
                        System.out.println("\nLogged in as admin. Redirecting to Admin Menu Page...\n");

                        //Redirect to admin page
                        AdminMenuManager adminMenuManager = new AdminMenuManager();
                        adminMenuManager.adminMenu();
                        
                        //Store the logged username for the session manager
                        Utility.setUsername(user.getUsername(), user.getRole());
                        return true;
                    }
                    // If username and password match employee, go to employee page, and store the logged username for the session manager
                    else if (user.getUsername().equalsIgnoreCase("employee")) {
                        System.out.println("\nLogged in as employee. Redirecting to Employee Menu Page...\n");

                        //Redirect to employee page
                        EmployeeMenuManager employeeMenuManager = new EmployeeMenuManager();
                        employeeMenuManager.employeeMenu();
                        
                        //Store the logged username for the session manager
                        Utility.setUsername(user.getUsername(), user.getRole());
                        return true;
                    }
                }
            }
            // If the username and password do not match, after 3 attempts, print an error message
            attempts++;

            // Show a message of the attempts left
            System.out.println("\nYou have " + (maxAttempts - attempts) + " attempts left.\n");

            if (attempts < maxAttempts) {
                System.out.println("\nIncorrect username or password. Please try again.\n");
            } else {
                System.out.println("\nYou have exceeded the maximum number of attempts. Returning to menu.\n");
            }
        }
        // return false if the user has exceeded the maximum number of attempts
        return false;
    }
}
