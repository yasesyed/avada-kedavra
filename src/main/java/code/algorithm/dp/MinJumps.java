package code.algorithm.dp;

/**
 * Given an array of integers where each element represents the max number of steps that can be made forward from that element.
 * Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element).
 * If an element is 0, then cannot move through that element.
 * <p>
 * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
 * Output: 3 (1-> 3 -> 8 ->9)
 */


public class MinJumps {

    public static void main(String[] args) {
        System.out.println(minJumpsDP(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}));
        //System.out.println(minJumps(new int[] {1, 3, 5}));

    }

    private static int minJumps(int[] arr) {
        return minJumps(arr, 0);
    }

    private static int minJumps(int[] arr, int i) {
        if (i >= arr.length)
            return 0;

        if (arr[i] == 0)
            return Integer.MAX_VALUE;
        int minJumps = Integer.MAX_VALUE;
        for (int j = 1; j < arr.length && j <= arr[i]; j++) {
            int jumps = minJumps(arr, i + j);
            minJumps = Integer.min(minJumps, jumps);
        }
        return minJumps + 1;
    }

    private static int minJumpsDP(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        return minJumpsDP(arr, 0, dp);
    }

    private static int minJumpsDP(int[] arr, int i, int[] dp) {

        if (i >= arr.length)
            return 0;

        if (arr[i] == 0)
            return Integer.MAX_VALUE;

        if (dp[i] != Integer.MAX_VALUE) {
            return dp[i];
        } else {
            for (int j = 1; j < arr.length && j <= arr[i]; j++) {
                int jumps = minJumps(arr, i + j);
                dp[i] = Integer.min(dp[i], jumps);
            }
        }
        return (dp[i] += 1);
    }
}
