import java.time.LocalDate;
import java.time.Period;
import java.util.*;

// Create a customer class where we can add a customer name, birthday, contact number, be able to update it, search for a customer, and delete a customer
public class Customer {
    private String customerID, customerName, birthday, contactNumber, registrationDate;
    private int customerPoints;

    public Customer(String customerID, String customerName, String birthday, String contactNumber,
            String registrationDate, int customerPoints) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.birthday = birthday;
        this.contactNumber = contactNumber;
        this.registrationDate = registrationDate;
        this.customerPoints = customerPoints;
    }

    public Customer(String customerID, String customerName, String birthday, String contactNumber,
            String registrationDate) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.birthday = birthday;
        this.contactNumber = contactNumber;
        this.registrationDate = registrationDate;
    }

    public Customer() {
        this.customerID = " ";
        this.customerName = " ";
        this.birthday = " ";
        this.contactNumber = " ";
        this.registrationDate = " ";
        this.customerPoints = 0;
    }

    // Create a List to store all the customers
    public static List<Customer> customerList = new ArrayList<>();

    // Create dummy customers
    static {
        customerList
                .add(new Customer("CUS" + IdGenerator.generateID("Customer"), "Placido Barara", "1945-02-28",
                        "0944-444-4444", Utility.getCurrentDateTime()));
        customerList.add(
                new Customer("CUS" + IdGenerator.generateID("Customer"), "Maximina Pautista", "1956-06-01",
                        "0944-555-3344", Utility.getCurrentDateTime()));
        customerList.add(
                new Customer("CUS" + IdGenerator.generateID("Customer"), "Lourdes Phutipatra", "1980-07-02",
                        "0944-666-5544", Utility.getCurrentDateTime()));
    }

    // Create a method to add a customer
    public static void addCustomer(String customerID, String customerName, String birthday, String contactNumber) {
        // Check if ID already exists
        for (Customer customer : customerList) {
            if (customer.getCustomerID().equals(customerID)) {
                System.out.println("Customer ID " + customerID + " already exists.");
                return;
            }
        }
        customerList.add(new Customer(customerID, customerName, birthday, contactNumber, Utility.getCurrentDateTime()));
        System.out.println("Customer " + customerName + " added successfully.");
    }

    // Create a method to update a customer
    public static void updateCustomer() {
        // Get customer ID from user
        System.out.println("Enter customer ID to update");
        String customerID = Utility.getString("Enter customer ID: ");

        // Find customer by ID. If the customer is not found, the system should throw an
        // exception.
        boolean customerFound = false;
        for (Customer customer : customerList) {
            if (customer.getCustomerID().equals(customerID)) {
                customerFound = true;
                // Display customer information of the customer to be updated
                System.out.println("\nCustomer Matched:");
                System.out.println(
                        customer.getCustomerID() + "    " +
                                customer.getCustomerName() + "     " +
                                customer.getBirthday() + "     " +
                                customer.getContactNumber() + "     " +
                                customer.getRegistrationDate() + "     " +
                                customer.getCustomerPoints());

                // Make a menu for the user to choose what they want to update
                System.out.println("\n--------Update Customer--------");
                System.out.println("1. Customer Name");
                System.out.println("2. Birthday");
                System.out.println("3. Contact Number");
                System.out.println("4. Back to Main Menu");
                System.out.println("--------------------------");

                // Get user input
                int choice = Utility.getInt(">>> ");
                Utility.userInput.nextLine(); // Consume the newline character

                // Clear the console
                Utility.clearScreen();

                // Create a switch statement to handle user input
                switch (choice) {
                    case 1:
                        String customerName = Utility.getString("Enter updated customer name: ");
                        customer.setCustomerName(customerName);
                        System.out.println("Customer name updated successfully.");
                        break;
                    case 2:
                        String birthday = Utility.getString("Enter updated customer birthday: ");
                        customer.setBirthday(birthday);
                        System.out.println("Customer birthday updated successfully.");
                        break;
                    case 3:
                        String contactNumber = Utility.getString("Enter customer updated contact number: ");
                        customer.setContactNumber(contactNumber);
                        System.out.println("Customer contact number updated successfully.");
                        break;
                    case 4:
                        System.out.println("Returning to main menu.");
                        break;
                    default:
                        System.out.println("Invalid choice. Returning to main menu.");
                }
            }
        }
        if (!customerFound) {
            System.out.println("Customer ID " + customerID + " not found.");
            return;
        }
    }

    // Create a method to delete a customer
    public static void deleteCustomer() {
        // Get customer ID from user
        System.out.println("Enter customer ID to delete");
        String customerID = Utility.getString("Enter customer ID: ");

        // Find customer by ID. If the customer is not found, the system should throw an
        // exception.
        boolean customerFound = false;
        for (Customer customer : customerList) {
            if (customer.getCustomerID().equals(customerID)) {
                customerFound = true;
                customerList.remove(customer);
                System.out.println("Customer " + customer.getCustomerName() + " deleted successfully.");
                break;
            }
        }
        if (!customerFound) {
            System.out.println("Customer ID " + customerID + " not found.");
            return;
        }
    }

    // Create a method to search for a customer
    public static void searchCustomer() {
        // Get customer ID from user
        System.out.println("Enter customer ID to search: ");
        String customerID = Utility.getString("Enter customer ID: ");

        // Find customer by ID. If the customer is not found, the system should throw an
        // exception.
        boolean customerFound = false;
        for (Customer customer : customerList) {
            if (customer.getCustomerID().equals(customerID)) {
                customerFound = true;
                System.out.println(
                        customer.getCustomerID() + "     " +
                                customer.getCustomerName() + "     " +
                                customer.getBirthday() + "     " +
                                customer.getContactNumber() + "     " +
                                customer.getRegistrationDate() + "     " +
                                customer.getCustomerPoints());
                break;
            }
        }
        if (!customerFound) {
            System.out.println("Customer ID " + customerID + " not found.");
            return;
        }
    }

    // Create a method to calculate age
    public int calculateAge() {
        LocalDate birthdate = LocalDate.parse(this.birthday);
        LocalDate currentdate = LocalDate.now();
        return Period.between(birthdate, currentdate).getYears();
    }

    // Create a method to check if a customer is a senior citizen
    public boolean isSeniorCitizen() {
        return calculateAge() >= 60;
    }

    // Create a method to view all customers
    public static void viewCustomerList() {
        System.out.println("--------View All Customers--------");
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("|| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s ||\n", "Customer ID",
                "Customer Name",
                "Birthday",
                "Contact Number", "Reg Date", "Points", "isSenior");
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Customer customer : customerList) {
            System.out.printf("|| %-20s | %-20s | %-20s | %-20s | %-20s | %-20d | %-20s ||\n",
                    customer.getCustomerID(),
                    customer.getCustomerName(),
                    customer.getBirthday(),
                    customer.getContactNumber(),
                    customer.getRegistrationDate(),
                    customer.getCustomerPoints(),
                    (customer.isSeniorCitizen() ? "Yes" : "No"));
        }
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public int getCustomerPoints() {
        return customerPoints;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setCustomerPoints(int customerPoints) {
        this.customerPoints = customerPoints;
    }
}
