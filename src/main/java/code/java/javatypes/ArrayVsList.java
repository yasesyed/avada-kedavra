package code.java.javatypes;

import java.util.*;

public class ArrayVsList {

    public static void main(String[] args) {
        Integer [] integers = new Integer[] {1,2,3};

        List<Integer> integerList = Arrays.asList(integers);

        integerList.set(1, 10);
        //System.out.println(integerList.get(0));
        System.out.println(integerList.toString());
        System.out.println(Arrays.toString(integers));
        Vector<Integer> vector = new Vector<>(10);
        vector.add(null);
        vector.add(null);
    }
}
