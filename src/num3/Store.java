package num3;

import java.util.concurrent.Semaphore;

public class Store {
    private Semaphore storeSemaphore;

    public Store(Semaphore storeSemaphore) {
        this.storeSemaphore = storeSemaphore;
    }
    public void addProduct() throws InterruptedException {
        storeSemaphore.acquire();
        System.out.println("Производитель произвел продукт");
    }
    public void sellProduct() throws InterruptedException {
        storeSemaphore.release();
        System.out.println("Покупатель купил продукт");
    }
}
