package code.java;

import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(10, (Integer a, Integer b) -> {
            return (b > a) ? 1 : -1;
        });
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(5);
        pq.add(4);


        for (Integer i = pq.size(); i > 0; i--) {
            System.out.println(pq.poll());
        }
    }
}
