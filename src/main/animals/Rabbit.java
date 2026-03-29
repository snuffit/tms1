package main.animals;

import main.food.Food;

/**
 * @author Pstyga Stas
 * @created 29.03.2026
 */
public class Rabbit extends Animal {

    @Override
    public void voice() {
        System.out.println("Фыр");
    }

    @Override
    public void eat(Food food) {
        if (food.getFood().equals("Grass")) {
            System.out.println("Кролику нравится трава");
        } else {
            System.out.println("Кролику не нравится такая еда");
        }
    }
}
