import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int lowerBound = 1;
            int upperBound = 100;
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attemptsLeft = 7; 
            boolean guessedCorrectly = false;

            System.out.println("\nI have chosen a number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + attemptsLeft + " attempts to guess it!");

            
            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attemptsLeft--;

                if (userGuess == numberToGuess) {
                    System.out.println("🎉 Congratulations! You guessed the correct number!");
                    guessedCorrectly = true;
                    break;
                } else if (userGuess > numberToGuess) {
                    System.out.println("📉 Too high! Attempts left: " + attemptsLeft);
                } else {
                    System.out.println("📈 Too low! Attempts left: " + attemptsLeft);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ Out of attempts! The number was: " + numberToGuess);
            }

            
            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = sc.next().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
                System.out.println(" Thanks for playing! Goodbye.");
            }
        }

        sc.close();
    }
}
