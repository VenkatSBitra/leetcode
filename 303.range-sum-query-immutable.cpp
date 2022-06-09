/*
 * @lc app=leetcode id=303 lang=cpp
 *
 * [303] Range Sum Query - Immutable
 */

#include <bits/stdc++.h>
using namespace std;

// @lc code=start
class NumArray {
public:
    vector<int> v;
    NumArray(vector<int>& nums) {
        v.push_back(0);
        for (int i = 0; i < nums.size(); i++)
            v.push_back(v[i] + nums[i]); 
    }
    
    int sumRange(int left, int right) {
        return v[right + 1] - v[left];
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * int param_1 = obj->sumRange(left,right);
 */
// @lc code=end

