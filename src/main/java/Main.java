import shop.Consumer;
import shop.Producer;
import shop.Shop;
import utils.*;

/**
 * @author Pstyga Stas
 * @created 19.05.2026
 */
public class Main {
    public static void main(String[] args) {
       //Задача 1:
        //Пользователь вводит с клавиатуры значение в массив. После чего запускаются два
        //потока. Первый поток находит максимум в массиве, второй — минимум. Результаты
        //вычислений возвращаются в метод main().
        int[] nums = new int[]{3, 4, 2, 6, -1, 22, 13};
        Thread minFinder = new Thread(new MinNumFinder(nums));
        Thread maxFinder = new Thread(new MaxNumFinder(nums));
        minFinder.start();
        maxFinder.start();

        //Задача 2:
        //Сортировка массива цифр в нескольких потоках различными алгоритмами:
        // сортировка вставками;
        // сортировка выбором;
        // сортировка пузырьком.
        //Каждый вид сортировки должен запускаться в отдельном потоке. После вывести
        //результат отсортированных массивов в консоль.
        Thread bubleSort = new Thread(new BubbleSort(nums));
        Thread insertSort = new Thread(new InsertionSort(nums));
        Thread selectSort = new Thread(new SelectionSort(nums));
        bubleSort.start();
        insertSort.start();
        selectSort.start();

        //Задача *:
        //Имеются сущности Магазин, Производитель, Покупатель. Цель задачи сделать так чтобы
        //производитель произвел 5 единиц продукта, а покупатель их купил. Пока производитель
        //не произвел продукт, покупатель не может его купить. При этом одновременно в магазине
        //может находиться не более 3 товаров.
        Shop shop = new Shop();
        Thread producer = new Thread(new Producer(shop));
        Thread consumer = new Thread(new Consumer(shop));
        producer.start();
        consumer.start();
    }
}
