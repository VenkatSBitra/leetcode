/*
 * @lc app=leetcode id=207 lang=cpp
 *
 * [207] Course Schedule
 */

#include <bits/stdc++.h>

using namespace std;

// @lc code=start
class Solution {
public:
    bool helper(unordered_map<int, vector<int>> g, vector<bool> visited, int start) {
        visited[start] = true;
        for (int v: g[start]) {
            if (visited[v]) return false;
            
        }
    }

    bool bfsCycle(int numCourses, unordered_map<int, vector<int>> g) {
        vector<bool> visited(numCourses, false);

    }

    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        
    }
};
// @lc code=end

