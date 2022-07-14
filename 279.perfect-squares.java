import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        ArrayList<Integer> sqList = new ArrayList<>();
        int num = 1; sqList.add(1);
        while ((++num) * num <= n) {
            sqList.add(num * num);
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int c: sqList) {
                if (c > i) break;
                dp[i] = Math.min(dp[i], dp[i - c] + 1);
            }
        }
        return dp[n];
    }
}
// @lc code=end

