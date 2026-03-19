package main.workers;

/**
 * @author Pstyga Stas
 * @created 19.03.2026
 */
public class Director implements WorkerInfo{

    @Override
    public void printInfo() {
        System.out.println("Это директор");
    }
}
