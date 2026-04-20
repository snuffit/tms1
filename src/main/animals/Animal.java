package main.animals;

/**
 * @author Pstyga Stas
 * @created 20.04.2026
 */
public class Animal {

    private String type;
    private String name;

    public Animal(String type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal: " + type + ' ' + name;
    }
}
