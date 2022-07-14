/*
 * @lc app=leetcode id=97 lang=java
 *
 * [97] Interleaving String
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        return isInterleave1D(s1, s2, s3);
    }

    public boolean isInterleave2D(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        int m = s1.length(), n = s2.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) dp[i][j] = true;
                else if (i == 0) dp[i][j] = dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1));
                else if (j == 0) dp[i][j] = dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1));
                else dp[i][j] = (dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1))) || (dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1)));
            }
        }
        return dp[m][n];
    }

    public boolean isInterleave1D(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        int m = s1.length(), n = s2.length();
        boolean[] prev = new boolean[n + 1];
        boolean[] curr = new boolean[n + 1];
        prev[0] = true;
        for (int i = 1; i <= n; i++) prev[i] = prev[i - 1] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) curr[j] = prev[j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1));
                else curr[j] = (curr[j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1))) || (prev[j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1)));
            }
            prev = curr;
        }
        return prev[n];
    }

}
// @lc code=end

