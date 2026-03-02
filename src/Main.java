import java.util.Scanner;

/**
 * @author Pstyga Stas
 * @created 02.03.2026
 */
public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Задача 1:
        //Напишите программу, которая будет принимать на вход число из консоли и на выход
        //будет выводить сообщение четное число или нет. Для определения четности числа
        //используйте операцию получения остатка от деления (операция выглядит так: '% 2').
        isNumEven();

        //Задача 2:
        //Для введенного числа t (температура на улице) вывести: Если t>–5, то вывести «Warm».
        //Если –5>= t > –20, то вывести «Normal». Если –20>= t, то вывести «Cold».
        getWeatherByTemp(-5);

        //Задача 3:
        //Составьте программу, выводящую на экран квадраты чисел от 10 до 20 включительно.
        getNumsSqFrom10To20();

        //Задача 4:
        //Необходимо, чтоб программа выводила на экран вот такую последовательность:
        //7 14 21 28 35 42 49 56 63 70 77 84 91 98. В решении используйте цикл while.
        getSequenceBy7();

        //Задача *:
        //Напишите программу, где пользователь вводит любое целое положительное число. А
        //программа суммирует все числа от 1 до введенного пользователем числа. Для ввода
        //числа воспользуйтесь классом Scanner. Сделать проверку, чтобы пользователь не мог
        getFactorialByNum();
    }

    public static void isNumEven() {
        System.out.print("Введите число: ");
        int num = sc.nextInt();
        if (num % 2 == 0) {
            System.out.println(num + " четное число");
        } else {
            System.out.println(num + " нечетное");
        }
    }

    public static void getWeatherByTemp(int temp) {
        if (temp > -5) {
            System.out.println(temp + " is warm");
        } else if (temp <= -20) {
            System.out.println(temp + " is cold");
        } else {
            System.out.println(temp + " is normal");
        }
    }

    public static void getNumsSqFrom10To20() {
        for (int i = 10; i <= 20; i++) {
            System.out.print(Math.round(Math.pow(i, 2)) + " ");
        }
        System.out.println();
    }

    public static void getSequenceBy7() {
        int i = 7;
        while (i < 100) {
            System.out.print(i + " ");
            i += 7;
        }
        System.out.println();
    }

    public static void getFactorialByNum() {
            System.out.print("Введите число: ");
            if (sc.hasNextInt()) {
                int resultNum = 0;
                int inputNum = sc.nextInt();
                for (int i = 0; i <= inputNum; i++) {
                    resultNum += i;
                }
                System.out.println(resultNum);
            } else {
                System.out.println("Incorrect num");
            }
    }
}
