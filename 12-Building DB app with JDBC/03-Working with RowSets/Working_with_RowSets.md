## Introduction to RowSet:

### Importance of RowSets in JDBC:

1. **Connected RowSets:** When created, these RowSets are connected to the database and interact directly with it. They can be useful for cases where real-time data is needed.
2. **Disconnected RowSets:** Once created, these RowSets are disconnected from the database. They allow data to be manipulated offline and are typically used to cache data and perform operations on it without requiring a continuous database connection.
   
### Advantages of RowSets:

- Simplify the process of handling data.
- Provide a way to handle data in a disconnected mode, which can be more efficient and flexible.
  
## RowSetProvider and RowSetFactory:

### Creating Instances of RowSets:

1. **RowSetProvider:** A factory class used to create instances of RowSet implementations.
2. **RowSetFactory:** A factory class that provides methods to create different types of RowSet objects.

    *Example Code:*
    ```java
      import javax.sql.RowSetFactory;
      import javax.sql.rowset.CachedRowSet;
      import javax.sql.rowset.RowSet;
      import javax.sql.rowset.RowSetProvider;

      public class RowSetExample {
          public static void main(String[] args) {
              try {
                  // Create a RowSetFactory
                  RowSetFactory factory = RowSetProvider.newFactory();

                  // Create a CachedRowSet instance
                  CachedRowSet cachedRowSet = factory.createCachedRowSet();
                  
                  // Now you can use cachedRowSet to interact with the data
                  System.out.println("CachedRowSet instance created successfully!");
                  
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }
      }
      ```

### Types of RowSets:

1. **JdbcRowSet:**

    Description: A connected RowSet that can be used as a wrapper around a ResultSet. It provides a convenient way to handle and manipulate data.

    Example code:
    ```java
    import javax.sql.rowset.JdbcRowSet;
    import javax.sql.rowset.RowSetProvider;

    public class JdbcRowSetExample {
        public static void main(String[] args) {
            try {
                // Create a JdbcRowSet instance
                JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
                
                // set the URL of the database
                jdbcRowSet.setUrl("jdbc:mysql://localhost:3306/mydatabase");
                
                // set the username and password, and the SQL query to execute
                jdbcRowSet.setUser("username");
                jdbcRowSet.setPassword("password");
                jdbcRowSet.setCommand("SELECT * FROM users");
                // execute the query
                jdbcRowSet.execute();

                // set a while loop to iterate through the ResultSet
                while (jdbcRowSet.next()) { // use jdbcRowSet.next() to iterate through the ResultSet
                    // we can print the data in the ResultSet
                    System.out.println("ID: " + jdbcRowSet.getInt("id"));
                    System.out.println("Name: " + jdbcRowSet.getString("name"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }    
    ```

2. **CachedRowSet:**

    Description: A disconnected RowSet that holds a snapshot of the data from a database. It allows for offline data manipulation and is useful for caching data.

    Example Code:
    ```java
    import javax.sql.rowset.CachedRowSet;
    import javax.sql.rowset.RowSetProvider;

    public class CachedRowSetExample {
        public static void main(String[] args) {
            try {
                // Create a CachedRowSet instance
                CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
                
                // set the URL of the database
                cachedRowSet.setUrl("jdbc:mysql://localhost:3306/mydatabase");
                
                // set the username and password, and the SQL query to execute
                cachedRowSet.setUser("username");
                cachedRowSet.setPassword("password");
                cachedRowSet.setCommand("SELECT * FROM users");
                // execute the query
                cachedRowSet.execute();

                // set a while loop to iterate through the ResultSet
                while (cachedRowSet.next()) { // use cachedRowSet.next() to iterate through the ResultSet
                    // we can print the data in the ResultSet
                    System.out.println("ID: " + cachedRowSet.getInt("id"));
                    System.out.println("Name: " + cachedRowSet.getString("name"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    ```

3. **WebRowSet:**

    Description: A RowSet designed for use in web applications. It can serialize data to and from XML format, making it suitable for web-based data exchange.

    Example Code:
    ```java
    import javax.sql.rowset.WebRowSet;
    import javax.sql.rowset.RowSetProvider;
    import java.io.File;
    import java.io.FileWriter;
    import java.io.FileReader;

    public class WebRowSetExample {
        public static void main(String[] args) {
            try {
                // Create a WebRowSet instance
                WebRowSet webRowSet = RowSetProvider.newFactory().createWebRowSet();
                
                // set the URL of the database
                webRowSet.setUrl("jdbc:mysql://localhost:3306/mydatabase");

                // set the username and password, and the SQL query to execute
                webRowSet.setUser("username");
                webRowSet.setPassword("password");
                webRowSet.setCommand("SELECT * FROM users");
                // execute the query
                webRowSet.execute();

                // write webRowSet data to an XML file
                webRowSet.writeXml(new FileWriter("webrowset.xml"));

                //Read webRowSet data from an XML file
                WebRowSet webRowSet2 = RowSetProvider.newFactory().createWebRowSet();
                newWebRowSet.readXml(new FileReader("webrowset.xml"));

                // set a while loop to iterate through the ResultSet
                while (webRowSet2.next()) { // use webRowSet2.next() to iterate through the ResultSet
                    // we can print the data in the ResultSet
                    System.out.println("ID: " + webRowSet2.getInt("id"));
                    System.out.println("Name: " + webRowSet2.getString("name"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    ```


