package game;

import javax.swing.*;
import utils.MusicPlayer;

public class Game extends JFrame {

    public String playerName;
    int levelNo;

    public Game(String playerName, int levelNo) {
        this.playerName = playerName;
        this.levelNo = levelNo;

        MusicPlayer.play(); // 🔊 HER LEVEL AYNI MÜZİK

        setTitle("Healthy Children");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel panel = new GamePanel(this, levelNo);
        add(panel);

        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        panel.requestFocusInWindow();
    }

    public void gameOver(int level) {
        int result = JOptionPane.showOptionDialog(
                this,
                "Game Over!\nLevel: " + level,
                "Game Over",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new String[]{"Retry", "Menu"},
                "Retry"
        );

        dispose();

        if (result == 0) {
            new Game(playerName, 1);
        } else {
            MusicPlayer.stop();
            new Menu().showMenu();
        }
    }
}
