package main.food;

/**
 * @author Pstyga Stas
 * @created 29.03.2026
 */
public class Food {

    private String food;

    private Food(String food) {
        this.food = food;
    }

    public static Food getGRASS() {
        return new Food("Grass");
    }

    public static Food getMEAT() {
        return new Food("Meat");
    }

    public static Food getBONE() {
        return new Food("Bone");
    }

    public String getFood() {
        return this.food;
    }
}
