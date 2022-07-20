from typing import List

#
# @lc app=leetcode id=39 lang=python3
#
# [39] Combination Sum
#

# @lc code=start
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []

        def helper(idx, curr: List[int], total):
            if total == target:
                res.append(curr.copy())
                return
            if idx >= len(candidates) or total > target:
                return
            
            curr.append(candidates[idx])
            helper(idx, curr, total + candidates[idx])
            curr.pop()
            helper(idx + 1, curr, total)

        helper(0, [], 0)
        return res
# @lc code=end

