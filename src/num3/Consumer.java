package num3;

import java.util.concurrent.Semaphore;

public class Consumer extends Thread{
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;
    private Store store;

    public Consumer(Semaphore producerSemaphore, Semaphore consumerSemaphore, Store store) {
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try{
                consumerSemaphore.acquire();
                store.sellProduct();
                producerSemaphore.release();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
