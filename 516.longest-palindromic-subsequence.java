import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode id=516 lang=java
 *
 * [516] Longest Palindromic Subsequence
 */

// @lc code=start
class Solution {
    HashMap<String, Integer> hMap;

    public int helper(String s, int l, int r) {
        if (l > r) return 0;
        if (l == r) return 1;
        String keyString = Arrays.toString(new int[] {l, r});
        if (hMap.containsKey(keyString)) return hMap.get(keyString);
        int res = 0;
        if (s.charAt(l) == s.charAt(r)) res = 2 + helper(s, l + 1, r - 1);
        else res = Math.max(helper(s, l + 1, r), helper(s, l, r - 1));
        hMap.put(keyString, res);
        return res;
    }

    public int longestPalindromeSubseq(String s) {
        hMap = new HashMap<>();
        return helper(s, 0, s.length() - 1);
    }
}
// @lc code=end

