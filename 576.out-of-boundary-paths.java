import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode id=576 lang=java
 *
 * [576] Out of Boundary Paths
 */

// @lc code=start
class Solution {
    HashMap<String, Integer> hMap;
    int MN = 1000000007;

    public int helper(int m, int n, int moveLeft, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n) return 1;
        if (moveLeft == 0) return 0;
        String keyString = Arrays.toString(new int[] {row, col, moveLeft});
        if (hMap.containsKey(keyString)) return hMap.get(keyString);
        int res = 0;
        res = (res + (helper(m, n, moveLeft - 1, row + 1, col) % MN)) % MN;
        res = (res + (helper(m, n, moveLeft - 1, row - 1, col) % MN)) % MN;
        res = (res + (helper(m, n, moveLeft - 1, row, col + 1) % MN)) % MN;
        res = (res + (helper(m, n, moveLeft - 1, row, col - 1) % MN)) % MN;
        hMap.put(keyString, res);
        return res;
    } // 50\n50\n50\n25\n25

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        hMap = new HashMap<>(); 
        return helper(m, n, maxMove, startRow, startColumn) % MN;
    }
}
// @lc code=end

