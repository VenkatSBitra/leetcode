/*
 * @lc app=leetcode id=264 lang=java
 *
 * [264] Ugly Number II
 */

// @lc code=start
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int n2 = 0, n3 = 0, n5 = 0;
        for (int i = 1; i < n; i++) {
            int a = dp[n2] * 2, b = dp[n3] * 3, c = dp[n5] * 5;
            int res = Math.min(a, Math.min(b, c));
            if (res == a) n2++;
            if (res == b) n3++;
            if (res == c) n5++;
            dp[i] = res;
        }
        return dp[n - 1];
    }
}
// @lc code=end

