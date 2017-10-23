# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def widthOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        start, end = 0, 0
        q = [(root, 0, 0)]
        cd = -1
        m = 0
        for v, d, c in q:
            if d != cd:
                start, end = c, c
                cd = d
            else:
                end = c
            m = max(m, end - start + 1)
            if v.left:
                q.append((v.left, d + 1, c << 1))
            if v.right:
                q.append((v.right, d + 1, (c << 1) | 1))
        return m

