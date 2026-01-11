package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Level {

    int levelNumber;
    List<Food> foods = new ArrayList<>();
    Random r = new Random();

    public Level(int levelNumber) {
        this.levelNumber = levelNumber;

        
        for (int i = 0; i < 5; i++) {
            spawnRandomFood();
        }

        ensureHealthyFood();
    }

    
    public void spawnRandomFood() {
        int x, y;

        do {
            x = r.nextInt(520) + 20;
            y = r.nextInt(520) + 40;
        } while (collidesWithAny(x, y));

        FoodType[] types = FoodType.values();
        FoodType t = types[r.nextInt(types.length)];

        foods.add(new Food(x, y, t));
    }

    
    public void spawnHealthyFood() {
        int x, y;

        do {
            x = r.nextInt(520) + 20;
            y = r.nextInt(520) + 40;
        } while (collidesWithAny(x, y));

        FoodType[] healthy = {
                FoodType.APPLE,
                FoodType.WATER,
                FoodType.BEYAZ
        };

        FoodType t = healthy[r.nextInt(healthy.length)];
        foods.add(new Food(x, y, t));
    }

   
    public void ensureHealthyFood() {
        boolean healthyExists = false;

        for (Food f : foods) {
            if (!f.collected && f.type.isHealthy) {
                healthyExists = true;
                break;
            }
        }

        if (!healthyExists) {
            spawnHealthyFood();
        }
    }

    
    public void draw(Graphics g) {
        for (Food f : foods) {
            if (!f.collected) {
                f.draw(g);
            }
        }
    }

   
    boolean collidesWithAny(int x, int y) {
        Rectangle r1 = new Rectangle(x, y, 42, 42);

        for (Food f : foods) {
            if (f.collected) continue;

            Rectangle r2 = new Rectangle(f.x, f.y, 42, 42);
            if (r1.intersects(r2)) {
                return true;
            }
        }
        return false;
    }
}
