package game;

import javax.swing.JOptionPane;
import utils.FileManager;

public class Menu {

    public static void showMenu() {
        String[] options = {"New Game", "Load Game", "Exit"};

        int choice = JOptionPane.showOptionDialog(
                null,
                "Healthy Snake",
                "Main Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
        );

        if (choice == 0) {
            String name = JOptionPane.showInputDialog("Enter player name:");
            if (name != null && !name.isEmpty()) {
                new Game(name, 1);
                FileManager.saveGame(name, 1);
            }
        } else if (choice == 1) {
            String name = JOptionPane.showInputDialog("Enter saved name:");
            int level = utils.FileManager.loadGame(name);
            if (level > 0) {
                new Game(name, level);
            }
        } else {
            System.exit(0);
        }
    }
}
