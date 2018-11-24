package code.algorithm.dp;


/**
 * given n items of known weights w1, . . . , wn and values v1, . . . , vn and a knapsack of capacity W,
 * find the most valuable subset of the items that fit into the knapsack.
 */

public class KnapsackProblem {

    private int[] itemWeights = {1, 3, 2, 5, 3};

    private int[] itemPrices = {2, 4, 6, 3, 1};

    public KnapsackProblem() {
    }

    public KnapsackProblem(int[] itemWeights, int[] itemPrices) {
        this.itemPrices = itemPrices;
        this.itemWeights = itemWeights;
    }

    public static void main(String[] args) {
        KnapsackProblem knapsackProblem = new KnapsackProblem();
        for (int i = 0; i <= 5; i++)
            System.out.println(i + ":" + knapsackProblem.getMaxValue(i));
        //System.out.println(knapsackProblem.getMaxValue(2));
    }

    public int getMaxValue(int sackCapacity) {
        return getMaxValueHelper(sackCapacity, itemWeights.length - 1);
    }

    private int getMaxValueHelper(int sackCapacity, int i) {
        if (i < 0 || sackCapacity < 0) {
            return 0;
        }

        if (itemWeights[i] > sackCapacity) {
            return getMaxValueHelper(sackCapacity, i - 1);
        }

        return Integer.max(
                getMaxValueHelper(sackCapacity, i - 1),
                getMaxValueHelper(sackCapacity - itemWeights[i], i - 1) + itemPrices[i]);
    }
}
