import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[] rm = new int[]{0, 1, 0, -1};
        int[] cm = new int[]{1, 0, -1, 0};
        int m = matrix.length, n = matrix[0].length;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int x = 0, y = 0, dir = 0;
        for (int i = 0; i < m * n; i++) {
            arrayList.add(matrix[x][y]);
            matrix[x][y] = Integer.MIN_VALUE;
            int nx = x + rm[dir], ny = y + cm[dir];
            if (nx >= 0 && ny >= 0 && nx < m && ny < n && matrix[nx][ny] != Integer.MIN_VALUE) {
                x = nx; y = ny;
            } else {
                dir = (dir + 1) % 4;
                x += rm[dir];
                y += cm[dir];
            }
            
        }
        return arrayList;
    }
}
// @lc code=end

