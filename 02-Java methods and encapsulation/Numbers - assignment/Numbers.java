import java.util.*;

public class Numbers {
    // create method that returns num1 with plus 10 and num2 with plus 10
    public static void plusTen(double num1, double num2) {
        System.out.println("Plus 10 :" + (num1 + 10) + " and " + (num2 + 10));
    }

    public static void timesTwo(double num1, double num2) {
        System.out.println("Times 2 :" + (num1 * 2) + " and " + (num2 * 2));
    }

    public static void showSquared(double num1, double num2) {
        System.out.println("Squared :" + (num1 * num1) + " and " + (num2 * num2));
    }

    public static void computePercent(double num1, double num2) {
        System.out.println("Computed Percent :" + (num1) + " is " + ((num1 / num2) * 100) + "%" + " of " + (num2));
    }

    public static void main(String[] args) {
        System.out.println("**Numbers Exercise**");
        // main method accept 2 double type values
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        double num1 = input.nextDouble();

        System.out.println("Enter the second number: ");
        double num2 = input.nextDouble();

        plusTen(num1, num2);
        timesTwo(num1, num2);
        showSquared(num1, num2);
        computePercent(num1, num2);

        input.close();
    }
}
