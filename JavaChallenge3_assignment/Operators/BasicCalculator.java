import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int input1 = input.nextInt();
        System.out.print("Enter the second number: ");
        int input2 = input.nextInt();
        System.out.println("Addition: " + (input1 + input2));
        System.out.println("Subtraction: " + (input1 - input2));
        System.out.println("Multiplication: " + (input1 * input2));
        System.out.println("Division: " + (input1 / input2));
        System.out.println("Modulus: " + (input1 % input2));
    }
}