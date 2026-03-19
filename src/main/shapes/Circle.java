package main.shapes;

import main.workers.WorkerInfo;

/**
 * @author Pstyga Stas
 * @created 19.03.2026
 */
public class Circle implements Shape {

    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public int getSquare() {
        return (int) Math.round(Math.PI * Math.pow(this.radius, 2));
    }

    @Override
    public int getPerimeter() {
        return (int) Math.round(2 * Math.PI * this.radius);
    }
}
