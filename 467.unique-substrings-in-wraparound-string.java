import java.util.Arrays;

/*
 * @lc app=leetcode id=467 lang=java
 *
 * [467] Unique Substrings in Wraparound String
 */

// @lc code=start
class Solution {
    public int findSubstringInWraproundString(String p) {
        int cnt = 1; char c = p.charAt(0);
        int[] val = new int[26]; val[c - 'a'] = cnt;
        for (int i = 1; i < p.length(); i++) {
            if ((p.charAt(i) == c + 1) || (p.charAt(i) == 'a' && c == 'z')) {
                cnt++;
            } else {
                cnt = 1;
            }
            c = p.charAt(i);
            val[c - 'a'] = Math.max(cnt, val[c - 'a']);
        }
        return Arrays.stream(val).sum();
    }
}
// @lc code=end

