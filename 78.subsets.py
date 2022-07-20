from typing import List
#
# @lc app=leetcode id=78 lang=python3
#
# [78] Subsets
#

# @lc code=start
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []

        def helper(idx, lst: List[int]):
            if (idx == len(nums)):
                res.append(lst.copy())
                return
            lst.append(nums[idx])
            helper(idx + 1, lst)
            lst.pop()
            helper(idx + 1, lst)

        helper(0, [])
        return res

# @lc code=end

