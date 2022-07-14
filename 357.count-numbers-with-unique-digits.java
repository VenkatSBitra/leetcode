/*
 * @lc app=leetcode id=357 lang=java
 *
 * [357] Count Numbers with Unique Digits
 */

// @lc code=start
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        int ans = 10, temp = 9, k = 9;
        for (int i = 2; i <= n; i++) {
            temp *= k--;
            ans += temp;
        }
        return ans;
    }
}
// @lc code=end

