# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sameTree(self, t1, t2):
        if t1 is None and t2 is None:
            return True
        if t1 is None or t2 is None:
            return False
        return t1.val == t2.val and self.sameTree(t1.left, t2.left) and self.sameTree(t1.right, t2.right)

    def dfs(self, cur):
        if cur:
            if self.sameTree(cur, self.t):
                yield True
            for x in self.dfs(cur.left):
                yield x
            for x in self.dfs(cur.right):
                yield x


    def isSubtree(self, s, t):
        """
        :type s: TreeNode
        :type t: TreeNode
        :rtype: bool
        """
        self.t = t
        for _ in self.dfs(s):
            return True
        return False
