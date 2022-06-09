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
    bool helper(unordered_map<int, vector<int>> &g, vector<bool> &visited, vector<bool> &session, int start) {
        if (!visited[start]) {
            visited[start] = true;
            session[start] = true;
            for (int v: g[start]) {
                if (session[v]) return false;
                else if (!visited[v]) {
                    bool t = helper(g, visited, session, v);
                    if (!t) return false;
                }
            }
        }
        session[start] = false;
        return true;
    }

    bool bfsCycle(int numCourses, unordered_map<int, vector<int>> &g) {
        vector<bool> visited(numCourses, false);
        vector<bool> session(numCourses, false);
        for (int i = 0; i < numCourses; i++) {
            bool t = helper(g, visited, session, i);
            if (!t) return false;
        }
        return true;
    }

    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        unordered_map<int, vector<int>> g;
        for (auto v: prerequisites) g[v[0]].push_back(v[1]);
        return bfsCycle(numCourses, g);
    }
};
// @lc code=end

