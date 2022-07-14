import java.util.Arrays;

/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
class Solution {
    int[][] dp;

    public int helper(int[] prices, int pos, boolean state) {
        if (pos >= prices.length) return 0;
        if (dp[pos][state ? 0 : 1] != Integer.MIN_VALUE) return dp[pos][state ? 0 : 1];
        if (state) {
            int a = helper(prices, pos + 1, !state) - prices[pos];
            int b = helper(prices, pos + 1, state);
            dp[pos][0] = Math.max(a, b);
        } else {
            int a = helper(prices, pos + 2, !state) + prices[pos];
            int b = helper(prices, pos + 1, state);
            dp[pos][1] = Math.max(a, b);
        }
        return dp[pos][state ? 0 : 1];
    }

    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, Integer.MIN_VALUE));
        int res = helper(prices, 0, true);
        return res;
    }
}
// @lc code=end

