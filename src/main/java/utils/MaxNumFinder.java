package utils;

/**
 * @author Pstyga Stas
 * @created 20.05.2026
 */
public class MaxNumFinder implements Runnable{

    int[] array;

    public MaxNumFinder(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        int maxNum = array[0];
        for (int i : array) {
            if(maxNum < i) maxNum = i;
        }
        System.out.println(maxNum);
    }
}
