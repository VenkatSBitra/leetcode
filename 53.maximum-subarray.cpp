/*
 * @lc app=leetcode id=53 lang=cpp
 *
 * [53] Maximum Subarray
 */

#include <bits/stdc++.h>

using namespace std;

// @lc code=start
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int res = nums[0], sum = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] < 0) res = max(res, sum);
            if (sum < 0) {
                res = max(res, sum);
                sum = 0;
            }
            sum += nums[i];
        }
        res = max(res, sum);
        return res;
    }
};
// @lc code=end

