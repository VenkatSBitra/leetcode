/*
 * @lc app=leetcode id=152 lang=cpp
 *
 * [152] Maximum Product Subarray
 */

#include <bits/stdc++.h>

using namespace std;

// @lc code=start
class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int pdtF = 1, pdtB = 1, maxF = INT_MIN, maxB = INT_MIN;
        for (int i = 0; i < nums.size(); i++) {
            pdtF *= nums[i];
            pdtB *= nums[nums.size() - 1 - i];
            if (pdtF > maxF) maxF = pdtF;
            if (pdtF == 0) pdtF = 1;
            if (pdtB > maxB) maxB = pdtB;
            if (pdtB == 0) pdtB = 1;
        }
        return max(maxF, maxB);
    }
};
// @lc code=end

