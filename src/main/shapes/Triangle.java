package main.shapes;

/**
 * @author Pstyga Stas
 * @created 19.03.2026
 */
public class Triangle implements Shape{

    private int sideA;
    private int sideB;
    private int sideC;

    public Triangle(int sideA, int sideB, int sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public int getSquare() {
        int p = Math.round(getPerimeter() / 2);
        return (int) Math.sqrt(p * (p - this.sideA) * (p - this.sideB) * (p - this.sideC));
    }

    @Override
    public int getPerimeter() {
        return this.sideA + this.sideB + this.sideC;
    }
}
