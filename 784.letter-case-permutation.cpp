/*
 * @lc app=leetcode id=784 lang=cpp
 *
 * [784] Letter Case Permutation
 */

#include <bits/stdc++.h>

using namespace std;

// @lc code=start
class Solution {
public:
    void helper(string s, int idx, string curr, vector<string> &res) {
        if (idx == s.length()) {
            res.push_back(curr);
            return;
        }
        if (isalpha(s[idx])) {
            string t = curr + (char)tolower(s[idx]);
            helper(s, idx + 1, t, res);
            t = curr + (char)toupper(s[idx]);
            helper(s, idx + 1, t, res);
        } else {
            curr += s[idx];
            helper(s, idx + 1, curr, res);
        }
    }

    vector<string> letterCasePermutation(string s) {
        vector<string> res; string curr = "";
        helper(s, 0, curr, res);
        return res;
    }
};
// @lc code=end

