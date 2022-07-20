#
# @lc app=leetcode id=316 lang=python3
#
# [316] Remove Duplicate Letters
#

# @lc code=start
class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        li = {}
        visited = {}

        for i, c in enumerate(list(s)):
            li[c] = i
            visited[c] = False
            
        stack = []
        for i, c in enumerate(list(s)):
            if visited[c]:
                continue
            while len(stack) > 0 and stack[-1] > c and i < li[stack[-1]]:
                t = stack.pop()
                visited[t] = False
            stack.append(c)
            visited[c] = True

        return "".join(stack)
# @lc code=end

