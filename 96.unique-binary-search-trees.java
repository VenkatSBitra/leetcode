/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res = res * ((2 * n) - i + 1);
            res = res / i;
        }
        res = res / (n + 1);
        return (int)res;
    }
}
// @lc code=end

