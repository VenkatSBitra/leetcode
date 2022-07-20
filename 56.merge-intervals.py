from typing import List
#
# @lc app=leetcode id=56 lang=python3
#
# [56] Merge Intervals
#

# @lc code=start
class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda x: x[0])
        st, en = intervals[0]
        res = []
        for i in range(1, len(intervals)):
            nst, ned = intervals[i]
            if st <= nst <= en:
                st = min(st, nst)
                en = max(en, ned)
            else:
                res.append([st, en])
                st, en = nst, ned
        res.append([st, en])
        return res
# @lc code=end

