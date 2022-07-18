import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=368 lang=java
 *
 * [368] Largest Divisible Subset
 */

// @lc code=start
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] dp = new int[nums.length];
        int[] prev = new int[nums.length];
        nums = Arrays.stream(nums).sorted().toArray();
        int maxlen = 1, maxidx = 0;
        for (int i = 0; i < nums.length; i++) {
            prev[i] = i;
            dp[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] == dp[j] + 1) prev[i] = j;
                }
            }
            if (dp[i] > maxlen) {
                maxlen = dp[i];
                maxidx = i;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (prev[maxidx] != maxidx) {
            res.add(nums[maxidx]);
            maxidx = prev[maxidx];
        }
        res.add(nums[maxidx]);
        Collections.reverse(res);
        return res;
    }
}
// @lc code=end

