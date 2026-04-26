package main;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pstyga Stas
 * @created 26.04.2026
 */
public class MapUtils {

    public static Map<String, Boolean> wordMultiple(String[] words) {
        Map<String, Boolean> resultMap = new HashMap<>();
        for (String word : words) {
            resultMap.put(word, resultMap.containsKey(word));
        }
        return resultMap;
    }

    public static Map<String, String> getFirstAndLastLetterFromWords(String[] words) {
        Map<String, String> resultMap = new HashMap<>();
        for (String word : words) {
            resultMap.put(String.valueOf(word.toCharArray()[0]), String.valueOf(word.toCharArray()[word.length() - 1]));
        }
        return resultMap;
    }

    public static boolean areBracketBalanced(String str) {
        Map<Character, Character> matchingBrackets = new HashMap<>();
        matchingBrackets.put(')', '(');
        matchingBrackets.put(']', '[');
        matchingBrackets.put('}', '{');
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty() || stack.pop() != matchingBrackets.get(ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
