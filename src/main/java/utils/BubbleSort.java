package utils;

import java.util.Arrays;

/**
 * @author Pstyga Stas
 * @created 20.05.2026
 */
public class BubbleSort implements Runnable{
    int[] arr;

    public BubbleSort(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        System.out.println("Bubble sort - " + Arrays.toString(arr));
    }
}
