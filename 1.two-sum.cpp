/*
 * @lc app=leetcode id=1 lang=cpp
 *
 * [1] Two Sum
 */

#include <bits/stdc++.h>

using namespace std;

// @lc code=start
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int n = nums.size();
        unordered_map<int, int> m;
        vector<int> v;
        m.insert({nums[0], 0});
        for (int i = 1; i < n; i++) {
            if (m.find(target - nums[i]) != m.end()) {
                v = {m[target - nums[i]], i};
            } else {
                m.insert({nums[i], i});
            }
        }
        return v;
    }
};
// @lc code=end

