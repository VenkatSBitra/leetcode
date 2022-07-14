/*
 * @lc app=leetcode id=300 lang=cpp
 *
 * [300] Longest Increasing Subsequence
 */

#include <bits/stdc++.h>

using namespace std;

// @lc code=start
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int> res(nums.size(), 0);
        res[0] = 1;
        for (int i = 1; i < nums.size(); i++) {
            int t = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) t = max(t, res[j]);
            }
            res[i] = t + 1;
        }
        return *max_element(res.begin(), res.end());
    }
};
// @lc code=end

