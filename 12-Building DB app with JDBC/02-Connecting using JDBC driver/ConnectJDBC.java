/*
* What is a JDBC driver?
* A JDBC driver is a class that provides an interface to the database. 
* JDBC drivers are used to connect to a database.
* It implements the JDBC API interface and provides the functionality to access the database.
*
* Types of JDBC drivers:
* 1. Native drivers (Partially JAVA drivers)
*   - These drivers are written in native code and are specific to the database. Converts the JDBC API into native code.
*   - Requires database specific libraries to be installed.
*   - Example: Oracle, SQL Server
*
* 2. JDBC-ODBC bridge drivers
*   - These drivers are written in JAVA and are specific to the database. Converts the JDBC API into ODBC (Open Database Connectivity).
*   - Due to performance and compatibility issues, these drivers are not recommended for production.
*   - Example: Microsoft Access
*
* 3. Network Protocol drivers (Middleware drivers)
*   - These drivers are written in JAVA and are specific to the database. Converts the JDBC API into a network protocol.
*   - Uses a middleware to connect to the database. Requires database specific libraries to be installed.
*   - Example: MySQL, PostgreSQL
*
* 4. Thin drivers (Pure JAVA drivers)
*   - These drivers are written in JAVA and are specific to the database. Converts the JDBC API into pure JAVA.
*   - Requires database specific libraries to be installed. It is platform independent and provides the best performance.
*   - Example: Oracle
*
* Loading and registering JDBC drivers:
* 1. Use the Class.forName() method to load the driver class.
*   - Class.forName() is a static method of the Class class. This method dynamically loads the driver class, which then registers itself with the DriverManager class.
*   - Example: Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
*
* 2. Use the DriverManager.registerDriver() method to register the driver.
*   - DriverManager.registerDriver() is a static method of the DriverManager class. This method dynamically registers the driver with the DriverManager class.
*   - This connection establishes a connection to the specified database using URL using the provided username and password.
*   - Example: DriverManager.registerDriver("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
*/

// Sample demo code applying JDBC driver to connect to a database
import java.sql.*;

public class ConnectJDBC {
    public static void main(String[] args) {
        try { // use try-catch block to handle exceptions that may occur while connecting to the database
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // Load the driver class
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=mydatabase", "username", "password"); // Establish a connection to the database using the URL, username, and password
            Statement statement = connection.createStatement(); // Create a statement to execute queries on the database 
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable"); // Execute a query to retrieve data from the database 
            while (resultSet.next()) { // Loop through the result set and print the data 
                System.out.println(resultSet.getString("column1") + " " + resultSet.getString("column2")); // Print the values of the columns
            }
            resultSet.close(); // Close the result set
            statement.close(); // Close the statement
            connection.close(); // Close the connection
        } catch (ClassNotFoundException e) { // Handle the case where the driver class is not found
            e.printStackTrace();
        } catch (SQLException e) { // Handle the case where the connection to the database fails
            e.printStackTrace();
        }
    }
}