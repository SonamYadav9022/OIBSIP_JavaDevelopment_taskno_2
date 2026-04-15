import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("Welcome to Advanced Number Guessing Game!");

        while (playAgain) {

            // Difficulty Selection
            System.out.println("\nChoose Difficulty Level:");
            System.out.println("1. Easy (10 attempts)");
            System.out.println("2. Medium (7 attempts)");
            System.out.println("3. Hard (5 attempts)");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            int maxAttempts;

            switch (choice) {
                case 1:
                    maxAttempts = 10;
                    break;
                case 2:
                    maxAttempts = 7;
                    break;
                case 3:
                    maxAttempts = 5;
                    break;
                default:
                    System.out.println("Invalid choice! Defaulting to Medium.");
                    maxAttempts = 7;
            }

            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nGuess the number between 1 and 100!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Correct! You guessed it in " + attempts + " attempts.");

                    // Score Calculation
                    int roundScore = (maxAttempts - attempts + 1) * 10;
                    totalScore += roundScore;

                    System.out.println("You earned " + roundScore + " points!");
                    guessedCorrectly = true;
                    break;

                } else if (userGuess > randomNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Too low!");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("You lost this round!");
                System.out.println("Correct number was: " + randomNumber);
            }

            System.out.println("Total Score: " + totalScore);

            // Replay Option
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next();

            if (!response.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nFinal Score: " + totalScore);
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
