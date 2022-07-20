from typing import List
from collections import defaultdict
#
# @lc app=leetcode id=200 lang=python3
#
# [200] Number of Islands
#

# @lc code=start
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m, n = len(grid), len(grid[0])

        def bfs(i, j):
            grid[i][j] = '0'
            if i - 1 >= 0 and grid[i - 1][j] == '1':
                bfs(i - 1, j)
            if i + 1 < m and grid[i + 1][j] == '1':
                bfs(i + 1, j)
            if j - 1 >= 0 and grid[i][j - 1] == '1':
                bfs(i, j - 1)
            if j + 1 < n and grid[i][j + 1] == '1':
                bfs(i, j + 1)
                

        res = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    res += 1
                    bfs(i, j)

        return res

# @lc code=end

