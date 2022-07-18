import java.util.Arrays;

/*
 * @lc app=leetcode id=376 lang=java
 *
 * [376] Wiggle Subsequence
 */

/*
    For contiguous:

    if (nums.length == 1) return 1;
    int[] diff = new int[nums.length - 1];
    for (int i = 1; i < nums.length; i++) {
        diff[i - 1] = nums[i] - nums[i - 1];
    }
    int maxcnt = 1, cnt = 1, sgn = diff[0] > 0 ? 1 : (diff[0] < 0 ? -1 : 0);
    for (int i = 1; i < diff.length; i++) {
        if (sgn == 1) {
            if (diff[i] < 0) {
                cnt++;
                sgn = -1;
            } else {
                if (diff[i] == 0) sgn = 0;
                cnt = 1;
                maxcnt = Math.max(cnt, maxcnt);
            }
        } else if (sgn == -1) {
            if (diff[i] > 0) {
                cnt++;
                sgn = 1;
            } else {
                if (diff[i] == 0) sgn = 0;
                cnt = 1;
                maxcnt = Math.max(cnt, maxcnt);
            }
        }
    }
    maxcnt = Math.max(maxcnt, cnt);
    return maxcnt + 1;
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int[][] dp = new int[2][nums.length];
        for (int i = 0; i < nums.length; i++) {
            int res1 = 1, res2 = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) res1 = Math.max(res1, dp[1][j] + 1);
                if (nums[j] > nums[i]) res2 = Math.max(res2, dp[0][j] + 1);
            }
            dp[0][i] = res1;
            dp[1][i] = res2;
        }
        return Math.max(Arrays.stream(dp[0]).max().getAsInt(), Arrays.stream(dp[1]).max().getAsInt());
    }
}
// @lc code=end

