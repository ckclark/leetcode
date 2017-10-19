# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def dfs(self, cur):
        if cur:
            ldepth = self.dfs(cur.left)
            rdepth = self.dfs(cur.right)
            self.m = max(self.m, ldepth + rdepth)
            return max(ldepth, rdepth) + 1
        else:
            return 0


    def diameterOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.m = 0
        self.dfs(root)
        return self.m

