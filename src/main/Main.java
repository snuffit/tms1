package main;

/**
 * @author Pstyga Stas
 * @created 26.04.2026
 */
public class Main {

    public static void main(String[] args) {
        //Задача 1:
        //На вход поступает массив строк, верните Map<String, Boolean>, где каждая отдельная
        //строка является ключом, и ее значение равно true, если эта строка встречается в массиве
        //2 или более раз. Пример:
        //wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
        //wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
        //wordMultiple(["c", "c", "c", "c"]) → {"c": true}
        System.out.println(MapUtils.wordMultiple(new String[]{"a", "b", "a", "c", "b"}));
        System.out.println(MapUtils.wordMultiple(new String[]{"c", "b", "a"}));
        System.out.println(MapUtils.wordMultiple(new String[]{"c", "c", "c", "c"}));

        //Задача 2:
        //На вход поступает массив непустых строк, создайте и верните Map<String,
        //String> следующим образом: для каждой строки добавьте ее первый символ в
        //качестве ключа с последним символом в качестве значения. Пример:
        //pairs(["code", "bug"]) → {"b": "g", "c": "e"}
        //pairs(["man", "moon", "main"]) → {"m": "n"}
        //pairs(["man", "moon", "good", "night"]) → {"g": "d", "m": "n", "n": "t"}
        System.out.println(MapUtils.getFirstAndLastLetterFromWords(new String[]{"code", "bug"}));
        System.out.println(MapUtils.getFirstAndLastLetterFromWords(new String[]{"man", "moon", "main"}));
        System.out.println(MapUtils.getFirstAndLastLetterFromWords(new String[]{"man", "moon", "good", "night"}));

        //Задача *:
        //Задана строка, которая может иметь внутри себя скобки. Скобкой считается
        //любой из следующих символов — «(«, «)», «[«, «]», «{«, «}». Проверить
        //сбалансированность расстановки скобок в этой строке. Набор скобок считается
        //сбалансированной парой, если открывающая скобка "(", "[" и "{" стоит слева от
        //соответствующей закрывающей скобки ")", "]" и "} ", соответственно. Строка,
        //содержащая пары скобок, не сбалансирована, если набор заключенных в нее
        //скобок не совпадает.
        //Например, если ввод «{[(])}», пара квадратных скобок «[]» заключает в себя
        //одну несбалансированную открывающую круглую скобку «(». Аналогично, пара
        //круглых скобок «() ", заключает в себя одну несбалансированную
        //закрывающую квадратную скобку "]". Таким образом, входная строка "{[(])}"
        //несбалансированная.
        //Пример
        //() - сбалансирована
        //[()] - сбалансирована
        //{[()]} - сбалансирована
        //([{{[(())]}}]) - сбалансирована
        //{{[]()}}}} - не сбалансирована
        //{[(])} - не сбалансирована
        System.out.println(MapUtils.areBracketBalanced("()"));
        System.out.println(MapUtils.areBracketBalanced("[()]"));
        System.out.println(MapUtils.areBracketBalanced("{[()]}"));
        System.out.println(MapUtils.areBracketBalanced("([{{[(())]}}])"));
        System.out.println(MapUtils.areBracketBalanced("{{[]()}}}}"));
        System.out.println(MapUtils.areBracketBalanced("{[(])}"));
    }
}
