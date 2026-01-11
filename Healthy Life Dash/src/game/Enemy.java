package game;

import java.awt.*;
import java.util.Random;
import javax.swing.ImageIcon;

public class Enemy {

    int x, y;
    int speed;
    Random r = new Random();

    ImageIcon img = new ImageIcon("src/images/enemy.png");

    public Enemy(int level) {
        x = r.nextInt(500);
        y = r.nextInt(500);
        speed = 2 + level;
    }

    public void move(Player player) {
        if (player.x > x) x += speed;
        if (player.x < x) x -= speed;
        if (player.y > y) y += speed;
        if (player.y < y) y -= speed;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 42, 42);
    }

    public void draw(Graphics g) {
        if (img.getImageLoadStatus() == MediaTracker.COMPLETE)
            g.drawImage(img.getImage(), x, y, 42, 42, null);
        else {
            g.setColor(Color.BLACK);
            g.fillRect(x, y, 42, 42);
        }
    }
}
