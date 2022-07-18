import java.util.HashMap;

/*
 * @lc app=leetcode id=523 lang=java
 *
 * [523] Continuous Subarray Sum
 */

// @lc code=start
class Solution {
    HashMap<Integer, Integer> hMap;
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length == 1) return false;
        hMap = new HashMap<>();
        int sum = 0;
        hMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if (hMap.containsKey(rem)) {
                if (i - hMap.get(rem) > 1) return true;
                else continue;
            }
            hMap.put(rem, i);
        }
        return false;
    }
}
// @lc code=end

