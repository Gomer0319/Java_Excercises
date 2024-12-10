import java.util.*;

// Create a class called UsersManager (contains a list of Users)
public class UsersManager {
    private static List<Users> usersList;

    // Create a dummy account for admin and employee, then add it to the list
    static {
        usersList = new ArrayList<>();
        usersList.add(new Users("Admin", "14344", "Pharmacist"));
        usersList.add(new Users("Employee", "21420", "Pharmacy Assistant"));
    }

    // Create a getter method for the list
    public static List<Users> getUsersList() {
        return usersList;
    }
}
