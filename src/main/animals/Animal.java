package main.animals;

import main.food.Food;

import java.lang.reflect.Field;

/**
 * @author Pstyga Stas
 * @created 29.03.2026
 */
public abstract class Animal {

    public abstract void voice();

    public abstract void eat(Food food);
}
