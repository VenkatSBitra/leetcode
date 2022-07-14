import java.util.HashMap;

/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 */

// @lc code=start
class Solution {
    HashMap<Integer, Integer> sqrtMap = new HashMap<>();
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = 0; i <= Math.min(m, n); i++) {
            sqrtMap.put(i * i, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1;
                    res = 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i][j] == 1) {
                    int temp = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    dp[i][j] = (sqrtMap.get(temp) + 1) * (sqrtMap.get(temp) + 1);
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
// @lc code=end

