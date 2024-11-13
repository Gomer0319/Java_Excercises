import java.util.Scanner;

public class AgeChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = input.nextInt();
        System.out.println("Your age: " + age);
        int incremented = ++age;
        System.out.println("Age after increment: " + incremented);

        // condition/validation
        boolean isEligible = (incremented >= 18);

        if (isEligible) {
            System.out.println("Eligible for subscription: " + isEligible);
        } else {
            System.out.println("Eligible for subscription: " + isEligible);
        }
    }
}
