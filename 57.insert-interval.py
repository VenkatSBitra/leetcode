from typing import List
#
# @lc app=leetcode id=57 lang=python3
#
# [57] Insert Interval
#

# @lc code=start
class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        intervals.append(newInterval)
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

