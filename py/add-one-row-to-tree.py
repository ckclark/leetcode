# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def addOneRow(self, root, v, d):
        """
        :type root: TreeNode
        :type v: int
        :type d: int
        :rtype: TreeNode
        """
        if d == 1:
            new_root = TreeNode(v)
            new_root.left = root
            return new_root
        q = [(root, 2)]
        for node, nxt_depth in q:
            if nxt_depth == d:
                left = TreeNode(v)
                right = TreeNode(v)
                left.left = node.left
                right.right = node.right
                node.left, node.right = left, right
            else:
                if node.left:
                    q.append((node.left, nxt_depth + 1))
                if node.right:
                    q.append((node.right, nxt_depth + 1))
        return root
