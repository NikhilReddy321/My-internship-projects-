import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Set the range for the random number
        int minRange = 1;
        int maxRange = 100;

        // Generate a random number within the specified range
        int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between " + minRange + " and " + maxRange + ". Try to guess it!");

        int userGuess;
        int attempts = 0;

        do {
            // Input user's guess
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();

            // Increment the attempts count
            attempts++;

            // Check if the guess is correct
            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
            } else if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }

        } while (userGuess != randomNumber);

        // Close the scanner
        scanner.close();
    }
}

