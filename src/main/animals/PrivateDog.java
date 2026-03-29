package main.animals;

/**
 * @author Pstyga Stas
 * @created 29.03.2026
 */
public class PrivateDog extends Dog{

    private static PrivateDog privateDog = new PrivateDog();

    private PrivateDog() {
    }

    public static PrivateDog getInstance() {
        return privateDog;
    }
}
