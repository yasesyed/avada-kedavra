package code.java;

import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 4, 3, 5, 1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (Integer i : list) {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                }

            }
        }).start();

        list.sort((x, y) -> {return  x-y;});

        new Thread(() -> {
            Integer i = null;
            for (Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
                i=it.next();
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }).start();


    }

}
