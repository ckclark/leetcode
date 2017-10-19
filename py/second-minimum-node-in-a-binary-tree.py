# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def dfs(self, cur):
        if cur:
            if self.smallest is None:
                self.smallest = cur.val
            elif self.smallest > cur.val:
                self.smallest, self.secondSmallest = cur.val, self.smallest
            elif self.smallest < cur.val:
                if self.secondSmallest is None:
                    self.secondSmallest = cur.val
                elif self.secondSmallest > cur.val:
                    self.secondSmallest = cur.val
            self.dfs(cur.left)
            self.dfs(cur.right)


    def findSecondMinimumValue(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.smallest = None
        self.secondSmallest = None
        self.dfs(root)
        return -1 if self.secondSmallest is None else self.secondSmallest
