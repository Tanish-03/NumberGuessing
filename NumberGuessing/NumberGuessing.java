import java.util.Scanner;
import java.util.Random;

public class NumberGuessing {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Random random = new Random();
            
            int minNumber = 1;
            int maxNumber = 100;
            int maxAttempts = 10;
            int score = 0;
            
            System.out.println("Welcome to Guess the Number game!");
            System.out.println("You need to guess a number between " + minNumber + " and " + maxNumber + ".");
            System.out.println("You have " + maxAttempts + " attempts. Let's begin!");
            
            boolean playAgain = true;
            while (playAgain) {
                int secretNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
                int attempts = 0;
                
                while (attempts < maxAttempts) {
                    System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                    int guess;
                    try {
                        guess = sc.nextInt();
                    } catch (java.util.InputMismatchException e) {
                        sc.nextLine();
                        System.out.println("Invalid input. Please enter a valid number.");
                        continue;
                    }
                    attempts++;
                    
                    if (guess == secretNumber) {
                        score += (maxAttempts - attempts + 1);
                        System.out.println("Congratulations! You guessed the number " + secretNumber + " correctly in " + attempts + " attempts.");
                        break;
                    } else if (guess < secretNumber) {
                        System.out.println("Your guess is too low.");
                    } else {
                        System.out.println("Your guess is too high.");
                    }
                    
                    if (attempts == maxAttempts) {
                        System.out.println("Sorry, you have used all your attempts. The secret number was: " + secretNumber);
                    }
                }
                
                System.out.print("Your current score: " + score + " points.\n\n");
                
                System.out.print("Do you want to play again? (yes/no): ");
                String playAgainInput = sc.next();
                playAgain = playAgainInput.equalsIgnoreCase("yes");
            }
            
            System.out.println("Thank you for playing Guess the Number!");
        }
    }
}
