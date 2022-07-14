/*
 * @lc app=leetcode id=198 lang=cpp
 *
 * [198] House Robber
 */

#include <bits/stdc++.h>

using namespace std;

// @lc code=start
class Solution {
public:
    int rob(vector<int>& nums) {
        if (nums.size() == 1) return nums[0];
        else if (nums.size() == 2) return max(nums[0], nums[1]);
        else {
            vector<int> res(nums.size() + 1);
            res[0] = 0; res[1] = nums[0];
            for (int i = 2; i < nums.size() + 1; i++) {
                res[i] = max(res[i - 1], nums[i - 1] + res[i - 2]);
            }
            return res[nums.size()];
        } 
    }
};
// @lc code=end

