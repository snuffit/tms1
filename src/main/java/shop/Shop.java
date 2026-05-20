package shop;

/**
 * @author Pstyga Stas
 * @created 20.05.2026
 */
public class Shop {

    int stuffCount = 0;
    final int MAX_STUFF = 3;

    public synchronized void addStuff(int count) {
        while (stuffCount + count > MAX_STUFF) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stuffCount += count;
        notify();
        System.out.println("Товар добавлен - осталось " + this.stuffCount);
    }

    public synchronized void buyStuff(int count) {
        while (stuffCount < count) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stuffCount -= count;
        notify();
        System.out.println("Куплен товар - осталось " + this.stuffCount);
    }
}
