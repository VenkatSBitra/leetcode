/*
 * @lc app=leetcode id=413 lang=java
 *
 * [413] Arithmetic Slices
 */

// @lc code=start
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length == 1 || nums.length == 2) return 0;
        int[] diff = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            diff[i] = nums[i + 1] - nums[i];
        }
        int res = 0;
        int cnt = 1, flag = 1, val = diff[0];
        for (int i = 1; i < diff.length; i++) {
            if (diff[i] == val) {
                cnt++; flag--;
            } else {
                if (flag <= 0) {
                    res += (cnt * (cnt - 1) / 2);
                }
                cnt = 1; flag = 1; val = diff[i];
            }
        }
        if (flag <= 0) {
            res += (cnt * (cnt - 1) / 2);
        }
        return res;
    }
}
// @lc code=end

