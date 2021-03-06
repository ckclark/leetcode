# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def findBottomLeftValue(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        q = [root]
        for v in q:
            if v.right:
                q.append(v.right)
            if v.left:
                q.append(v.left)
        return v.val
