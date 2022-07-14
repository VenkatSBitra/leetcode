/*
 * @lc app=leetcode id=213 lang=cpp
 *
 * [213] House Robber II
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
            vector<int> res(nums.size());
            vector<int> res2(nums.size());
            res[0] = 0; res[1] = nums[0];
            res2[0] = 0; res2[1] = nums[1];
            for (int i = 2; i < nums.size(); i++) {
                res[i] = max(res[i - 1], nums[i - 1] + res[i - 2]);
                res2[i] = max(res2[i - 1], nums[i] + res2[i - 2]);
            }
            return max(res[nums.size() - 1], res2[nums.size() - 1]);
        } 
    }
};
// @lc code=end

