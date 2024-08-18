import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 10;
    private static final int MAX_ROUNDS = 3;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;

        System.out.println("NUMBER GUESSING GAME");
        System.out.println("Total Number Of Rounds: " + MAX_ROUNDS);
        System.out.println("Attempts To Guess Number In Each Round: " + MAX_ATTEMPTS + "\n");

        for (int i = 1; i <= MAX_ROUNDS; i++) {
            int number = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE; // Ensure number is within the range
            int attempts = 0;

            System.out.printf("Round %d: Guess the number between %d and %d in %d attempts.\n", i, MIN_RANGE, MAX_RANGE, MAX_ATTEMPTS);

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Invalid input! Enter a number between " + MIN_RANGE + " and " + MAX_RANGE + ": ");
                    scanner.next(); // Clear invalid input
                }
                int guess_number = scanner.nextInt();

                if (guess_number < MIN_RANGE || guess_number > MAX_RANGE) {
                    System.out.printf("Please enter a number between %d and %d.\n", MIN_RANGE, MAX_RANGE);
                    continue;
                }

                attempts++;

                if (guess_number == number) {
                    int score = MAX_ATTEMPTS - attempts + 1; // Adjust scoring
                    totalScore += score;
                    System.out.printf("Hurray! Number guessed successfully. Attempts = %d. Round Score = %d\n", attempts, score);
                    break;
                } else if (guess_number < number) {
                    System.out.printf("The number is greater than %d. Attempts left = %d.\n", guess_number, MAX_ATTEMPTS - attempts);
                } else {
                    System.out.printf("The number is less than %d. Attempts left = %d.\n", guess_number, MAX_ATTEMPTS - attempts);
                }
            }

            if (attempts == MAX_ATTEMPTS) {
                System.out.printf("\nRound %d: You've used all attempts. The correct number was: %d\n\n", i, number);
            }
        }
        System.out.printf("Game Over. Total Score = %d\n", totalScore);
        scanner.close();
    }
}
