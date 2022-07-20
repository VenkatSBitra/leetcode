from typing import List

#
# @lc app=leetcode id=46 lang=python3
#
# [46] Permutations
#

# @lc code=start

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        lst = []

        def helper(vals: set):
            if len(vals) == 0:
                res.append(lst.copy())
            nset = set(vals)
            for val in vals:
                lst.append(val)
                nset.remove(val)
                helper(nset)
                nset.add(val)
                lst.pop()

        helper(set(nums))

        return res
# @lc code=end

