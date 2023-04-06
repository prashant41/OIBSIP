import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        int secretNumber = (int)(Math.random() * 100) + 1;
        int guess;
        int numGuesses = 0;
        int playerScore = 100;
        boolean isWin = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");

        while (!isWin) {
            System.out.print("Enter your guess (1-100): ");
            guess = scanner.nextInt();
            numGuesses++;

            if (guess == secretNumber) {
                isWin = true;
                System.out.println("You win! The number was " + secretNumber);
                System.out.println("It took you " + numGuesses + " guesses.");
                System.out.println("Your score is " + playerScore);
            } else if (guess < secretNumber) {
                System.out.println("Too low! Guess again.");
                playerScore = playerScore -10;
            } else {
                System.out.println("Too high! Guess again.");
                playerScore = playerScore - 10;
            }
            //Hint option
            System.out.println("Do you want a hint? y/n");
            String hintOption = scanner.next();
            if (hintOption.equals("y")) {
                if (guess < secretNumber) {
                    System.out.println("Hint: The number is higher than " + guess);
                } else {
                    System.out.println("Hint: The number is lower than " + guess);
                }
            }
        }
    }
}
