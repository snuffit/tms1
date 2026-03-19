package credit_card;

/**
 * @author Pstyga Stas
 * @created 18.03.2026
 */
public class CreditCard {
    //Создать класс credit_card.CreditCard c полями номер счета, текущая сумма на счету. Добавьте
    //метод, который позволяет начислять сумму на кредитную карточку. Добавьте метод,
    //который позволяет снимать с карточки некоторую сумму. Добавьте метод, который
    //выводит текущую информацию о карточке.

    private String accountNum;
    private int amounts;

    public CreditCard(String accountNum, int amounts) {
        this.amounts = amounts;
        this.accountNum = accountNum;
    }

    public void addToAmount(int money) {
        if (money > 0) {
            this.amounts += money;
        }else {
            System.out.println("Нельзя положить отрицательную сумму");
        }
    }

    public void withdrawFromAmount(int money) {
        if (this.amounts >= money) {
            this.amounts -= money;
        } else {
            System.out.println("Сумма на счету меньше запрашиваемой");
        }
    }

    @Override
    public String toString() {
        return "CreditCard: " +
                "accountNum='" + accountNum + '\'' +
                ", amounts=" + amounts;
    }
}
