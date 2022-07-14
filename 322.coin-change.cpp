/*
 * @lc app=leetcode id=322 lang=cpp
 *
 * [322] Coin Change
 */

#include <bits/stdc++.h>

using namespace std;

// @lc code=start
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<int> res(amount + 1, -1);
        res[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            int q = INT_MAX;
            for (auto c: coins) {
                if ((i - c >= 0) && res[i - c] != -1) 
                    q = min(q, 1 + res[i - c]);
            }
            if (q != INT_MAX) res[i] = q;
        }
        return res[amount];
    }
};
// @lc code=end

