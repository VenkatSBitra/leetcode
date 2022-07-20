from typing import List
#
# @lc app=leetcode id=228 lang=python3
#
# [228] Summary Ranges
#

# @lc code=start
class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        if len(nums) == 0:
            return []
        def toStr(st, en):
            if st == en:
                return str(st)
            else:
                return str(st) + "->" + str(en)
        st = en = nums[0]
        res = []
        for i in range(1, len(nums)):
            if nums[i] == en + 1:
                en += 1
            else:
                res.append(toStr(st, en))
                st = en = nums[i]
        res.append(toStr(st, en))
        return res
# @lc code=end

