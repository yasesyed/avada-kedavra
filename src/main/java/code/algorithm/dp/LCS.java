package code.algorithm.dp;


/**
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * <p>
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 * So a string of length n has 2^n different possible subsequences.
 */
public class LCS {

    private static int lcs(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) {
            return 0;
        }

        if (s1.charAt(0) == s2.charAt(0)) {
            return 1 + lcs(s1.substring(1), s2.substring(1));
        } else
            return Integer.max(lcs(s1, s2.substring(1)), lcs(s1.substring(1), s2));
    }

    private static int lcsDP(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m][n];
        int result = lcsDPUtil(s1, s2, 0, 0, dp);
        //printDp(dp);
        return result;

    }
    private static int lcsDPUtil(String s1, String s2, int i, int j, int[][] dp) {

        if (i >= s1.length() || j >= s2.length()) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + lcsDPUtil(s1, s2, i + 1, j + 1, dp);

        } else
            dp[i][j] = Integer.max(lcsDPUtil(s1, s2, i + 1, j, dp), lcsDPUtil(s1, s2, i, j + 1, dp));

        return dp[i][j];

    }
    private static void printDp(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        System.out.println(lcs("ABCDGH", "AEDFHR"));
        System.out.println(lcsDP("ABCDGH", "AEDFHR"));
        System.out.println(lcs("AGGTAB", "GXTXAYB"));
        System.out.println(lcsDP("AGGTAB", "GXTXAYB"));
    }


}
