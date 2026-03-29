package main;

/**
 * @author Pstyga Stas
 * @created 29.03.2026
 */
public class Apple {

    private String color;

    public Apple(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color + " apple";
    }
}
