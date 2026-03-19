import atm.ATM;
import credit_card.CreditCard;

/**
 * @author Pstyga Stas
 * @created 18.03.2026
 */
public class Main {
    public static void main(String[] args) {
        //Задача 1:
        //Создать класс credit_card.CreditCard c полями номер счета, текущая сумма на счету. Добавьте
        //метод, который позволяет начислять сумму на кредитную карточку. Добавьте метод,
        //который позволяет снимать с карточки некоторую сумму. Добавьте метод, который
        //выводит текущую информацию о карточке. Напишите программу, которая создает три
        //объекта класса credit_card.CreditCard у которых заданы номер счета и начальная сумма.
        //Тестовый сценарий для проверки: Положите деньги на первые две карточки и снимите с
        //третьей. Выведите на экран текущее состояние всех трех карточек.

        CreditCard fCard = new CreditCard("13132354", 100);
        CreditCard sCard = new CreditCard("32523534", 890);
        CreditCard tCard = new CreditCard("16792354", 300);
        fCard.addToAmount(10);
        sCard.addToAmount(34);
        tCard.withdrawFromAmount(300);
        System.out.println(fCard);
        System.out.println(sCard);
        System.out.println(tCard);
        System.out.println();

        //Задача *:
        //Создать класс, описывающий банкомат. Набор купюр, находящихся в банкомате, должен
        //задаваться тремя свойствами: количеством купюр номиналом 20, 50 и 100. Сделать
        //метод для добавления денег в банкомат. Сделать функцию, снимающую деньги, которая
        //принимает сумму денег, а возвращает булевое значение - успешность выполнения
        //операции. При снятии денег, функция должна распечатывать каким количеством купюр
        //какого номинала выдаётся сумма. Создать конструктор с тремя параметрами -
        //количеством купюр каждого номинала.

        ATM atm = new ATM(10, 10, 10);
        System.out.println(atm);
        atm.addCash(0, 1, 3);
        System.out.println(atm);
        System.out.println();
        if(atm.withdrawCash(180)){
            System.out.println("Успешно сняты деньги");
        }else {
            System.out.println("Что-то пошло не так");
        }
        System.out.println();
        System.out.println(atm);
    }
}
