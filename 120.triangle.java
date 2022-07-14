import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i >= 1) {
                    dp[i][j] = triangle.get(i).get(j);
                    if (j == 0) {
                        dp[i][j] += dp[i - 1][j];
                    } else if (j == triangle.get(i).size() - 1) {
                        dp[i][j] += dp[i - 1][j - 1];
                    } else {
                        dp[i][j] += Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                    }
                } else {
                    dp[i][j] = triangle.get(i).get(j);
                }
            }
        }
        return Arrays.stream(dp[triangle.size() - 1]).min().getAsInt();
    }
}
// @lc code=end

