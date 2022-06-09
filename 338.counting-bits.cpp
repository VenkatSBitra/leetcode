/*
 * @lc app=leetcode id=338 lang=cpp
 *
 * [338] Counting Bits
 */

#include <bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    vector<int> countBits(int n) {
        vector<int> v(n + 1, 0);
        int low = 0, high = 1;
        for (int i = 1; i < n + 1; i++) {
            if (i == high) {
                v[i] = 1;
                low = high;
                high = low * 2;
            } else {
                v[i] = 1 + v[i - low];
            }
        }
        return v;
    }
};
// @lc code=end

