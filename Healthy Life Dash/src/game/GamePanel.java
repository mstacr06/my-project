package game;

import utils.QuestionManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utils.FileManager;

public class GamePanel extends JPanel implements ActionListener {

    Game game;
    Player player;
    Enemy enemy;
    Door door;
    Level level;
    Timer timer;

    Image background;
    
    Color flashColor = null;
    int flashAlpha = 0;
    
    String warningText = null;
    int warningTime = 0;
    
    public GamePanel(Game game, int levelNo) {
       
        this.game = game;

        player = new Player();
        enemy = new Enemy(levelNo);
        door = new Door();
        level = new Level(levelNo);

        setPreferredSize(new Dimension(600, 600));
        setFocusable(true);
        addKeyListener(player);

        timer = new Timer(Math.max(40, 120 - levelNo * 15), this);
        timer.start();
        
        int bgIndex = (levelNo % 4) + 1;
    String path = "/images/bg" + bgIndex + ".png";
     java.net.URL url = getClass().getResource(path);
    if (url == null) {
        System.out.println("BACKGROUND BULUNAMADI: " + path);
    } else {
        background = new ImageIcon(url).getImage();
    }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        player.move();
        enemy.move(player);

        if (player.hitWall() || player.collide(enemy)) {
            timer.stop();
            game.gameOver(level.levelNumber);
            return;
        }

        boolean spawnNewFood = false;

       for (Food f : level.foods) {
    if (!f.collected && player.collide(f)) {
        f.collected = true;

        if (f.type.askQuestion) {

            boolean correct = QuestionManager.ask();

            if (correct) {
                player.sugar += 20;
                flash(new Color(0, 255, 0));
                showWarning("CORRECT!");
            } else {
                player.sugar -= 10;
                flash(new Color(255, 0, 0));
                showWarning("WRONG!");
            }

        } else {
            if (f.type.isHealthy) {
                player.sugar += 20;
                flash(new Color(0, 255, 0));
                showWarning("HEALTHY!");
            } else {
                player.sugar -= 10;
                flash(new Color(255, 0, 0));
                showWarning("UNHEALTHY!");
            }
        }

        player.sugar = Math.max(0, player.sugar);
        spawnNewFood = true;
    }
}




        if (spawnNewFood && level.foods.size() < 8) {
            level.spawnRandomFood();
        }

        level.ensureHealthyFood();

        if (player.sugar >= 100)
            door.open = true;

        if (door.open && player.collide(door)) {
            timer.stop();
            JOptionPane.showMessageDialog(this,
                    "LEVEL " + (level.levelNumber + 1));
            game.dispose();
            new Game(game.playerName, level.levelNumber + 1);
            FileManager.saveGame(game.playerName, level.levelNumber+1);
            return;
        }
        

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

         if (background != null) {
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }
        level.draw(g);
        door.draw(g);
        enemy.draw(g);
        player.draw(g,0,0);

        g.setColor(Color.RED);
        g.fillRect(20, 20, player.sugar * 2, 14);
        g.setColor(Color.BLACK);

        g.drawString("Sugar Balance: " + player.sugar, 20, 15);
        g.drawString("Level " + level.levelNumber, 500, 20);
   
        if (flashAlpha > 0 && flashColor != null) {
             g.setColor(new Color(
            flashColor.getRed(),
            flashColor.getGreen(),
            flashColor.getBlue(),
            flashAlpha
             ));
             g.fillRect(0, 0, getWidth(), getHeight());
             flashAlpha -= 6; // yavaşça kaybolsun
             
             // WARNING TEXT DRAW
        if (warningTime > 0 && warningText != null) {
             g.setFont(new Font("Arial", Font.BOLD, 26));
              g.setColor(Color.RED);

              FontMetrics fm = g.getFontMetrics();
              int textWidth = fm.stringWidth(warningText);

              g.drawString(
                 warningText,
             (getWidth() - textWidth) / 2,
             getHeight() / 2
                  );

                  warningTime--;
             }

        }   

    }
    
    public void flash(Color c) {
    flashColor = c;
    flashAlpha = 120; // 0–255 arası (şeffaflık)

    }
    void showWarning(String text) {
    warningText = text;
    warningTime = 60; // frame (≈1 saniye)
}
}
