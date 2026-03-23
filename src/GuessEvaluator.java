/**
 * GuessEvaluator evaluates a player's guess versus the secret code.
 *
 * It determines both:
 * - Exact matches (correct letter at the correct location).
 * - Partial matches (correct letter, incorrect location).
 *
 * The logic contained within this class represents the core of the game,
 * and is completely independent of the user interface, thus allowing for
 * complete testing of the application without a UI.
 */

public class GuessEvaluator {

    private static final int CODE_LENGTH = 4;
    private static final int ALPHABET_SIZE = 6; // A-F

    /**
     * Evaluate a player's guess against the secret code and return
     * a GuessResult object containing the number of exact and
     * partial matches found in the guess.
     */
    public GuessResult evaluateGuess(String secret, String guess) {
        int exactMatches = calculateExactMatches(secret, guess);
        int partialMatches = calculatePartialMatches(secret, guess);
        return new GuessResult(exactMatches, partialMatches);
    }

    /**
     * Determine the number of exact matches by comparing
     * characters at the corresponding locations in the
     * two strings.
     */
    private int calculateExactMatches(String secret, String guess) {
        int exact = 0;

        for (int i = 0; i < CODE_LENGTH; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                exact++;
            }
        }

        return exact;
    }

    /**
     * Determine the number of partial matches using frequency
     * arrays.
     *
     * To avoid double counting, this method excludes exact
     * matches from consideration and then counts the number
     * of times that each letter appears in either string.
     * Finally, it adds up the smallest of these two values.
     */
    private int calculatePartialMatches(String secret, String guess) {
        int[] secretFreq = new int[ALPHABET_SIZE];
        int[] guessFreq = new int[ALPHABET_SIZE];

// Build frequency tables excluding exact matches
        for (int i = 0; i < CODE_LENGTH; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s != g) {
                secretFreq[charToIndex(s)]++;
                guessFreq[charToIndex(g)]++;
            }
        }

// Count partial matches
        int partial = 0;
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            partial += Math.min(secretFreq[i], guessFreq[i]);
        }

        return partial;
    }

    /**
     * Convert a character A-F into its index value 0-5.
     */
    private int charToIndex(char c) {
        return c - 'A';
    }
}
