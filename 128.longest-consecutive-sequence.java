import java.util.HashSet;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hSet = new HashSet<>();
        for (int i : nums) hSet.add(i);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!hSet.contains(nums[i] - 1)) {
                int currNum = nums[i];
                int currLen = 1;
                while (hSet.contains(currNum + 1)) {
                    currLen++; currNum++;
                }
                res = Math.max(res, currLen);
            }
        }
        return res;
    }
}
// @lc code=end

