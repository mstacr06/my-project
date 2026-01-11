package game;

import java.awt.*;
import javax.swing.ImageIcon;

public class Food {

    int x, y;
    FoodType type;
    boolean collected = false;
    ImageIcon img;

    public Food(int x, int y, FoodType type) {
        this.x = x;
        this.y = y;
        this.type = type;

        img = new ImageIcon("src/images/" +
                type.name().toLowerCase() + ".png");
    }

    public void draw(Graphics g) {
        if (collected) return;

        if (img.getImageLoadStatus() == MediaTracker.COMPLETE)
            g.drawImage(img.getImage(), x, y, 42, 42, null);
        else {
            g.setColor(type.isHealthy ? Color.GREEN : Color.RED);
            g.fillOval(x, y, 42, 42);
        }
    }
}
