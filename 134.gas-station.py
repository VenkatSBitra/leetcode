from typing import List
#
# @lc app=leetcode id=134 lang=python3
#
# [134] Gas Station
#

# @lc code=start
class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        delta = [g - c for g, c in zip(gas, cost)]
        if sum(delta) < 0:
            return -1
        currGas = delta[0]
        currIdx = 0
        for i in range(len(gas)):
            if delta[i] >= 0:
                currIdx = i
                currGas = delta[i]
                break
        for i in range(currIdx + 1, len(gas)):
            if currGas + delta[i] < 0:
                currIdx = i + 1
                currGas = 0
            else:
                currGas = currGas + delta[i]
        return currIdx
# @lc code=end

