package main.shapes;

/**
 * @author Pstyga Stas
 * @created 19.03.2026
 */
public class Square implements Shape {

    private int sideA;
    private int sideB;

    public Square(int sideA, int sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double getSquare() {
        return this.sideA * this.sideB;
    }

    @Override
    public double getPerimeter() {
        return (this.sideA + this.sideB) * 2;
    }
}
