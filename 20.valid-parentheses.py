#
# @lc app=leetcode id=20 lang=python3
#
# [20] Valid Parentheses
#

# @lc code=start
class Solution:
    def isValid(self, s: str) -> bool:
        pairs = ['()', '[]', '{}']
        stack = []
        for c in s:
            if c in '([{':
                stack.append(c)
            else:
                if len(stack) == 0:
                    return False
                if stack[-1] + c in pairs:
                    stack.pop()
                else:
                    return False
        return len(stack) == 0
# @lc code=end

