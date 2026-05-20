package utils;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Pstyga Stas
 * @created 20.05.2026
 */
public class InsertionSort implements Runnable {

    int[] arr;

    public InsertionSort(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println("Insert sort - " + Arrays.toString(arr));
    }
}
