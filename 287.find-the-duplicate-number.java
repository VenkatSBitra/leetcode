import java.util.HashSet;

/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start
class Solution {
    HashSet<Integer> hSet;
    public int findDuplicate(int[] nums) {
        hSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hSet.contains(nums[i])) return nums[i];
            else hSet.add(nums[i]);
        }
        return 0;
    }
}
// @lc code=end

