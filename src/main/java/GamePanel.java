import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final SquarePanel[][] squarePanels;
    private final JLabel textField;

    private static final Dimension GAME_PANEL_DIMENSION = new Dimension(600, 600);

    GamePanel(){
        this.squarePanels = new SquarePanel[3][3];
        Font font = new Font("Comic Sans MS", Font.BOLD, 35);
        this.textField = new JLabel(String.valueOf(font));
        this.textField.setText("TicTacToe");
        this.textField.setHorizontalAlignment(JLabel.CENTER);

        this.textField.setOpaque(true);




        for (int row = 0; row < 3; row++){
            for (int column = 0; column < 3; column++){
                final SquarePanel squarePanel = new SquarePanel(this, row,column);
                squarePanels[row][column] = squarePanel;
                add(squarePanel);
            }
        }
        setPreferredSize(GAME_PANEL_DIMENSION);
        setLayout(new GridLayout(3, 3));
        checkWin();



    }

    public Player getPlayerX() {
        return new Player();
    }

    public Player getPlayerO() {
        return new Player();
    }

    boolean checkWin(){
        //To check the rows
        for (int row = 0; row < 3; row++){
            if (checkRowColumn(squarePanels[row][0], squarePanels[row][1], squarePanels[row][2])){
                hightlightWinner(squarePanels[row][0], squarePanels[row][1], squarePanels[row][2]);
                return true;
            }
        }
        //To check the columns
        for (int column = 0; column < 3; column++){
            if (checkRowColumn(squarePanels[0][column], squarePanels[1][column], squarePanels[2][column])){
                hightlightWinner(squarePanels[0][column], squarePanels[1][column], squarePanels[2][column]);
                return true;
            }
        }
        //To check the diagonals
        if (checkRowColumn(squarePanels[0][0], squarePanels[1][1], squarePanels[2][2])) {
            hightlightWinner(squarePanels[0][0], squarePanels[1][1], squarePanels[2][2]);
            return true;
        }
        if (checkRowColumn(squarePanels[0][2], squarePanels[1][1], squarePanels[2][0])){
            hightlightWinner(squarePanels[0][2], squarePanels[1][1], squarePanels[2][0]);
            return true;
        }

        //TODO: Check for draw
        return false;
    }

    private void hightlightWinner(SquarePanel squarePanel, SquarePanel squarePanel1, SquarePanel squarePanel2) {
        squarePanel.setBackground(Color.BLACK);
        squarePanel1.setBackground(Color.BLACK);
        squarePanel2.setBackground(Color.BLACK);

        disableAllPanels();
        textField.setText(squarePanel.getLabel() + "wins");
//        gameOver(squarePanel.getLabel() + "Wins");
    }

//    void gameOver(String s) {
//    }

    void disableAllPanels() {
        for (int row = 0; row < 3; row++){
            for (int column = 0; column < 3; column++){
                squarePanels[row][column].setEnabled(false);
            }
        }
    }

    private boolean checkRowColumn(SquarePanel squarePanel, SquarePanel squarePanel1, SquarePanel squarePanel2){
        return squarePanel.getLabel().equals(squarePanel1.getLabel())
                && squarePanel1.getLabel().equals(squarePanel2.getLabel())
                && !squarePanel.getLabel().isEmpty();
    }
}