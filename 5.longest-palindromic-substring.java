/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int start = 0, len = 0;
        for (int i = 0; i < s.length(); i++) {
            int l1 = expandFromCenter(s, i, i);
            int l2 = expandFromCenter(s, i, i + 1);
            int l = Math.max(l1, l2);
            if (l > len) {
                start = i - (l - 1) / 2;
                len = l;
            }
        }
        return s.substring(start, start + len);
    }

    public int expandFromCenter(String s, int left, int right) {
        while ((left <= right) && (left >= 0) && (right <= s.length() - 1) && (s.charAt(left) == s.charAt(right))) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
// @lc code=end

