import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode id=442 lang=java
 *
 * [442] Find All Duplicates in an Array
 */

// @lc code=start
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> hSet = new HashSet<>();
        HashSet<Integer> added = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hSet.contains(nums[i])) added.add(nums[i]);
            else hSet.add(nums[i]);
        }
        return new ArrayList<>(added);
    }
}
// @lc code=end

