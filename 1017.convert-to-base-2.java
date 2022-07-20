/*
 * @lc app=leetcode id=1017 lang=java
 *
 * [1017] Convert to Base -2
 */

// @lc code=start
class Solution {
    public String baseNeg2(int n) {
        int cnt = 0, v = 1, t = n;
        while (t != 0 && v != n) {
            v *= 4;
            cnt++;
            t /= 4;
        }
        String s = "1";
        if (t == 1) {
            for (int i = 0; i < cnt; i++) {
                s += "00";
            }
            return s;
        }
        n = v - n;
        s += String.format("%" + (2 * cnt) + "s", Integer.toBinaryString(n)).replaceAll(" ", "0");
        return s;
    }
}
// @lc code=end

