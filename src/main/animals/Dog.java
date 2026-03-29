package main.animals;

import main.food.Food;

/**
 * @author Pstyga Stas
 * @created 29.03.2026
 */
public class Dog extends Animal {
    @Override
    public void voice() {
        System.out.println("Гав");
    }

    @Override
    public void eat(Food food) {
        if (food.getFood().equals("Bone")) {
            System.out.println("Собаке нравится кость");
        } else {
            System.out.println("Собаке не нравится такая еда");
        }
    }
}
