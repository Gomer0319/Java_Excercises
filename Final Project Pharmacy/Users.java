
// Create a class called Users (contains username and password and role)
public class Users {
    private String username;
    private String password;
    private String role;

    // Create a constructor to initialize the fields
    public Users(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Create a method to authenticate the user
    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // Create getter methods for the fields
    public String getUsername() {
        return username;
    }

    public String getPassword() {    
        return password;
    }

    public String getRole() {
        return role;
    }
}






