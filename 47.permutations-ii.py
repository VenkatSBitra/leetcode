from typing import List
#
# @lc app=leetcode id=47 lang=python3
#
# [47] Permutations II
#

# @lc code=start
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        res = set()
        lst = []

        def helper(vals: set):
            if len(vals) == 0:
                res.add(tuple(lst))
            nset = set(vals)
            for val in vals:
                lst.append(nums[val])
                nset.remove(val)
                helper(nset)
                nset.add(val)
                lst.pop()

        helper(set([i for i in range(len(nums))]))
        return list(res)
            
# @lc code=end

