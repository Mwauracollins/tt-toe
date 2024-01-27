import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SquarePanel extends JPanel {
    private int row;
    private int column;
    private JLabel label;
    private static final Dimension SQUARE_PANEL_DIMENSION = new Dimension(100, 100);

    SquarePanel(GamePanel gamePanel, int row, int column){
        this.row = row;
        this.column = column;
        label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        Font font = new Font("Comic Sans MS", Font.BOLD, 35);
        label.setFont(font);
        this.add(label);

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int clickedX = e.getX();
                int clickedY = e.getY();

                int squareCoordinate = getSquareIndex(clickedX, clickedY);
                updateGameState(squareCoordinate, gamePanel);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        setPreferredSize(SQUARE_PANEL_DIMENSION);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void updateGameState(int squareCoordinate, GamePanel gamePanel) {
        Player currentPlayer = Player.firstTurn() ? gamePanel.getPlayerX() : gamePanel.getPlayerO();

        try {
            if (label.getText().isEmpty()){
                label.setForeground(Player.firstTurn() ? Color.RED :  Color.BLUE);
                label.setText(currentPlayer.getSymbol());
                Player.firstTurn = !Player.firstTurn();
                disablePanel();
                if (gamePanel.checkWin()){
                    gamePanel.disableAllPanels();
                    gamePanel.gameOver(currentPlayer.getSymbol() + "Wins");
                }
            }
            else {
                Player.firstTurn = Player.firstTurn();

                throw new IllegalStateException("Square already marked");
            }
        }catch (IllegalStateException e){
            System.out.println("Square is marked");
        }

    }

    private int getSquareIndex(int clickedX, int clickedY) {
        return ((row * 3) + column);
    }
    public String getLabel(){
        return label.getText();
    }
    public void setLabel(String text){
        label.setText(text);
    }
    public void disablePanel(){
        this.setEnabled(false);
    }
}
