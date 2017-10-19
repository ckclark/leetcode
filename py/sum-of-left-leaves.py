# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sumOfLeftLeaves(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        ans = 0
        if root:
            if root.left:
                if root.left.left is None and root.left.right is None:
                    ans += root.left.val
                else:
                    ans += self.sumOfLeftLeaves(root.left)
            ans += self.sumOfLeftLeaves(root.right)
        return ans
