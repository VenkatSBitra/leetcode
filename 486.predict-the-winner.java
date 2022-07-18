import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode id=486 lang=java
 *
 * [486] Predict the Winner
 */

// @lc code=start
class Solution {
    HashMap<String, Boolean> hMap;
    int[] numArray;

    public boolean helper(int l, int r, int p1, int p2, boolean player) {
        if (l > r) return player ? p1 >= p2 : p2 > p1;
        String keyString = Arrays.toString(new int[]{l, r, p1, player ? 1 : 0});
        if (hMap.containsKey(keyString)) return hMap.get(keyString);
        boolean res = false;
        if (player) {
            if (!helper(l + 1, r, p1 + numArray[l], p2, !player)) res = true;
            if (!helper(l, r - 1, p1 + numArray[r], p2, !player)) res = true;
        } else {
            if (!helper(l + 1, r, p1, p2 + numArray[l], !player)) res = true;
            if (!helper(l, r - 1, p1, p2 + numArray[r], !player)) res = true;
        }
        hMap.put(keyString, res);
        return res;
    }

    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i; j < nums.length; j++) {
                if (i == j) dp[i][j] = nums[i];
                else {
                    dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
                }
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }
}
// @lc code=end

