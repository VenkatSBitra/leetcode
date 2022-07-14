import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start
class Solution {
    public HashSet<String> hSet = new HashSet<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        hSet.addAll(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        dp[1] = hSet.contains("" + s.charAt(0));
        ArrayList<String> arr = new ArrayList<>();
        if (dp[1]) {
            arr.add("" + s.charAt(0));
        }
        res.add(arr);
        for (int i = 2; i < s.length() + 1; i++) {
            String substr = s.substring(0, i);
            dp[i] = hSet.contains(substr);
            arr = new ArrayList<>();
            if (dp[i]) {
                arr.add(substr);
            }
            for (int j = 1; j < i; j++) {
                substr = s.substring(i - j, i);
                if (hSet.contains(substr)) {
                    dp[i] = dp[i] || dp[i - j];
                    if (dp[i]) {
                        if (dp[i - j]) {
                            for (String str: res.get(i - j - 1)) {
                                arr.add(str + " " + substr);
                            }
                        }
                    }
                }
            }
            res.add(arr);
        } // "pineapplepenapple"\n["apple","pen","applepen","pine","pineapple"]
        return res.get(s.length() - 1);
    }
}
// @lc code=end

