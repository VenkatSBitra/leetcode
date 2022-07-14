/*
 * @lc app=leetcode id=343 lang=java
 *
 * [343] Integer Break
 */

// @lc code=start
class Solution {
    public int pow(int a, int b) {
        if (b == 0) return 1;
        else if (b % 2 == 0) {
            int t = pow(a, b / 2);
            return t * t;
        }
        else {
            int t = pow(a, b / 2);
            return t * t * a;
        }
    }

    public int integerBreak(int n) {
        int res = Integer.MIN_VALUE;
        for (int i = 2; i <= n; i++) {
            int q = n / i;
            if (q == 0) break;
            int r = n % i;
            int newval = pow(q, i - r) * pow(q + 1, r);
            if (newval < res) break;
            else res = newval;
        }
        return res;
    }
}
// @lc code=end

