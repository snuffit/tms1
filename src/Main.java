import java.util.Arrays;

/**
 * @author Pstyga Stas
 * @created 18.03.2026
 */
public class Main {
    public static void main(String[] args) {
        //Задача 1:
        //1.1 Создать двумерный массив, заполнить его случайными числами.
        //1.2 Добавить к каждому значению число, которое пользователь будет вводить с консоли.
        //1.3 Найти сумму всех получившихся элементов и вывести в консоль.

        int[][] dArray = makeDoubleArray(3);
        printDoubleArray(dArray);
        System.out.println();
        addNumToAllElementsInArray(dArray, 2);
        printDoubleArray(dArray);
        System.out.println();
        System.out.println(sumElementsArray(dArray));
        System.out.println();

        //Задача 2:
        //Создать программу для раскраски шахматной доски с помощью цикла. Создать
        //двумерный массив String 8х8. С помощью циклов задать элементам массива значения
        //B(Black) или W(White). При выводе результат работы программы должен быть
        //следующим:
        //W B W B W B W B
        //B W B W B W B W
        //W B W B W B W B
        //B W B W B W B W
        //W B W B W B W B
        //B W B W B W B W
        //W B W B W B W B
        //B W B W B W B W

        printCharDoubleArray(makeChessBoardArray());
        System.out.println();

        //Задача *:
        //Даны числа n и m. Создайте массив A[n][m] и заполните его змейкой
        printStringDoubleArray(makeSnakeArray(6, 5));

    }

    public static int[][] makeDoubleArray(int length) {
        int[][] dArray = new int[length][length];
        for (int i = 0; i < dArray.length; i++) {
            for (int j = 0; j < dArray[i].length; j++) {
                dArray[i][j] = (int) (Math.random() * 10);
            }
        }
        return dArray;
    }

    public static void addNumToAllElementsInArray(int[][] dArray, int num) {
        for (int i = 0; i < dArray.length; i++) {
            for (int j = 0; j < dArray[i].length; j++) {
                dArray[i][j] += num;
            }
        }
    }

    public static void printDoubleArray(int[][] dArray) {
        for (int i = 0; i < dArray.length; i++) {
            System.out.println(Arrays.toString(dArray[i]));
        }
    }

    public static int sumElementsArray(int[][] dArray) {
        int sum = 0;
        for (int i = 0; i < dArray.length; i++) {
            for (int j = 0; j < dArray[i].length; j++) {
                sum += dArray[i][j];
            }
        }
        return sum;
    }

    public static char[][] makeChessBoardArray() {
        boolean isBlack = true;
        char[][] chessBoard = new char[8][8];
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if(isBlack) {
                    chessBoard[i][j] = 'B';
                } else {
                    chessBoard[i][j] = 'W';
                }
                isBlack = !isBlack;
            }
            isBlack = !isBlack;
        }
        return chessBoard;
    }

    public static void printCharDoubleArray(char[][] dArray) {
        for (int i = 0; i < dArray.length; i++) {
            System.out.println(Arrays.toString(dArray[i]));
        }
    }

    public static void printStringDoubleArray(String[][] dArray) {
        for (int i = 0; i < dArray.length; i++) {
            System.out.println(Arrays.toString(dArray[i]));
        }
    }

    public static String[][] makeSnakeArray(int n, int m) {
        String[][] snakeArray = new String[n][m];
        int counter = 0;
        boolean isReverse = false;
        for (int i = 0; i < snakeArray.length; i++) {
            for (int j = 0; j < snakeArray[i].length; j++) {
                StringBuilder numStr = new StringBuilder();
                for (int k = 0; k <= (3 - String.valueOf(counter).toCharArray().length); k++) {
                    if(k == 3 - String.valueOf(counter).toCharArray().length) {
                        numStr.append(counter);
                        counter++;
                        continue;
                    }
                    numStr.append(" ");
                }
                if(isReverse) {
                    snakeArray[i][snakeArray[i].length - 1 - j] = numStr.toString();
                }else {
                    snakeArray[i][j] = numStr.toString();
                }
            }
            isReverse = !isReverse;
        }
        return snakeArray;
    }
}
