package main.animals;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pstyga Stas
 * @created 20.04.2026
 */
public class Animals {
    private List<Animal> animals = new ArrayList<>();

    public void add(Animal animal) {
        this.animals.add(0, animal);
    }

    public void delete() {
        this.animals.remove(animals.size() - 1);
    }

    public void showAnimals() {
        System.out.println(animals);
    }
}
