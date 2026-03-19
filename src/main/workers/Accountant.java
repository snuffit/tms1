package main.workers;

/**
 * @author Pstyga Stas
 * @created 19.03.2026
 */
public class Accountant implements WorkerInfo{

    @Override
    public void printInfo() {
        System.out.println("Это бухгалтер");
    }
}
