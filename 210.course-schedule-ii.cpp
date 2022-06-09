/*
 * @lc app=leetcode id=210 lang=cpp
 *
 * [210] Course Schedule II
 */
#include <bits/stdc++.h>

using namespace std;

// @lc code=start
class Solution {
public:
    bool helper(unordered_map<int, vector<int>> &g, stack<int> &s, vector<bool> &visited, vector<bool> &session, int start) {
        if (!visited[start]) {
            visited[start] = true;
            session[start] = true;
            for (int v: g[start]) {
                if (session[v]) return false;
                else if (!visited[v]) {
                    bool t = helper(g, s, visited, session, v);
                    if (!t) return false;
                }
            }
            s.push(start);
        }
        session[start] = false;
        return true;
    }

    bool bfsCycle(int numCourses, unordered_map<int, vector<int>> &g, stack<int> &s) {
        vector<bool> visited(numCourses, false);
        vector<bool> session(numCourses, false);
        for (int i = 0; i < numCourses; i++) {
            bool t = helper(g, s, visited, session, i);
            if (!t) return false;
        }
        return true;
    }

    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        unordered_map<int, vector<int>> g;
        for (auto v: prerequisites) g[v[1]].push_back(v[0]);
        stack<int> res; vector<int> result;
        if (bfsCycle(numCourses, g, res)) {
            while (!res.empty()) {
                int u = res.top(); res.pop();
                result.push_back(u);
            }
            return result;
        } else {
            return vector<int>();
        }
    }
};
// @lc code=end

