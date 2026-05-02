package main;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Pstyga Stas
 * @created 01.05.2026
 */
public class Main {

    public static void main(String[] args) {
        //Задача 1:
        //Пользователь вводит в консоль дату своего рождения. Программа должна вернуть дату,
        //когда пользователю исполнится 100 лет. Использовать Date/Time API.
        System.out.println(getYourAgeAfter100("2002-06-19"));

        //Задача 2:
        //Используя Predicate среди массива чисел вывести только те, которые являются
        //положительными.
        getPositiveNums(new int[]{2, 4, 5, -4, 5, 0, -22});

        //Задача 3:
        //Используя Function реализовать лямбду, которая будет принимать в себя строку в
        //формате “*сумма* BYN”(через пробел, вместо *сумма* вставить любое значение), а
        //возвращать сумму, переведенную сразу в доллары.
        System.out.println(transferBYNToUSD.apply("110 BYN"));

        //Задача 4:
        //Используя Consumer реализовать лямбду, которая будет принимать в себя строку в
        //формате “*сумма* BYN”(через пробел, вместо *сумма* вставить любое значение), а
        //выводить сумму, переведенную сразу в доллары.
        transferBYNToUSDByConsumer.accept("110 BYN");

        //Задача 5:
        //Используя Supplier написать метод, который будет возвращать введенную с консоли
        //строку задом наперед
        System.out.println(reverseInputStr.get());
    }

    public static LocalDate getYourAgeAfter100(String birthDate) {
        return LocalDate.parse(birthDate).plusYears(100);
    }

    public static void getPositiveNums(int[] array) {
        Predicate<Integer> predicateForNums = x -> x >= 0;
        for (int i : array) {
            if (predicateForNums.test(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    static Function<String, String> transferBYNToUSD = x -> {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(x);
        if(matcher.find()) {
            double moneyBYN = Double.parseDouble(matcher.group());
            return String.format("%.2f USD", moneyBYN / 3);
        }
        return "Некорректный ввод";
    };

    static Consumer<String> transferBYNToUSDByConsumer = x -> {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(x);
        if(matcher.find()) {
            double moneyBYN = Double.parseDouble(matcher.group());
            System.out.println(String.format("%.2f USD", moneyBYN / 3));
            return;
        }
        System.out.println("Некорректный ввод");
    };

    static Supplier<String> reverseInputStr = () -> {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите строку: ");
        StringBuilder str = new StringBuilder(input.nextLine());
        return str.reverse().toString();
    };
}

