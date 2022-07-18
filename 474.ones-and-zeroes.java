/*
 * @lc app=leetcode id=474 lang=java
 *
 * [474] Ones and Zeroes
 */

// @lc code=start
class Solution {
    // HashMap<String, Integer> hMap;

    // public int helper(int[][] vals, int idx, int m, int n) {
    //     if (idx < 0) return 0;
    //     if ((m < 0) || (n < 0)) return 0;
    //     String keyString = Arrays.toString(new int[]{idx, m, n});
    //     if (hMap.containsKey(keyString)) return hMap.get(keyString);
    //     int res = 0;
    //     if (m >= vals[idx][0] && n >= vals[idx][1]) {
    //         res = Math.max(res, 1 + helper(vals, idx - 1, m - vals[idx][0], n -  vals[idx][1]));
    //     }
    //     res = Math.max(res, helper(vals, idx - 1, m, n));
    //     hMap.put(keyString, res);
    //     return res;
    // }

    int[][] dp;
    
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] vals = new int[strs.length][2];
        // hMap = new HashMap<>();
        dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '1') vals[i][1]++;
                else vals[i][0]++;
            }
            for (int j = m; j >= vals[i][0]; j--) {
                for (int k = n; k >= vals[i][1]; k--) {
                    dp[j][k] = Math.max(dp[j][k], 1 + dp[j - vals[i][0]][k - vals[i][1]]);
                }
            }
        }
        return dp[m][n];
        // return helper(vals, strs.length - 1, m, n);
    }
}
// @lc code=end

