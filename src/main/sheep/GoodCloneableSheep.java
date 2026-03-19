package main.sheep;

/**
 * @author Pstyga Stas
 * @created 19.03.2026
 */
public class GoodCloneableSheep extends BadCloneableSheep {

    public GoodCloneableSheep(String name, String coatColor) {
        super(name, coatColor);
    }

    @Override
    public Object clone() {
        GoodCloneableSheep clone = new GoodCloneableSheep(super.getName(), super.getCoatColor());
        return clone;
    }
}
