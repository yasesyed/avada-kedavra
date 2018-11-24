package code.algorithm.dp;


/**
 * Given and integer N and a set of coins S, find the number of ways to make the change of N.
 * We have infinite supply of each coin, can use multiple coin of Order or coins does't matter.
 * <p>
 * i.e {1,2} will be same as {2,1}
 * <p>
 * e.g
 * N = 5 and S = {1,2,3}
 * <p>
 * Solution = 5
 * <p>
 * explanation:
 * {1,1,1,1,1}
 * {1,1,1,2}
 * {1,1,3}
 * {1,2,2}
 * {2,3}
 */
public class CoinChange {
    private static final int[] coinSet = {1, 5, 10, 20};


    public static void main(String[] args) {
        System.out.println(makeChange(1000));
        System.out.println(makeChangeDP(1000));
    }

    private static int makeChange(int n) {
        return makeChangeUtil(n, coinSet.length);
    }

    private static int makeChangeUtil(int n, int d) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        if (d <= 0)
            return 0;
        return makeChangeUtil(n - coinSet[d - 1], d) + makeChangeUtil(n, d - 1);
    }

    private static int makeChangeDP(int n) {
        int[][] dp = new int[n + 1][coinSet.length + 1];
        return makeChangeDPUtil(n, coinSet.length, dp);
    }

    private static int makeChangeDPUtil(int n, int i, int[][] dp) {
        if (n == 0)
            return 1;
        if (n < 0 || i <= 0)
            return 0;
        if (dp[n][i] != 0)
            ;
        else
            dp[n][i] = makeChangeDPUtil(n - coinSet[i - 1], i, dp) + makeChangeDPUtil(n, i - 1, dp);
        return dp[n][i];
    }


}
