package atm;

/**
 * @author Pstyga Stas
 * @created 18.03.2026
 */
public class ATM {
    //Создать класс, описывающий банкомат. Набор купюр, находящихся в банкомате, должен
    //задаваться тремя свойствами: количеством купюр номиналом 20, 50 и 100. Сделать
    //метод для добавления денег в банкомат. Сделать функцию, снимающую деньги, которая
    //принимает сумму денег, а возвращает булевое значение - успешность выполнения
    //операции. При снятии денег, функция должна распечатывать каким количеством купюр
    //какого номинала выдаётся сумма. Создать конструктор с тремя параметрами -
    //количеством купюр каждого номинала.

    private int cashValueTwenty;
    private int cashValueFifty;
    private int cashValueHungered;

    public ATM(int cashValueTwenty, int cashValueFifty, int cashValueHungered) {
        this.cashValueTwenty = cashValueTwenty;
        this.cashValueFifty = cashValueFifty;
        this.cashValueHungered = cashValueHungered;
    }

    public void addCash(int cashValueTwenty, int cashValueFifty, int cashValueHungered) {
        this.cashValueTwenty += cashValueTwenty;
        this.cashValueFifty += cashValueFifty;
        this.cashValueHungered += cashValueHungered;
    }

    public boolean withdrawCash(int cash) {
        //Как по мне, выглядит не очень, но это та логика, которую я придумал сам
        int remains = cash;
        int cashValueTwenty = 0;
        int cashValueFifty = 0;
        int cashValueHungered = 0;
        if (remains / 100 > 0) {
            cashValueHungered = remains / 100;
            remains -= cashValueHungered * 100;
        }
        if (remains % 2 != 0 && remains >= 50) {
            cashValueFifty = 1;
            remains -= 50;
        }
        if (remains / 20 > 0) {
            cashValueTwenty = remains / 20;
            remains -= cashValueTwenty * 20;
        }
        if (remains == 0 &&
        this.cashValueTwenty > cashValueTwenty &&
        this.cashValueFifty > cashValueFifty &&
        this.cashValueHungered > cashValueHungered) {
            this.cashValueTwenty -= cashValueTwenty;
            this.cashValueFifty -= cashValueFifty;
            this.cashValueHungered -= cashValueHungered;
            System.out.println("Запрошено " + cash);
            System.out.printf("Выдано 100 = %d, 50 = %d, 20 = %d\n",
                    cashValueHungered, cashValueFifty, cashValueTwenty);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "ATM: " +
                "cashValueTwenty=" + cashValueTwenty +
                ", cashValueFifty=" + cashValueFifty +
                ", cashValueHungered=" + cashValueHungered;
    }
}
