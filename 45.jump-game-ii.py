from typing import List
#
# @lc app=leetcode id=45 lang=python3
#
# [45] Jump Game II
#

# @lc code=start
class Solution:
    def jump(self, nums: List[int]) -> int:
        jumps = 0
        currReach = 0
        maxReach = 0
        for i in range(len(nums) - 1):
            maxReach = max(maxReach, i + nums[i])
            if i == currReach:
                jumps += 1
                currReach = maxReach
        return jumps
# @lc code=end

