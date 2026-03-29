package main.animals;

import main.food.Food;

/**
 * @author Pstyga Stas
 * @created 29.03.2026
 */
public class Tiger extends Animal {

    @Override
    public void voice() {
        System.out.println("РРРРР");
    }

    @Override
    public void eat(Food food) {
        if (food.getFood().equals("Meat")) {
            System.out.println("Тигру нравится мясо");
        } else {
            System.out.println("Тигру не нравится такая еда");
        }
    }

}
