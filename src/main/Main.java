package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Pstyga Stas
 * @created 02.05.2026
 */
public class Main {

    public static void main(String[] args) {
        //Задача 1:
        //Создать коллекцию класса ArrayList наполнить ее элементами типа Integer. С помощью
        //Stream'ов:
        //- Удалить дубликаты
        //- Оставить только четные элементы
        //- Вывести сумму оставшихся элементов в стриме
        int sumOfNums = List.of(43, 12, 44, 4, 23, 2, 0, 2, 43, 44 )
                .stream()
                .distinct()
                .filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue)
                .peek(x -> System.out.printf("%d ", x))
                .sum();
        System.out.println("\n" + sumOfNums);

        //Задача *:
        //Создать набор данных в формате id-name, сохраненный в Map. Необходимо отобрать из
        //этого набора только те данные, id которых попадает в числовой диапазон 1/2/5/8/9/13.
        //Среди отобранных значений отобрать только те, которые имеют нечетное количество
        //букв в имени. После чего вернуть список List имен, записанных буквами задом наперед.

        List<String> names = Map.of(1, "John",
                4, "Tolik",
                3, "Gosha",
                5, "Vadim",
                9, "Monkeyk")
                .entrySet()
                .stream()
                // здесь будет эффективнее вынести доступные id в отдельный Set, но мне показалось это прикольным, поэтому оставил в рамках дз
                .filter(x -> Set.of(1, 2, 5, 8, 9, 13).contains(x.getKey()))
                .filter(x -> x.getValue().length() % 2 != 0)
                .map(x -> new StringBuilder(x.getValue()).reverse().toString())
                .toList();
        System.out.println(names);
    }
}
