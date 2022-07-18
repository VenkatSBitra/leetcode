import java.util.Arrays;

/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {
    int[][] dp;

    public boolean helper(int[] nums, int idx, int tSum) {
        if (tSum == 0) return true;
        if (tSum < 0 || idx >= nums.length) return false;
        if (dp[idx][tSum] != 0) return dp[idx][tSum] == 1 ? true : false;
        boolean res = false;
        if (nums[idx] <= tSum) {
            res = res || helper(nums, idx + 1, tSum - nums[idx]);
        }
        res = res || helper(nums, idx + 1, tSum);
        dp[idx][tSum] = res ? 1 : 2;
        return res;
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;
        dp = new int[nums.length][sum / 2 + 1];
        return helper(nums, 0, sum / 2);
    }
}
// @lc code=end

