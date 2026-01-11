package game;

import java.awt.*;
import javax.swing.*;

public class Door {

    int x = 540, y = 540;
    boolean open = false;
    Image img;

    public Door() {
        var url = Door.class.getResource("/images/door.png");
        if (url != null)
            img = new ImageIcon(url).getImage();
    }

    public Rectangle getBounds() {
        
        return new Rectangle(x, y, 40, 40);
        
    }

    public void draw(Graphics g) {
        if (img != null)
            
            g.drawImage(img, x, y, 40, 40, null);
        else {
            
            g.setColor(open ? Color.GREEN : Color.GRAY
            );
            
            g.fillRect(x, y, 50, 50);
        }
    }
}
