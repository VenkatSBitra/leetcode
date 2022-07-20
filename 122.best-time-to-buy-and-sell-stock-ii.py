from typing import List
#
# @lc app=leetcode id=122 lang=python3
#
# [122] Best Time to Buy and Sell Stock II
#

# @lc code=start
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        currMin = prices[0]
        currMax = prices[0]
        for i in range(1, len(prices)):
            if prices[i] >= currMax:
                currMax = prices[i]
            else:
                profit += (currMax - currMin)
                currMin = prices[i]
                currMax = prices[i]
        profit += (currMax - currMin)
        return profit
# @lc code=end

