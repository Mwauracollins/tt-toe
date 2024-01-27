import java.util.Random;

public class Player {
    static boolean firstTurn;
    private static Random random = new Random();
    private static boolean player1Turn;

    public Player(String symbol) {
        // Constructor implementation...
    }

    public static boolean firstTurn() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        firstTurn = !player1Turn;
        player1Turn = firstTurn;
        return firstTurn;
    }


    public String getSymbol() {
        return player1Turn ? "X" : "O";
    }
}
