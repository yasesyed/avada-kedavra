package code.algorithm.dp;

import java.util.Scanner;

public class PartitionArray {

    public static void main(String args[]) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N, K, Q;
            N = sc.nextInt();
            K = sc.nextInt();
            Q = sc.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            solveUtil(A, N, K, Q);
        }
    }

    private static void printDP(int[][] dp) {
        for (int i = 0; i < dp[0].length; i++)
            System.out.println(java.util.Arrays.toString(dp[i]));
    }

    public static int[][] initDP(int N, int K) {
        int[][] dp = new int[N][K];
        // for (int i = 0; i < N; i++) {
        //      algo.dp[i] = new int[K];
        // }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        return dp;
    }

    public static boolean solveUtil(int[] A, int N, int K, int Q) {
        int[][] dp = initDP(N, K);
        dp[0][0] = A[0];
        boolean result = solve(A, dp, N, K, Q, 1, 0);
        //printDP(algo.dp);
        return result;
    }

    public static boolean solve(int[] A, int[][] dp, int N, int K, int Q, int i, int k) {
        if (i == N && k == K) {
            return true;
        }
        if (i == N || k == K) {
            return false;
        }
        dp[i][k] = Integer.max(A[i], dp[i - 1][k]);
        boolean result = solve(A, dp, N, K, Q, i + 1, k);
        if (result) {
            return result;
        }
        dp[i][k] = Integer.MIN_VALUE;
        return solve(A, dp, N, K, Q, i, k + 1);
    }
}
