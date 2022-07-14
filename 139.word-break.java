import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    public HashSet<String> hSet = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.equals("")) return true;
        hSet.addAll(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        dp[1] = hSet.contains("" + s.charAt(0));
        for (int i = 2; i < s.length() + 1; i++) {
            dp[i] = hSet.contains(s.substring(0, i));
            if (dp[i]) continue;
            for (int j = 1; j <= i; j++) {
                if (hSet.contains(s.substring(i - j, i))) {
                    dp[i] = dp[i - j];
                    if (dp[i]) break;
                }
            }
        }
        return dp[s.length()];
    }
}
// @lc code=end

