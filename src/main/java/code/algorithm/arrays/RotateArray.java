package code.algorithm.arrays;

public class RotateArray {

    public static void main(String[] args) {
        Integer a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        new RotateArray().rotate(a, a.length, 3);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }

    private <T> void rotate(T a[], Integer N, Integer D) {
        int j = 0;
        T temp = a[0];
        for (int i = 0; i < N; i++) {

            if (j - D < 0) {
                temp = swap(a, temp, N + j - D);
                j = N + j - D;
            } else {
                temp = swap(a, temp, j - D);
                j = j - D;
            }
        }
    }

    private <T> T swap(T a[], T temp, int j) {
        T temp2 = a[j];
        a[j] = temp;
        return temp2;
    }
}
