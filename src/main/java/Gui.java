import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {
    private JFrame gameFrame;
    private GamePanel gamePanel;
    private JMenuBar gameMenuBar;

    private static final Dimension GAME_FRAME_DIMENSION = new Dimension(600, 600);
    Gui(){
        this.gameFrame = new JFrame("Tik Tak Toe");
        this.gameFrame.setSize(GAME_FRAME_DIMENSION);
        this.gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.gameMenuBar = new JMenuBar();
        createMenuBar(this.gameMenuBar);
        this.gameFrame.setJMenuBar(gameMenuBar);

        this.gamePanel = new GamePanel();
        this.gameFrame.add(gamePanel);

        this.gameFrame.pack();
        this.gameFrame.setVisible(true);

    }

    private void createMenuBar(JMenuBar gameMenuBar) {
        gameMenuBar.add(createNewGameMenu());
    }

    private JMenu createNewGameMenu() {
        final JMenu newGameMenu = new JMenu("New Game");

        final JMenuItem twoPlayer = new JMenuItem("Two Player");
        twoPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO Add Action Listener for creating 1 v 1 play mode
            }
        });
        newGameMenu.add(twoPlayer);

        final JMenuItem computerPlayer = new JMenuItem("Play Against AI");
        computerPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO Game mode against AI
            }
        });
        newGameMenu.add(computerPlayer);

        return newGameMenu;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Gui gui = new Gui();

            }
        };
        SwingUtilities.invokeLater(r);
    }

}
