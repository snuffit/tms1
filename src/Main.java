import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        //Для всех задач исходные условия следующие: пользователь с клавиатуры вводит размер
        //массива (просто целое число). После того, как размер массива задан, заполнить его
        //одним из двух способов: используя Math.random(), или каждый элемент массива вводится
        //пользователем вручную. Попробовать оба варианта. После заполнения массива
        //данными, решить для него следующие задачи:

        //printArray(makeArrayByInput(5));
        int[] array = makeArrayByRandom(5);

        //Задача 1:
        //Пройти по массиву, вывести все элементы в прямом и в обратном порядке.
        printArray(array);
        printReverseArray(array);
        makeRow();

        //Задача 2:
        //Найти минимальный-максимальный элементы и вывести в консоль.
        System.out.println(getMaxNumFromArray(array));
        System.out.println(getMinNumFromArray(array));
        makeRow();

        //Задача 3:
        //Найти индексы минимального и максимального элементов и вывести в консоль.
        System.out.println(getMaxIndexFromArray(array));
        System.out.println(getMinIndexFromArray(array));
        makeRow();

        //Задача 4:
        //Найти и вывести количество нулевых элементов. Если нулевых элементов нет - вывести
        //сообщение, что их нет.

        System.out.printf("Количество нулей в массиве: %d\n", counterOfArraysZero(array));
        makeRow();

        //Задача 5:
        //Пройти по массиву и поменять местами элементы первый и последний, второй и
        //предпоследний и т.д.
        printArray(reverseArray(array));
        makeRow();

        //Задача 6:
        //Проверить, является ли массив возрастающей последовательностью (каждое следующее
        //число больше предыдущего).
        if(isArrayContainsSequence(new int[] {1, 4, 6, 7, 6})) {
            System.out.println("Массив содержит последовательность");
        } else {
            System.out.println("Массив не содержит последовательность");
        }
        makeRow();

        //Задача *:
        //Имеется массив из неотрицательных чисел(любой). Представьте что массив
        //представляет целое число (Например массив {1,2,3} -> 123, {9,9,9} -> 999). Задача
        //добавить единицу к этому “числу” и на выходе получить исправленный массив. Массив не
        //содержит нуля в начале, кроме самого числа 0.
        //Пример:
        //Input: [1,4,0,5,6,3]
        //Output: [1,4,0,5,6,4]
        //Input: [9,9,9]
        //Output: [1,0,0,0]
        int[] arrayInt = new int[] {9, 9};
        System.out.print("Был массив: ");
        printArray(arrayInt);
        System.out.print("Стал: ");
        printArray(addNumToIntArray(arrayInt, 1));
        makeRow();
    }

    public static int[] makeArrayByInput(int size) {
        makeRow();
        int[] resultArray = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Введите значение ячейки под индексом " + i + ": ");
            resultArray[i] = sc().nextInt();
        }
        makeRow();
        return resultArray;
    }

    public static int[] makeArrayByRandom(int size) {
        int[] resultArray = new int[size];
        for (int i = 0; i < size; i++) {
            resultArray[i] = (int) (Math.random() * 11);
        }
        makeRow();
        System.out.printf("Массив размером %d с значениями: ", size);
        printArray(resultArray);
        makeRow();
        return resultArray;
    }

    public static void makeRow() {
        System.out.println("================================================");
    }

    public static Scanner sc() {
        return new Scanner(System.in);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i + 1 != array.length) {
                System.out.print(", ");
            }
        }
        System.out.print(".\n");
    }

    public static void printReverseArray(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i]);
            if (i > 0) {
                System.out.print(", ");
            }
        }
        System.out.print(".\n");
    }

    public static int getMaxNumFromArray(int[] array) {
        int maxNum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (maxNum < array[i]) {
                maxNum = array[i];
            }
        }
        return maxNum;
    }

    public static int getMinNumFromArray(int[] array) {
        int maxNum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (maxNum > array[i]) {
                maxNum = array[i];
            }
        }
        return maxNum;
    }

    public static int getMaxIndexFromArray(int[] array) {
        int maxNum = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (maxNum < array[i]) {
                maxNum = array[i];
                index = i;
            }
        }
        return index;
    }

    public static int getMinIndexFromArray(int[] array) {
        int maxNum = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (maxNum > array[i]) {
                maxNum = array[i];
                index = i;
            }
        }
        return index;
    }

    public static int counterOfArraysZero(int[] array) {
        int counter = 0;
        for (int i : array) {
            if (i == 0) {
                counter++;
            }
        }
        return counter;
    }

    public static int[] reverseArray(int[] array) {
        int temp;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }

    public static boolean isArrayContainsSequence(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int[] addNumToIntArray(int[] array, int num) {
        int resultNum = 0;
        for (int i : array) {
            resultNum = resultNum * 10 + i;
        }
        resultNum += num;
        String resultStr = String.valueOf(resultNum);
        int[] resultArray = new int[resultStr.length()];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = Character.getNumericValue(resultStr.charAt(i));
        }
        return resultArray;
    }
}