package main.sheep;

/**
 * @author Pstyga Stas
 * @created 19.03.2026
 */
public class BadCloneableSheep implements Cloneable{

    private SheepName name;
    private String coatColor;

    public BadCloneableSheep(String name, String coatColor) {
        this.name = new SheepName(name);
        this.coatColor = coatColor;
    }

    public void setName(String name) {
        this.name.setName(name);
    }

    public void setCoatColor(String coatColor) {
        this.coatColor = coatColor;
    }

    public String getName() {
        return name.getName();
    }

    public String getCoatColor() {
        return coatColor;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Овечка " +
                "с именем '" + name.getName() + '\'' +
                " и цветом шерсти '" + coatColor + '\'';
    }
}
