package code.example.algorithm.matrix;

public class PrintSpiralMatrix {

    private static void printSpiralMatrix(Integer mat[][], int x, int y, int m, int n) {

        if (x < m || y < n) {
            int i;

            for (i = y; i < n; i++) {
                System.out.print(mat[x][i] + ",");
            }
            for (i = x + 1; i < m; i++) {
                System.out.print(mat[i][n - 1] + ",");
            }
            for (i = n - 2; i >= y; i--) {
                System.out.print(mat[m - 1][i] + ",");
            }

            for (i = m - 2; i > x; i--) {
                System.out.print(mat[i][y] + ",");
            }
            printSpiralMatrix(mat, x + 1, y + 1, m - 1, n - 1);
        }

    }

    public static void main(String[] args) {

        Integer[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
        };

        /*int [][] mat = new int[4][];
        mat[0] = new int[1];
        mat[1] = new int[2];
        mat[2] = new int[3];
        mat[3] = new int[4];
        mat[4] = new int[5];*/

        printSpiralMatrix(mat, 0, 0, mat.length, mat[0].length);

    }
}
