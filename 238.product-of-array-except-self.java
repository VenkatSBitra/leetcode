/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int numZero = 0, zIndex = -1;
        for (int i = 0; i < nums.length; i++) 
            if (nums[i] == 0) {
                numZero++;
                zIndex = i;
            }
        int[] res = new int[nums.length];
        if (numZero >= 2) return res;
        else if (numZero == 1) {
            int resVal = 1;
            for (int i = 0; i < nums.length; i++) {
                if (i != zIndex) resVal *= nums[i];
            }
            res[zIndex] = resVal;
            return res;
        } else {
            int[] left = new int[nums.length];
            int[] right = new int[nums.length];
            left[0] = 1; right[nums.length - 1] = 1;
            for (int i = 1; i < nums.length; i++) {
                left[i] = left[i - 1] * nums[i - 1];
                right[nums.length - 1 - i] = right[nums.length - i] * nums[nums.length - i];
            }
            for (int i = 0; i < nums.length; i++) {
                res[i] = left[i] * right[i];
            }
            return res;
        }
    }
}
// @lc code=end

