package code.example.java;

/**
 * Created by syed.yaser on 29/03/17.
 */

public class LockExample {

    public static Counter counter = new Counter();

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++ )
                    System.out.println("Thread: " + Thread.currentThread().getName() + " Counter: " + counter.getCounter());
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}

class Counter {

    private Integer counter = 1;

    public Integer  getCounter() {
        return counter++;
    }
}
