package main;

import java.util.HashSet;

/**
 * @author Pstyga Stas
 * @created 06.04.2026
 */
public class StringHelper {

    public static void findMaxAndMinWord(String string) {
        System.out.println("Строка: " + string);
        String[] words = string.split("[\\s\\p{Punct}]+");
        int maxWord = 0;
        int minWord = 0;
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > words[maxWord].length()) maxWord = i;
            if (words[i].length() < words[minWord].length()) minWord = i;
        }
        System.out.println("Самое большое слово: " + words[maxWord]);
        System.out.println("Самое маленькое слово: " + words[minWord]);
    }

    public static void sort(String string) {
        System.out.println("Строка была: " + string);
        String[] words = string.split("[\\s\\p{Punct}]+");
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words.length - 1 - i; j++) {
                if(words[j].length() > words[j + 1].length()) replaceWords(words, j, j + 1);
            }
        }
        System.out.print("Отсортированная строка: ");
        printArray(words);
    }

    public static void findBelowAvgWords(String string) {
        System.out.println("Строка: " + string);
        String[] words = string.split("[\\s\\p{Punct}]+");
        int avgWordLength = getAvgLengthWords(words);
        System.out.println("Средняя длина слова: " + avgWordLength);
        System.out.print("Слова длиной меньше средней: ");
        StringBuilder resultStr = new StringBuilder("");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() <= avgWordLength) {
                resultStr.append(words[i] + " - " + words[i].length() + ", ");
            }
        }
        resultStr.delete(resultStr.length() - 2, resultStr.length())
                .insert(resultStr.length(), ".");
        System.out.print(resultStr + "\n");
    }

    public static void findWordWithUniqueLetters(String string) {
        System.out.println("Строка: " + string);
        String[] words = string.split("[\\s\\p{Punct}]+");
        for (String word : words) {
            HashSet<Character> set = new HashSet<>();
            for (char c : word.toCharArray()) {
                set.add(c);
            }
            if(set.size() == word.length()) {
                System.out.println("Слово с уникальными буквами: " + word);
                return;
            }
        }
    }

    public static void duplicateAllLetters(String string) {
        System.out.println(string);
        char[] letters = new char[string.length() * 2];
        for (int i = 0, j = 0; i < letters.length; i += 2, j++) {
            letters[i] = string.toCharArray()[j];
            letters[i + 1] = string.toCharArray()[j];
        }
        System.out.println(String.copyValueOf(letters));
    }

    public static void isPalindrome(String string, int index) {
        String[] words = string.split("[\\s\\p{Punct}]+");
        if(index < 0 || index >= words.length) {
            System.out.println("Некорректный индекс");
            return;
        }
        System.out.println("Строка: " + string);
        char[] wordChars = words[index].toCharArray();
        for (int i = 0; i < wordChars.length; i++) {
            if(wordChars[i] != wordChars[wordChars.length - 1 - i]) {
                System.out.println("Слово '" + words[index] + "' не палиндром");
                return;
            }
        }
        System.out.println("Слово '" + words[index] + "' палиндром");
    }

    private static int getAvgLengthWords(String[] strings) {
        int sum = 0;
        for (String string : strings) {
            sum += string.length();
        }
        return Math.round((float) sum / strings.length);
    }

    private static void replaceWords(String[] words, int firstIndex, int secondIndex) {
        String bufferStr = words[firstIndex];
        words[firstIndex] = words[secondIndex];
        words[secondIndex] = bufferStr;
    }

    public static void printArray(String[] words) {
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i]);
            if(i < words.length - 1) System.out.print(", ");
        }
        System.out.print("\n");
    }

    public static void makeRow() {
        System.out.println("-------------------------------------------------");
    }
}
