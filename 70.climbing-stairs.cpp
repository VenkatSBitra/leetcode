/*
 * @lc app=leetcode id=70 lang=cpp
 *
 * [70] Climbing Stairs
 */

#include <bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    int climbStairs(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else {
            vector<int> v(n + 1, 0);
            v[0] = 1; v[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                v[i] = v[i - 1] + v[i - 2];
            }
            return v[n];
        }       
    }
};
// @lc code=end