4. **JoinRowSet:**

    Description: A RowSet that combines data from multiple RowSets using SQL JOIN operations. It allows for complex data queries and manipulations.

    Example Code:
    ```java
    import javax.sql.rowset.JoinRowSet;
    import javax.sql.rowset.RowSetProvider;

    public class JoinRowSetExample {
        public static void main(String[] args) {
            try {
                // Create 2 JoinRowSet instances
                JoinRowSet joinRowSet1 = RowSetProvider.newFactory().createJoinRowSet();
                JoinRowSet joinRowSet2 = RowSetProvider.newFactory().createJoinRowSet();

                // set the URL of the database1
                rowSet1.setUrl("jdbc:mysql://localhost:3306/mydatabase");
                // set the username and password, and the SQL query to execute
                rowSet1.setUser("username");
                rowSet1.setPassword("password");
                rowSet1.setCommand("SELECT id, name FROM users");
                // execute the query
                rowSet1.execute();

                // set the URL of the database2
                rowSet2.setUrl("jdbc:mysql://localhost:3306/mydatabase");
                // set the username and password, and the SQL query to execute
                rowSet2.setUser("username");
                rowSet2.setPassword("password");
                rowSet2.setCommand("SELECT id, email FROM user_emails");
                // execute the query
                rowSet2.execute();

                // join the 2 RowSets
                JoinRowSet joinRowSet = RowSetProvider.newFactory().createJoinRowSet();
                joinRowSet.addRowSet(rowSet1);
                joinRowSet.addRowSet(rowSet2);

                // perform operations on the joined RowSet
                while (joinRowSet.next()) { // use joinRowSet.next() to iterate through the ResultSet
                    // we can print the data in the ResultSet
                    System.out.println("ID: " + joinRowSet.getInt("id"));
                    System.out.println("Name: " + joinRowSet.getString("name"));
                    System.out.println("Email: " + joinRowSet.getString("email"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    ```

5. **FilteredRowSet:**

    Description: A RowSet that allows data filtering and sorting data based on specific criteria.

    Example Code:
    ```java
    import javax.sql.rowset.FilteredRowSet;
    import javax.sql.rowset.RowSetProvider;
    import javax.sql.rowset.RowSetMetaData;
    import javax.sql.rowset.Predicate;

    public class FilteredRowSetExample {
        public static void main(String[] args) {
            try {
                // Create a cachedRowSet instance
                CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
                
                // set the URL of the database
                cachedRowSet.setUrl("jdbc:mysql://localhost:3306/mydatabase");
                
                // set the username and password, and the SQL query to execute
                cachedRowSet.setUser("username");
                cachedRowSet.setPassword("password");
                cachedRowSet.setCommand("SELECT * FROM users");
                // execute the query
                cachedRowSet.execute();

                // create a FilteredRowSet instance
                FilteredRowSet filteredRowSet = RowSetProvider.newFactory().createFilteredRowSet();
                filteredRowSet.populate(cachedRowSet); // used populate method to copy data from cachedRowSet to filteredRowSet

                // define filter criteria
                filteredRowSet.setFilter(new Predicate() { // use setFilter method to define the filter criteria, new Predicate() is a lambda expression that implements the Predicate interface
                    public boolean evaluate(RowSet rowSet) { // use evaluate method to evaluate the filter criteria
                        try { // try-catch block to handle exceptions in the code
                            // return
                            return rowSet.getString("name").startsWith("John");
                        } catch (Exception e) {
                            e.printStackTrace();
                            return false;
                        }
                    }

                    public boolean evaluate(Object value, String columnName) { // use evaluate method to evaluate the filter criteria
                        return false;
                    }
                });

                // perform operations on the filtered RowSet
                while (filteredRowSet.next()) { // use filteredRowSet.next() to iterate through the ResultSet
                    // we can print the data in the ResultSet
                    System.out.println("ID: " + filteredRowSet.getInt("id"));
                    System.out.println("Name: " + filteredRowSet.getString("name"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    ```




