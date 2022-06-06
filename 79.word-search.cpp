/*
 * @lc app=leetcode id=79 lang=cpp
 *
 * [79] Word Search
 */

#include <bits/stdc++.h>

using namespace std;

// @lc code=start
class Solution {
public:
    bool bfs(vector<vector<char>>& board, string word, vector<vector<bool>>& visited, int idx, int row, int col) {
        if (board[row][col] == word[idx]) {
            if (idx == word.length() - 1) return true;
            visited[row][col] = true;
            bool t;
            if ((row > 0) && !visited[row - 1][col]) {
                t = bfs(board, word, visited, idx + 1, row - 1, col);
                if (t) return true;
            }
            if ((row < board.size() - 1) && !visited[row + 1][col]) {
                t = bfs(board, word, visited, idx + 1, row + 1, col);
                if (t) return true;
            }
            if ((col > 0) && !visited[row][col - 1]) {
                t = bfs(board, word, visited, idx + 1, row, col - 1);
                if (t) return true;
            }
            if ((col < board[0].size() - 1) && !visited[row][col + 1]) {
                t = bfs(board, word, visited, idx + 1, row, col + 1);
                if (t) return true;
            }
            visited[row][col] = false;
            return false;
        } else {
            return false;
        }
    }

    bool exist(vector<vector<char>>& board, string word) {
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[0].size(); j++) {
                vector<vector<bool>> visited(board.size(), vector<bool>(board[0].size(), false));
                bool t = bfs(board, word, visited, 0, i, j);
                if (t) return true;
            }
        }
        return false;
    }
};
// @lc code=end

