/*
 * This the entry-point of our application
 *
 * This class has only a single method: main().
 * I purposely did so that way I can follow best practices for separation of possible concerns (i.e.,
 * all game-logic will be implemented in GameManager).
 */
public class Main {
    public static void main(String[] args) {
// Initialize and run the game controller
        GameManager gameManager = new GameManager();
        gameManager.startGame();
    }
}
