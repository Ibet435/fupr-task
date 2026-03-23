import java.util.Scanner;

/**
 * PlayerInput manages all of the user's interaction with the application.
 *
 * By having PlayerInput handle everything that has to do with input,
 * we ensure that:
 * - The application does not crash from an error related to the user's input.
 * - The GameManager stays clean and focused on managing the flow of the game.
 * - Any changes to how the application accepts input are done within the PlayerInput class,
 * rather than throughout the rest of the application.
 */

public class PlayerInput {

    // The number of digits in the code.
    private static final int CODE_LENGTH = 4;

    // Valid digits.
    private static final String VALID_CHARS = "ABCDEF";

    private final Scanner scanner;

    public PlayerInput(Scanner scanner)
    {
        this.scanner = scanner;
    }

    /**
     * Will keep asking for a guess until a valid guess is provided by the player.
     *
     * Rules for determining a valid guess:
     * - Exactly four (4) characters long.
     * - Only use the letters A-F (upper case).
     * - Case insensitive.
     */
    public String readValidGuess()
    {
        while (true)
        {
            System.out.print("Enter your 4 letter guess (A–F): ");
            String input = scanner.nextLine();

            if (null == input)
            {
                System.out.println("Input cannot be null. Please try again.");
                continue;
            }

            input = input.trim().toUpperCase();

            if (!isValidLength(input))
            {
                System.out.println("Invalid length. Your guess must be exactly " + CODE_LENGTH + " characters.");
                continue;
            }

            if (!containsOnlyValidChars(input))
            {
                System.out.println("Invalid characters. Use only letters A–F.");
                continue;
            }

            return input;
        }
    }

    private boolean isValidLength(String input)
    {
        return input.length() == CODE_LENGTH;
    }

    private boolean containsOnlyValidChars(String input)
    {
        for (char c : input.toCharArray())
        {
            if (-1 == VALID_CHARS.indexOf(c))
            {
                return false;
            }
        }

        return true;
    }
}
