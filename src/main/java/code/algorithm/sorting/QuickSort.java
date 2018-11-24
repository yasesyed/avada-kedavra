package code.algorithm.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int l, int h) {
        if (l < h) {
            int p = partition(arr, l, h);
            sort(arr, l, p - 1);
            sort(arr, p + 1, h);
        }
    }

    private static int partition(int[] arr, int l, int h) {
        int pivot = arr[h];
        int i = l;
        for (int j = l; j < h; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, h);
        System.out.println(pivot +":"+ Arrays.toString(arr));
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 3, 2, 1, 9, 8, 3};
        sort(arr);
        //System.out.println(Arrays.toString(arr));
        ;
    }
}
