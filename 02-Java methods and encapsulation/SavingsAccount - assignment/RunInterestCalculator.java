import java.util.*;

// Applying overloading
class InterestCalculator {
    double interest;
    double principal;
    int years;

    // Default constructor
    public InterestCalculator() {
        this.interest = 0.0;
        this.principal = 0.0;
        this.years = 0;
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

            if (principalINput.isEmpty()) {
                System.out.println("You have not entered any value, using default values.");
                calculator = new InterestCalculator(defCalculator.principal);
                calculator.computeInterest(defCalculator.principal);
            } 
            else {
                calculator = new InterestCalculator(Double.parseDouble(principalINput));
                calculator.computeInterest(Double.parseDouble(principalINput));
            }      
        }

        else if (option == 2) {
            String principalInput = input.nextLine().trim();
            String yearsInput = input.nextLine().trim();

            if (principalInput.isEmpty() || yearsInput.isEmpty()) {
                System.out.println("You have not entered any value, using default values.");
                calculator = new InterestCalculator(defCalculator.principal, defCalculator.years);
                calculator.computeInterest(defCalculator.principal, defCalculator.years);
            } else if (yearsInput.isEmpty()) { // if years input is empty but principal input is not
                calculator = new InterestCalculator(Double.parseDouble(principalInput), defCalculator.years);
                calculator.computeInterest(Double.parseDouble(principalInput), defCalculator.years);
            } else if (principalInput.isEmpty()) { // if principal input is empty but years input is not
                calculator = new InterestCalculator(defCalculator.principal, Integer.parseInt(yearsInput));
                calculator.computeInterest(defCalculator.principal, Integer.parseInt(yearsInput));
            } else {
                calculator = new InterestCalculator(Double.parseDouble(principalInput), Integer.parseInt(yearsInput));
                calculator.computeInterest(Double.parseDouble(principalInput), Integer.parseInt(yearsInput));
            }   
        }

        else if (option == 3) {
            String principalInput = input.nextLine().trim();
            String yearsInput = input.nextLine().trim();
            String interestInput = input.nextLine().trim();

            if (principalInput.isEmpty() || yearsInput.isEmpty() || interestInput.isEmpty()) {
                System.out.println("You have not entered any value, using default values.");
                calculator = new InterestCalculator(defCalculator.principal, defCalculator.years, defCalculator.interest);
                calculator.computeInterest(defCalculator.principal, defCalculator.years, defCalculator.interest);
            }
            else if (yearsInput.isEmpty()) { // if years input is empty but principal and interest input is not
                calculator = new InterestCalculator(Double.parseDouble(principalInput), defCalculator.years, Double.parseDouble(interestInput));
                calculator.computeInterest(Double.parseDouble(principalInput), defCalculator.years, Double.parseDouble(interestInput));
            }
            else if (principalInput.isEmpty()) { // if principal input is empty but years and interest input is not
                calculator = new InterestCalculator(defCalculator.principal, Integer.parseInt(yearsInput), Double.parseDouble(interestInput));
                calculator.computeInterest(defCalculator.principal, Integer.parseInt(yearsInput), Double.parseDouble(interestInput));
            }
            else if (interestInput.isEmpty()) { // if interest input is empty but principal and years input is not
                calculator = new InterestCalculator(Double.parseDouble(principalInput), Integer.parseInt(yearsInput), defCalculator.interest);
                calculator.computeInterest(Double.parseDouble(principalInput), Integer.parseInt(yearsInput), defCalculator.interest);
            }
            else {
                calculator = new InterestCalculator(Double.parseDouble(principalInput), Integer.parseInt(yearsInput), Double.parseDouble(interestInput));
                calculator.computeInterest(Double.parseDouble(principalInput), Integer.parseInt(yearsInput), Double.parseDouble(interestInput));
            }
        }
    }
}

