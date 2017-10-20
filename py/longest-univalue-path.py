# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def dfs(self, cur):
        """ return longest univalue path, longest univalue path to children from self"""
        if cur:
            llup, llups = self.dfs(cur.left)
            rlup, rlups = self.dfs(cur.right)
            lup = 1
            lups = 1
            if cur.left and cur.val == cur.left.val:
                lup += llups
                lups = max(lups, 1 + llups)
            if cur.right and cur.val == cur.right.val:
                lup += rlups
                lups = max(lups, 1 + rlups)
            return max(llup, rlup, lup), lups
        else:
            return 0, 0

    def longestUnivaluePath(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        return max(self.dfs(root)[0] - 1, 0)
