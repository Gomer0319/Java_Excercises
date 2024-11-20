import java.util.*;

// Applying overloading
class InterestCalculator {
    double interest;
    double principal;
    int years;

    // Default constructor
    public InterestCalculator() {
        this.interest = 5.0;
        this.principal = 0.0;
        this.years = 1;
    }

    // Overloaded constructors
    public InterestCalculator(double principal) {
        this.interest = 0.0;
        this.principal = principal;
        this.years = 0;
    }

    public InterestCalculator(double principal, double interest) {
        this.interest = interest;
        this.principal = principal;
        this.years = 0;
    }

    public InterestCalculator(double principal, int years, double interest) {
        this.interest = interest;
        this.principal = principal;
        this.years = years;
    }

    // Create 3 overloaded methods name computeInterest
    // with single parameter, represents the principal amount
    public void computeInterest (double principal) {
        System.out.println("Total amount after interest: " + principal * 1.05);
    }

    public void computeInterest (double principal, int years) {
        // Calculate the compound interest annually at a rate of 5% and return the total amount after the specified number of years
        double rate = 1.05;
        double amount = principal;

        for (int i = 0; i < years; i++) {
            amount *= rate;
        }
        System.out.println("Total amount after interest: " + amount);
    }

    public void computeInterest (double principal, int years, double interest) {
        // Calculate the compound interest annually using the given interest rate and return the total amount after the given number of years.
        double rate = 1 + (interest / 100);
        double amount = principal;

        for (int i = 0; i < years; i++) {
            amount *= rate;
        }
        System.out.println("Total amount after interest: " + amount);
    }
}

public class RunInterestCalculator {
    public static void main(String[] args) {
        // Import scanner class
        Scanner input = new Scanner(System.in);

        // Create an instruction for the user to choose an option
        System.out.println("Press any of the following, then enter the values separated by spaces: ");
        System.out.println("1. Principal only");
        System.out.println("2. Principal and years");
        System.out.println("3. Principal, years, and interest rate");
        
        int option = input.nextInt();
        input.nextLine();

        // Call default constructor
        InterestCalculator defCalculator = new InterestCalculator();

        InterestCalculator calculator;
        
        if (option == 1) {
            String principalINput =  input.nextLine().trim();
            double principal = principalINput.isEmpty() ? defCalculator.principal : Double.parseDouble(principalINput);
            
            calculator = new InterestCalculator(principal);
            calculator.computeInterest(principal);
                  
        } 
        else if (option == 2) {
            String[] values = input.nextLine().trim().split(" "); // Split the input into an array
            double principal = values.length > 0 && !values[0].isEmpty() ? Double.parseDouble(values[0]) : defCalculator.principal; // Check if the input is empty for principal
            int years = values.length > 1 && !values[1].isEmpty() ? Integer.parseInt(values[1]) : defCalculator.years; // Check if the input is empty for years

            calculator = new InterestCalculator(principal, years);
            calculator.computeInterest(principal, years);
        }  
        else if (option == 3) {
            String[] values = input.nextLine().trim().split(" "); // Split the input into an array
            double principal = values.length > 0 && !values[0].isEmpty() ? Double.parseDouble(values[0]) : defCalculator.principal; // Check if the input is empty for principal
            int years = values.length > 1 && !values[1].isEmpty() ? Integer.parseInt(values[1]) : defCalculator.years; // Check if the input is empty for years
            double interest = values.length > 2 && !values[2].isEmpty() ? Double.parseDouble(values[2]) : defCalculator.interest; // Check if the input is empty for interest

            calculator = new InterestCalculator(principal, years, interest);
            calculator.computeInterest(principal, years, interest);
        } 
        else {
            System.out.println("Invalid option. Using default values.");
        }

        input.close();
    }
}

/*Self-check 1.1-2
1.b
2.c
3.d
4.a
5.a
6.b
*/