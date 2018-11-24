package code.java.concurrency;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurencyExample {

    public static void main(String[] args) {

        Runnable task = () -> {
            System.out.println("inside '" + Thread.currentThread().getName() + "' Thread");
            try {
                TimeUnit.SECONDS.sleep(1);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        task.run(); // normal method call

        Class<?> c = task.getClass();
        System.out.println(Arrays.toString(c.getMethods()));

        new Thread(task).start(); //starts a new thread and execute run method of task in new thread
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(task);

        System.exit(0);

    }

}
