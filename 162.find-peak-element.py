from typing import List
#
# @lc app=leetcode id=162 lang=python3
#
# [162] Find Peak Element
#

# @lc code=start
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0
        if nums[0] > nums[1]:
            return 0
        if nums[-1] > nums[-2]:
            return len(nums) - 1
        l, r = 0, len(nums) - 1
        while l <= r:
            mid = (l + r) // 2
            if nums[mid - 1] < nums[mid] and nums[mid + 1] < nums[mid]:
                return mid
            if nums[mid - 1] >= nums[mid]:
                r = mid
                continue
            if nums[mid + 1] >= nums[mid]:
                l = mid
        return l
# @lc code=end

