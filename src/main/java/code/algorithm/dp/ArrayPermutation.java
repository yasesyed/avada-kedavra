package code.algorithm.dp;

import java.util.Arrays;

public class ArrayPermutation {

    public static void main(String[] args) {
        permute(new String[]{"A", "B", "C"});
        System.out.println();
        permute(new Integer[]{4, 3, 2, 1});

    }

    public static <T> void permute(T[] arr) {
        permute(arr, 0);
    }

    private static <T> void permute(T[] arr, int l) {
        if (l == arr.length) {
            System.out.print(Arrays.toString(arr));
        } else {
            for (int i = l; i < arr.length; i++) {
                swap(arr, i, l);
                permute(arr, l + 1);
                swap(arr, i, l);
            }
        }
    }

    private static <T> void swap(T[] arr, int i, int l) {
        T tmp = arr[i];
        arr[i] = arr[l];
        arr[l] = tmp;
    }
}
