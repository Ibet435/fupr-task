import java.util.Random;

/**
 * CodeGenerator is the generator of random 4 letter secret code.
 *
 * This class has no game logic and no user interface.
 * It can be used to create a GUI version as is, with no changes.
 */
public class CodeGenerator {

    private static final char[] ALLOWED_CHARS = { 'A', 'B', 'C', 'D', 'E', 'F' };
    private static final int CODE_LENGTH = 4;

    private final Random random;

    public CodeGenerator() {
        this.random = new Random();
    }

    /**
     * Produces a random 4 character code from letters A–F.
     * Duplicate characters are acceptable.
     */
    public String generateSecretCode() {
        StringBuilder code = new StringBuilder(CODE_LENGTH);

        for (int i = 0; i < CODE_LENGTH; i++) {
            int index = random.nextInt(ALLOWED_CHARS.length);
            code.append(ALLOWED_CHARS[index]);
        }

        return code.toString();
    }
}