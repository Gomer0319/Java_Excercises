## What is JDBC?
**Java Database Connectivity (JDBC)** is a standard that allows Java programs to connect to relational databases. It provides methods to query and update database tables.

## Why is JDBC important?
**JDBC** is important because it allows Java programs to connect to databases, which can be used to store,retrieve and manage data.

---

## The architecture of JDBC API
The **JDBC** API has a client-server architecture, where the client program sends requests to the database server, and the server executes the requests and returns the results.

- Driver Manager: The **DriverManager** class is used to load and manage the JDBC driver for the database. It connects an application to a specific database.
  Example:
  ```java 
  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");
  ```

- Connection: The **Connection** interface represents a connection to a database. It provides methods for executing queries and updating data.
    Example:
    ```java
    Statement statement = connection.createStatement();
    ```
- ResultSet: The **ResultSet** interface represents the result of a query or update operation. It contains the results of the query or update.
  Example:
  ```java
  ResultSet resultSet = statement.executeQuery("SELECT id, name FROM users");
  while (resultSet.next()) {
      int id = resultSet.getInt("id");
      String name = resultSet.getString("name");
      System.out.println("ID: " + id + ", Name: " + name);
  }
  ```

- Metadata: The **MetaData** interface provides information about the database schema, such as table names, column names, and data types.
  Example:
  ```java
  DatabaseMetaData metaData = connection.getMetaData();
  System.out.println("Database name: " + metaData.getDatabaseProductName());
  System.out.println("Database version: " + metaData.getDatabaseProductVersion());
  ```
  
---

Full example:
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCExample {
    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT id, name FROM users");

            // Process the results
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // Close the resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
