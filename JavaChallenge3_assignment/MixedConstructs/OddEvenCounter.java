import java.util.*;

public class OddEvenCounter {
    public static void main(String[] args) {
        // Takes an array of integer inputs.
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 6 numbers(separated by spaces): ");
        int[] numbers = new int[6];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextInt();
        }

        int evenCount = 0;
        int oddCount = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        System.out.println("There are " + evenCount + " even numbers and " + oddCount + " odd numbers.");
    }
}
