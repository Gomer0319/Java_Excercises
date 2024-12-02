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

// Create Admin class that inherits from User
class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }
}

// Create employee class that inherits from User
class Employee extends User {
    public Employee(String username, String password) {
        super(username, password);
    }
}
