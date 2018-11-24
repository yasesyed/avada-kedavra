package code.algorithm.dp;


/**
 * Given an ammount n and number of coins denominations d1 < d2 < . . . < dm, return the change for the amount using
 * minimum number of coins.
 */

public class MakeChange {
    private static int[] denomination = new int[]{1, 2, 5};

    public static void main(String[] args) {
        MakeChange makeChange = new MakeChange();
        System.out.println(makeChange.makeChange(20));
        System.out.println(makeChange.makeChangeV2(20));

        //System.out.println(makeChange.makeChangeDPTopDown(50));

    }

    private int makeChangeV2(int n) {
        return makeChangeV2Util(n, denomination.length - 1);
    }

    private int makeChangeV2Util(int n, int i) {
        if (n < 0 || i < 0) {
            return Integer.MAX_VALUE - 1;
        }

        if (n == 0) {
            return 0;
        }
        return Integer.min(1 + makeChangeV2Util(n - denomination[i], i), makeChangeV2Util(n, i - 1));
    }

    public int makeChange(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return Integer.MAX_VALUE;
        }
        int q = Integer.MAX_VALUE;
        for (int i = 0; i < denomination.length; i++) {
            if (n >= denomination[i]) {
                q = Integer.min(q, 1 + makeChange(n - denomination[i]));
            }
        }
        return q;
    }

    public int makeChangeDPTopDown(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        return makeChangeDpTopDownHelper(n, dp);
    }

    private int makeChangeDpTopDownHelper(int n, int[] dp) {

        if (n == 0) {
            return 0;
        }
        if (dp[n] != Integer.MIN_VALUE) {
            return dp[n];
        }

        int q = Integer.MAX_VALUE;
        for (int i = 0; i < denomination.length && n >= denomination[i]; i++) {
            q = Integer.min(q, makeChangeDpTopDownHelper(n - denomination[i], dp));
        }
        return (dp[n] = q + 1);
    }

}
