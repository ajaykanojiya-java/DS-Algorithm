package practiceset.dp;

/*
Given an integer array coins[ ] representing different denominations of currency and an integer sum. We need to find the number of ways we can make sum by using different combinations from coins[ ].
Note: Assume that we have an infinite supply of each type of coin. Therefore, we can use any coin as many times as we want.

Examples:

Input: sum = 4, coins[] = [1, 2, 3]
Output: 4
Explanation: There are four solutions: [1, 1, 1, 1], [1, 1, 2], [2, 2] and [1, 3]

Input: sum = 10, coins[] = [2, 5, 3, 6]
Output: 5
Explanation: There are five solutions:
[2, 2, 2, 2, 2], [2, 2, 3, 3], [2, 2, 6], [2, 3, 5] and [5, 5]
 */
import java.util.Arrays;
import java.util.List;

public class CoinChangeCountWaystoMakeSum {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 4;
        System.out.println(countWays(coins, sum));
        printAllSolutions(coins, coins.length, sum, new java.util.ArrayList<>());
        System.out.println(count(coins, sum));
    }

    static int countWays(int[] coins, int sum) {
        int n = coins.length;
        return countRecur(coins, n, sum);
    }

    //Using Recursion - O(2^sum) time and O(sum) space [Naive Approach]
    // T(n) = O(2^n) where n is the number of coins. In the worst case, we have two choices (include or exclude) for each coin, leading to a binary tree of height n.
    static int countRecur(int[] coins, int n, int sum) {

        // If sum is 0 then there is 1 solution
        if (sum == 0) return 1;

        // If sum is less than 0 then no solution exists
        if (sum < 0 || n == 0) return 0;

        // count is sum of solutions
        // (i) including coins[n-1] (don't subtract length of coins array because we can use the same coin multiple times)
        // (ii) excluding coins[n-1] (subtract length of coins array because we are not including the coin)
        // If the last coin is greater than the sum, then ignore it and recur for remaining coins (n - 1) and sum
        return countRecur(coins, n, sum - coins[n - 1]) +
                countRecur(coins, n - 1, sum);
    }

    //[Expected Approach 1] Using Top-Down DP (Memoization) - O(sum*n) time and O(sum*n) space
    static int count(int[] coins, int sum) {
        int[][] dp = new int[coins.length][sum + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return countRecur(coins, coins.length, sum, dp);
    }

    // T(n) = O(sum*n) where n is the number of coins and sum is the target sum. We are solving each subproblem (defined by a unique combination of n and sum) at most once, and there are n*sum such subproblems.
    // Space Complexity: O(sum*n) for the memoization table and O(sum) for the recursion stack in the worst case, leading to a total of O(sum*n) space complexity.
    // If the subproblem is previously calculated then simply return the result. Otherwise, calculate the result and store it in the dp table before returning it.
    // If the last coin is greater than the sum, then ignore it and recur for remaining coins (n - 1) and sum
    static int countRecur(int[] coins, int n, int sum, int[][] dp) {

        // If sum is 0 then there is 1 solution
        if (sum == 0) return 1;

        if (sum < 0 || n == 0) return 0;

        // If the subproblem is previously calculated then
        // simply return the result
        if (dp[n-1][sum] != -1) return dp[n-1][sum];

        // count is sum of solutions (i)
        // including coins[n-1] (ii) excluding coins[n-1]
        return dp[n-1][sum] =
                countRecur(coins, n, sum - coins[n - 1], dp) +
                        countRecur(coins, n - 1, sum, dp);
    }




    // T(n) = O(2^n) where n is the number of coins. In the worst case, we have two choices (include or exclude) for each coin, leading to a binary tree of height n.
    static void printAllSolutions(int[] coins, int n, int sum, List<Integer> current) {
        // If sum is 0 then print the current combination
        if (sum == 0) {
            System.out.println(current);
            return;
        }

        // If sum is less than 0 then no solution exists
        if (sum < 0 || n == 0) return;

        // Include the coin and recur for the same coin (since we can use the same coin multiple times)
        current.add(coins[n - 1]);
        printAllSolutions(coins, n, sum - coins[n - 1], current);
        current.remove(current.size() - 1); // Backtrack

        // Exclude the coin and recur for remaining coins
        printAllSolutions(coins, n - 1, sum, current);
    }
}
