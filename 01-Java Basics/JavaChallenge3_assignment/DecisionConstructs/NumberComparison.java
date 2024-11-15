import java.util.*;

public class NumberComparison {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your score (1-100): ");
        int num1 = input.nextInt();
        // random number for comparison
        Random random = new Random();
        int num2 = random.nextInt(100) + 1;

        System.out.println("Your score: " + num1);
        System.out.println("Opponent's score: " + num2);

        if (num1 > num2) {
            System.out.println("Your score is higher than the opponent!");
        } else if (num1 < num2) {
            System.out.println("Your score is lower than the opponent!");
        } else {
            System.out.println("Draw!");
        }
    }
}