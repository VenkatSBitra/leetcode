from typing import List

#
# @lc app=leetcode id=55 lang=python3
#
# [55] Jump Game
#

# @lc code=start
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        targ = len(nums) - 1
        for i in range(len(nums) - 2, -1, -1):
            if i + nums[i] >= targ:
                targ = i
        return targ == 0
# @lc code=end

