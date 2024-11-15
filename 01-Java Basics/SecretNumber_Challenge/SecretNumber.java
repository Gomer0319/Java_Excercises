import java.util.*;

public class SecretNumber {

    public static void main(String[] args) {
        // Initialize the game
        Random randomGenerator = new Random();
        int secretNumber = randomGenerator.nextInt(100) + 1; // Generate a random number between 1 and 100, and store it
                                                             // in the secretNumber variable
        int attemptsRemaining = 10; // Set the initial number of attempts
        Scanner scanner = new Scanner(System.in); // Create a Scanner object

        // Welcome message and instructions
        System.out.println("Welcome to the Secret Number game!");
        System.out.println("You have 10 attempts to guess the secret number between 1 and 100.");

        // Main game loop
        while (attemptsRemaining > 0) { // Check if there are attempts remaining using while loop
            System.out.print("Enter your guess: ");
            int playerGuess = scanner.nextInt(); // store the player's guess
            --attemptsRemaining; // decrement the attempts remaining

            // Check if the player's guess is correct
            if (playerGuess == secretNumber) {
                System.out.println("Congratulations! You guessed the secret number! The number was " + secretNumber
                        + " using " + (10 - attemptsRemaining) + " attempts.");
                break;
            } else if (playerGuess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }

            // Update the number of attempts remaining
            System.out.println("Attempts remaining: " + attemptsRemaining);
        }

        // Check if the player ran out of attempts
        if (attemptsRemaining == 0) {
            System.out.println("Sorry, you ran out of attempts. The secret number was " + secretNumber + ".");
        }

        // Replay option
        System.out.println("Do you want to play again? (yes/no)");
        String replayChoice = scanner.next();
        if ("yes".equalsIgnoreCase(replayChoice)) {
            main(args);
        } else {
            System.out.println("Goodbye, See you next time!");
            scanner.close();
        }
    }
}
