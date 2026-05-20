package utils;

import java.util.Arrays;

/**
 * @author Pstyga Stas
 * @created 20.05.2026
 */
public class SelectionSort implements Runnable {

    int[] arr;

    public SelectionSort(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int temp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = temp;
            }
        }
        System.out.println("Selection sort - " + Arrays.toString(arr));
    }
}
