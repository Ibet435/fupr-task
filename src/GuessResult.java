/**
 * A simple data class for storing the results of a guess assessment.
 *
 * The use of a data class is to improve the readability of code and keep the evaluator free from the overhead of data storage.
 */
public class GuessResult {

    private final int exactMatches; // Number of letters in the target word which match exactly with the guessed letter
    private final int partialMatches; // Number of letters in the target word which match partially with the guessed letter (i.e., correct letter at incorrect position)

    public GuessResult(int exactMatches, int partialMatches) {
        this.exactMatches = exactMatches;
        this.partialMatches = partialMatches;
    }

    public int getExactMatches() { // Returns number of matches where the guessed letter appears at an appropriate position
        return exactMatches;
    }

    public int getPartialMatches() { // Returns number of matches where the guessed letter does not appear at an appropriate position
        return partialMatches;
    }
}
