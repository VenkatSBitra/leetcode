import java.util.Arrays;

/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (Math.abs(target) > sum) return 0;
        int[][] dp = new int[nums.length][2 * sum + 1];
        dp[0][nums[0] + sum] += 1; dp[0][sum - nums[0]] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = -sum; j <= sum; j++) {
                if (dp[i - 1][j + sum] > 0) {
                    int pos = j + nums[i], neg = j - nums[i];
                    if (Math.abs(pos) <= sum) dp[i][pos + sum] += dp[i - 1][j + sum];
                    if (Math.abs(neg) <= sum) dp[i][neg + sum] += dp[i - 1][j + sum];
                }
            }
        }
        return dp[nums.length - 1][target + sum];
    }
}
// @lc code=end

