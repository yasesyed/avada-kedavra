package code.example.java;

import java.util.Arrays;

public class Sorting {

    public static <T extends Comparable> void insertionSort(T... a) {
        /*
        int n = a.length;
        int i = 1;
        while (i < n) {
            int j = i;
            T t = a[j];
            while (j > 0 && t.compareTo(a[j-1]) ==-1) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = t;
            i++;
        }*/

        for (int i = 1, j; i < a.length; i++) {
            T t = a[i];
            for ( j = i ; j > 0 && t.compareTo(a[j-1]) == -1 ;a[j] = a[j-1], j--);
            a[j] = t;
        }
    }


    public static void main(String[] args) {
        Integer[] a = {3, 5, 2, 4, 1};
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }

}


