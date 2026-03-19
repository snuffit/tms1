package main.shapes;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
    public double getSquare() {
        double p = Math.round(getPerimeter() / 2);
        BigDecimal bd = BigDecimal.valueOf(Math.sqrt(p * (p - this.sideA) * (p - this.sideB) * (p - this.sideC)));
        return bd.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double getPerimeter() {
        return this.sideA + this.sideB + this.sideC;
    }
}
