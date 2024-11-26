## Introduction to PreparedStatement:

**Definition:** A **PreparedStatement** is a precompiled SQL statement in JDBC that allows you to execute SQL queries efficiently with or without parameters.

---

## Why Use PreparedStatement Over Regular Statement:

1. **Prevention of SQL Injection:** PreparedStatement automatically handles escaping of special characters, which helps in preventing SQL injection attacks.
2. **Improved Performance:** SQL queries are precompiled and stored in a database, reducing the query parsing and compilation overhead when executing the same statement multiple times.
3. **Code Readability:** Using PreparedStatement makes the code cleaner and more readable by separating SQL code from data.

## Advantages of PreparedStatement:

1. Prevention of SQL Injection: PreparedStatement prevents SQL injection by using parameterized queries, Which ensures that user inputs are treated as data and not executable code.
2. Improved Performance: The SQL query is compiled once and can be executed multiple times with different parameters, improving efficiency.
3. Ease of Use: Provides a straightforward API for setting parameters and executing queries.

## Creating and Executing PreparedStatement:

1. **Creating a PreparedStatement:** Use the Connection.prepareStatement() method to create a PreparedStatement object.
2. **Setting Parameters:** Use setter methods to provvalue for SQL query placeholdersuery.
3. **Executing the Statement:** Execute the statement using executeQuery() for SELECT queries or executeUpdate() for INSERT, UPDATE, and DELETE queries.

---

**Example Code:**

a. Creating a PreparedStatement:

    ```java
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.SQLException;

    public class PreparedStatementExample {
        public static void main(String[] args) {
            // Database connection details
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String username = "myusername";
            String password = "mypassword";

            // Connection and PreparedStatement objects
            Connection connection = null;
            PreparedStatement statement = null;

            // Establish a connection to the database
            try {
                connection = DriverManager.getConnection(url, username, password);
                
                // Create a PreparedStatement object
                String query = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)"; // ? represents a parameter placeholder
                statement = connection.prepareStatement(query);

                // Set parameter values
                preparedStatement.setInt(1, 1);          // Set ID
                preparedStatement.setString(2, "Alice"); // Set Name
                preparedStatement.setString(3, "alice@example.com"); // Set Email

                // Execute the statement
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println("Rows inserted: " + rowsAffected);

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Close resources
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

b. Using Various Setter Methods:

    ```java
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;

    public class PreparedStatementExample {
        public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/myDatabase";
            String username = "root";
            String password = "password";

            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try {
                // Establish a connection
                connection = DriverManager.getConnection(url, username, password);

                // Create a PreparedStatement
                String sql = "SELECT * FROM users WHERE id = ? AND name = ?";
                preparedStatement = connection.prepareStatement(sql);

                // Set parameters
                preparedStatement.setInt(1, 1);          // Set ID
                preparedStatement.setString(2, "Alice"); // Set Name

                // Execute the query
                resultSet = preparedStatement.executeQuery();

                // Process the result
                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("Name: " + resultSet.getString("name"));
                    System.out.println("Email: " + resultSet.getString("email"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Close resources
                try {
                    if (resultSet != null) resultSet.close();
                    if (preparedStatement != null) preparedStatement.close();
                    if (connection != null) connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    ```

c. Example of Different Setter Methods:

1. **setInt(int parameterIndex, int x):** Sets the value of the parameter at the specified index to the given int value.
2. **setString(int parameterIndex, String x):** Sets the value of the parameter at the specified index to the given String value.
3. **setDouble(int parameterIndex, double x):** Sets the value of the parameter at the specified index to the given double value.
4. **setDate(int parameterIndex, java.sql.Date x):** Sets the value of the parameter at the specified index to the given Date value.

    Example Code:

    ```java
    preparedStatement.setInt(1, 1001);          // Set ID
    preparedStatement.setString(2, "Alice"); // Set Name
    preparedStatement.setString(3, "alice@example.com"); // Set Email
    preparedStatement.setDate(4, new java.sql.Date(System.currentTimeMillis())); // Set Date
    ```









