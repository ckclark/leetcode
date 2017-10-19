# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def inOrderDesc(self, root):
        if root:
            self.inOrderDesc(root.right)
            root.val = self.increment = root.val + self.increment
            self.inOrderDesc(root.left)

    def convertBST(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        self.increment = 0
        self.inOrderDesc(root)
        return root
