package game;

public enum FoodType {

    APPLE(true, false),
    WATER(true, false),
    BEYAZ(true, false),

    CHOCOLATE(false, false),
    CAKE(false, false),
    COKE(false, true);

    public boolean isHealthy;
    public boolean askQuestion;

    FoodType(boolean h, boolean q) {
        isHealthy = h;
        askQuestion = q;
    }
}
