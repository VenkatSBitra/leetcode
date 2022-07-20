from typing import List
#
# @lc app=leetcode id=90 lang=python3
#
# [90] Subsets II
#

# @lc code=start
class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = set()

        def helper(idx, lst: List[int]):
            if (idx == len(nums)):
                res.add(tuple(sorted(lst)))
                return
            lst.append(nums[idx])
            helper(idx + 1, lst)
            lst.pop()
            helper(idx + 1, lst)

        helper(0, [])
        return list(res)
# @lc code=end

