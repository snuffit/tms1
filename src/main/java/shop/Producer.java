package shop;

/**
 * @author Pstyga Stas
 * @created 20.05.2026
 */
public class Producer implements Runnable{

    Shop shop;

    public Producer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            shop.addStuff(1);
        }
    }
}
