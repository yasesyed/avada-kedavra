package code.example.java.concurrency;

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

        task.run();

        new Thread(task).start();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(task);


    }

}
