package utils;

/**
 * @author Pstyga Stas
 * @created 20.05.2026
 */
public class MinNumFinder implements Runnable {
    int[] array;

    public MinNumFinder(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        int minNum = array[0];
        for (int i : array) {
            if (minNum > i) minNum = i;
        }
        System.out.println(minNum);
    }
}
