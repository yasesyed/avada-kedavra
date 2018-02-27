package code.example.java;

/**
 * Created by syed.yaser on 29/03/17.
 */
public class WaitAndNotifyDemo {
    static Object monitor = new Object();

    public static void main(String[] args) throws InterruptedException {

        Runnable waiter = () -> {
                synchronized (monitor) {
                    try {
                        System.out.printf("Thread %s is waiting...\n", Thread.currentThread().getName());
                        monitor.wait();
                        System.out.printf("Thread %s is notified...\n", Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        };

        Runnable notifier = () -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (monitor) {
                System.out.printf("Thread %s is notifying waiting threads...\n", Thread.currentThread().getName());
                monitor.notifyAll();
                try {
                    Thread.sleep(10000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(waiter);
        Thread t2 = new Thread(waiter);
        Thread t3 = new Thread(notifier);
        Thread t4 = new Thread(notifier);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}


