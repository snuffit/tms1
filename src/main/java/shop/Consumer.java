package shop;

/**
 * @author Pstyga Stas
 * @created 20.05.2026
 */
public class Consumer implements Runnable{

    Shop shop;

    public Consumer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            shop.buyStuff(1);
        }
    }
}
