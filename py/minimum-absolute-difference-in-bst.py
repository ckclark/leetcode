# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def inOrder(self, cur):
        if cur:
            self.inOrder(cur.left)
            if self.prev is not None:
                d = abs(cur.val - self.prev)
                if self.ans is None:
                    self.ans = d
                else:
                    self.ans = min(self.ans, d)
            self.prev = cur.val
            self.inOrder(cur.right)

    def getMinimumDifference(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.prev = None
        self.ans = None
        self.inOrder(root)
        return self.ans
