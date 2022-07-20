from typing import List

#
# @lc app=leetcode id=77 lang=python3
#
# [77] Combinations
#

# @lc code=start
class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = set()

        def helper(k, nums: set, lst: List[int]):
            if k == 0:
                res.add(tuple(lst))
            for i, num in enumerate(nums):
                lst.append(num)
                helper(k - 1, nums[i+1:], lst)
                lst.pop()

        helper(k, [i + 1 for i in range(n)], [])
        return list(res)
# @lc code=end

