/*
 * @lc app=leetcode id=304 lang=java
 *
 * [304] Range Sum Query 2D - Immutable
 */

// @lc code=start
class NumMatrix {
    
    int[][] cache;
    int m, n;

    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        cache = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                cache[i][j] = matrix[i - 1][j - 1] + cache[i - 1][j] + cache[i][j - 1] - cache[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return cache[row2 + 1][col2 + 1] - cache[row2 + 1][col1] - cache[row1][col2 + 1] + cache[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

