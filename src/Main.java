import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Object lock = new Object();
    private static volatile int num = 1;

    public static void main(String[] args) {
        //Задача 1
        //Написать приложение, которое будет вычислять и выводить значение по формуле:
        //a=4*(b+c-1)/2; b и c задаем в коде самостоятельно
        int b = 9;
        int c = 3;
        System.out.printf("%d=4*(%d+%d-1)/2\n", getNumByFormula(b, c), b, c);

        //Задача 2
        //В переменной n хранится двузначное число. Создайте программу, вычисляющую и
        //выводящую на экран сумму цифр n. Например: n =26, в результате мы должны получить 8
        //(2+6)
        //Задача 3
        //В переменной n хранится трёхзначное число. Создайте программу, вычисляющую и
        //выводящую на экран сумму цифр n. Например: n =126, в результате мы должны получить
        //9 (1+2+6)
        //Две задачи объединил в одну и немного изменил, решил усложнить и сделать интереснее
        System.out.println(unfoldNum(352353));

        //Задача 4
        //В переменной n хранится вещественное число с ненулевой дробной частью. Создайте
        //программу, округляющую число n до ближайшего целого и выводящую результат на
        //экран.
        System.out.println(roundNum(12.4));
        System.out.println(roundNum(12.5));

        //Задача 5:
        //В переменных q и w хранятся два натуральных числа. Создайте программу, выводящую
        //на экран результат деления q на w с остатком. Пример вывода программы (для случая,
        //когда в q хранится 21, а в w хранится 8): 21 / 8 = 2 и 5 в остатке.
        System.out.println(calcNumWithReminder(7, 3));

        //Задача *:
        //Написать программу которая будет менять местами значение целочисленных
        //переменных. Пример:
        //int a = 1; int b = 2;
        //код (ваше решение)
        //sout(a); //выведет 2
        //sout(b); //выведет 1
        int numF = 15;
        int numS = 6;
        System.out.println(numF + " и " + numS);
        numF += numS;
        numS = numF - numS;
        numF -= numS;
        System.out.println(numF + " и " + numS);

    }

    public static int getNumByFormula(int b, int c) {
        return 4 * (b + c - 1) / 2;
    }

    public static String unfoldNum(int num) {
        StringBuilder resultStr = new StringBuilder(num + " = ");
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            resultStr.append(chars[i]);
            for (int j = 0; j < chars.length - i - 1; j++) {
                resultStr.append(0);
            }
            if (chars.length - (i + 1) > 0) {
                resultStr.append(" + ");
            }
        }
        return String.valueOf(resultStr);
    }

    public static int roundNum(double num) {
        int resultNum = (int) (num / 1);
        if ((num % 1) * 10 >= 5) {
            resultNum++;
        }
        return resultNum;
    }

    public static String calcNumWithReminder(int q, int w) {
        return String.format("%d / %d = %d и в остатке %d", q, w, (q / w), (q % w));
    }
}