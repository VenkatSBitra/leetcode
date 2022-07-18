import java.util.Arrays;

/*
 * @lc app=leetcode id=375 lang=java
 *
 * [375] Guess Number Higher or Lower II
 */

// @lc code=start
class Solution {
    private int[][] dp;

    public int helper(int l, int r) {
        if (l >= r) return 0;
        if (dp[l][r] != -1) return dp[l][r];
        int res = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            res = Math.min(res, i + Math.max(helper(l, i - 1), helper(i + 1, r)));
        }
        dp[l][r] = res;
        return res;
    }

    public int getMoneyAmount(int n) {
        dp = new int[n + 1][n + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return helper(1, n);
    }
}
// @lc code=end

