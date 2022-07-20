from functools import cache
#
# @lc app=leetcode id=50 lang=python3
#
# [50] Pow(x, n)
#

# @lc code=start
class Solution:
    def myPow(self, x: float, n: int) -> float:
        @cache
        def pow(t):
            if t == 0:
                return 1
            if t == 1:
                return x
            if t % 2 == 0:
                return pow(t // 2) * pow(t // 2)
            else:
                return pow(t // 2) * pow(t // 2) * pow(1)

        if n < 0:
            return 1 / pow(-n)
        else:
            return pow(n)
# @lc code=end

