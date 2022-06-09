/*
 * @lc app=leetcode id=494 lang=cpp
 *
 * [494] Target Sum
 */

/* 
    DP Solution:

    int findTargetSumWays(vector<int>& nums, int target) {
        int tSum = accumulate(nums.begin(), nums.end(), 0);
        if (abs(target) > tSum) return 0;
        vector<vector<int>> dp(nums.size(), vector<int>(2 * tSum + 1, 0));
        dp[0][tSum + nums[0]] += 1;
        dp[0][tSum - nums[0]] += 1;
        for (int i = 1; i < nums.size(); i++) {
            for (int j = -tSum; j < tSum + 1; j++) {
                if (dp[i - 1][tSum + j] > 0) {
                    dp[i][tSum + j - nums[i]] += dp[i - 1][tSum + j];
                    dp[i][tSum + j + nums[i]] += dp[i - 1][tSum + j];
                }
            }
        }
        return dp[nums.size() - 1][tSum + target];
    }
*/

#include <bits/stdc++.h>
using namespace std;

// @lc code=start
class Solution {
public:
    struct hash_pair {
        template <class T1, class T2>
        size_t operator()(const pair<T1, T2>& p) const
        {
            auto hash1 = hash<T1>{}(p.first);
            auto hash2 = hash<T2>{}(p.second);
    
            if (hash1 != hash2) {
                return hash1 ^ hash2;             
            }
            
            // If hash1 == hash2, their XOR is zero.
            return hash1;
        }
    };

    int dfs(
        unordered_map<pair<int, int>, vector<pair<int, int>>, hash_pair> &g, 
        vector<int> &nums, int target, pair<int, int> node, int sum
    ) {
        sum += node.second;
        if (node.first == nums.size() - 1) {
            if (sum == target) return 1;
        } else {
            int s = 0;
            for (auto v: g[node]) {
                s += dfs(g, nums, target, v, sum);
            }
            return s;
        }
    }


    int findTargetSumWays(vector<int>& nums, int target) {
        unordered_map<pair<int, int>, vector<pair<int, int>>, hash_pair> g;
        unordered_map<pair<int, int>, int, hash_pair> mem;
        for (int i = 1; i < nums.size(); i++) {
            g.insert({{i - 1, nums[i - 1]}, {{i, nums[i]}, {i, -nums[i]}}});
            g.insert({{i - 1, -nums[i - 1]}, {{i, nums[i]}, {i, -nums[i]}}});
        }
        int a = dfs(g, nums, target, {0, nums[0]}, 0);
        int b = dfs(g, nums, target, {0, -nums[0]}, 0);
        return a + b;
    }
};
// @lc code=end

