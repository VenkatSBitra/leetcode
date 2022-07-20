#
# @lc app=leetcode id=257 lang=python3
#
# [257] Binary Tree Paths
#

from typing import List, Optional


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
class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        res = []

        def toStr(a: List[str]):
            return '->'.join(a)

        curr = []
        def dfs(root: Optional[TreeNode]):
            curr.append(str(root.val))
            if root.left is None and root.right is None:
                res.append(curr.copy())
            if root.left is not None:
                dfs(root.left)
            if root.right is not None:
                dfs(root.right)
            curr.pop()

        dfs(root)

        return [toStr(i) for i in res]
# @lc code=end

