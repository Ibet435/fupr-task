import java.util.Scanner;

/**
 * GameManager manages the game's flow.
 *
 * Responsibilities:
 * - Generates the secret code
 * - Manages number of guesses and win/loss conditions
 * - Requests valid input from PlayerInput
 * - Uses GuessEvaluator to determine the amount of feed back
 * - Displays the result on the console
 *
 * This class has all the game flow logic, BUT it does NOT include low-level logic
 * (i.e. generating the code, validating input, determining what is a good or bad match).
 * This will make the game very simple to convert to a gui application at a future date.
 */
public class GameManager {

    private static final int MAX_ATTEMPTS = 10;

    private final CodeGenerator codeGenerator;
    private final GuessEvaluator guessEvaluator;
    private final PlayerInput playerInput;

    public GameManager () {
        this.codeGenerator = new CodeGenerator();
        this.guessEvaluator = new GuessEvaluator ();
        this.playerInput = new PlayerInput(new Scanner(System.in));
    }

    /**
     * Starts the main loop of the game and determines whether the game ends as a loss or a win.
     */
    public void startGame() {
        String secretCode = codeGenerator.generateSecretCode ();
        int attemptsUsed = 0;
        boolean isCracked = false;

        System.out.println ("=== CODE CRACKER ===");
        System.out.println ("The code is made up of 4 letters that are each one of A–F and you can use duplicate letters.");
        System.out.println ("You have " + MAX_ATTEMPTS + " chances. Good Luck! \n ");

// Main game loop
        while (attemptsUsed < MAX_ATTEMPTS && !isCracked) {
            System.out.println ("Attempt # " + (attemptsUsed+1) + " of " + MAX_ATTEMPTS);

// Gets a valid guess from the PlayerInput
            String guess = playerInput.readValidGuess ();

// Evaluates the guess based on the logic class
            GuessResult result = guessEvaluator.evaluateGuess (secretCode, guess);
            attemptsUsed++;

// Provides the player with some feed back
            System.out.println ("Exact Matches: " + result.getExactMatches());
            System.out.println ("Partial Matches: " + result.getPartialMatches() +"\n ");

// Determines if the game should end as a win or a loss
            if (result.getExactMatches()==4){
                isCracked = true;
                System.out.println ("Congratulations! You cracked the code in " + attemptsUsed + " attempts.");
            }
        }

// The end of the game, reveals the secret code
        if (!isCracked){
            System.out.println ("You ran out of attempts!");
        }

        System.out.println ("Thanks for playing.");
        System.out.println ("The secret code was: " + secretCode );
    }
}