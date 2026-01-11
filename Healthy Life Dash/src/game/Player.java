package game;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Player extends KeyAdapter {

    int x = 50, y = 50;
    int size = 32;
    int speed = 14;
    int sugar = 0;
    Direction dir = Direction.RIGHT;

    Image img;

    public Player() {
        img = new ImageIcon(
                getClass().getResource("/images/player.png")
        ).getImage();
    }

    public void move() {
        switch (dir) {
            case UP -> y -= speed;
            case DOWN -> y += speed;
            case LEFT -> x -= speed;
            case RIGHT -> x += speed;
        }
    }

    public boolean hitWall() {
        return x < 0 || y < 0 || x > 560 || y > 560;
    }

    public boolean collide(Object o) {
        Rectangle r1 = new Rectangle(x, y, size, size);
        Rectangle r2;

        if (o instanceof Food f)
            r2 = new Rectangle(f.x, f.y, 42, 42);
        else if (o instanceof Enemy e)
            r2 = e.getBounds();
        else if (o instanceof Door d)
            r2 = new Rectangle(d.x, d.y, 42, 42);
        else
            return false;

        return r1.intersects(r2);
    }

    public void draw(Graphics g, int ox, int oy) {
        g.drawImage(img, x + ox, y + oy, size, size, null);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) dir = Direction.UP;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) dir = Direction.DOWN;
        if (e.getKeyCode() == KeyEvent.VK_LEFT) dir = Direction.LEFT;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) dir = Direction.RIGHT;
    }
}
