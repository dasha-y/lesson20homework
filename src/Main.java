import num2.BubbleSortThread;
import num2.InsertionSortThread;
import num2.SelectionSortThread;
import num3.Consumer;
import num3.Producer;
import num3.Store;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива:");
        int a = scanner.nextInt();
        System.out.println("Введите массив:");
        int[] arr = new int[a];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        Runnable runnable1 = () -> {
            int max=arr[0];
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]>max){
                    max = arr[i];
                }
            }
            System.out.println("Максемальное значение: "+ max);
        };
        Runnable runnable2 = () -> {
            int  min = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]<min){
                    min = arr[i];
                }
            }
            System.out.println("Минимальное значение: "+ min);
        };
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        try{
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Задание 2:");

        InsertionSortThread insertionSortThread = new InsertionSortThread(arr);
        SelectionSortThread selectionSortThread = new SelectionSortThread(arr);
        BubbleSortThread bubbleSortThread = new BubbleSortThread(arr);

        insertionSortThread.run();
        selectionSortThread.run();
        bubbleSortThread.run();

        try{
            insertionSortThread.join();
            selectionSortThread.join();
            bubbleSortThread.join();
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Задание *:");

        Semaphore producerSemaphore = new Semaphore(1);
        Semaphore consumerSemaphore = new Semaphore(0);
        Semaphore storeSemaphore = new Semaphore(3);

        Store store = new Store(storeSemaphore);
        Consumer consumer = new Consumer(producerSemaphore, consumerSemaphore,store);
        Producer producer = new Producer(producerSemaphore, consumerSemaphore,store);
        producer.start();
        consumer.start();

    }
}