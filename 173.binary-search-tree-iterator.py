#
# @lc app=leetcode id=173 lang=python3
#
# [173] Binary Search Tree Iterator
#

from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        vals = []
        stack = [root]
        while len(stack) != 0:
            rt = stack.pop()
            vals.append(rt.val)
            if rt.left is not None:
                stack.append(rt.left)
            if rt.right is not None:
                stack.append(rt.right)
        self.lst = sorted(vals)
        self.curr = -1

    def next(self) -> int:
        self.curr += 1
        return self.lst[self.curr]

    def hasNext(self) -> bool:
        return self.curr + 1 < len(self.lst)


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
# @lc code=end

