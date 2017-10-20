# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def inOrder(self, cur):
        if cur:
            for x in self.inOrder(cur.left):
                yield x
            yield cur.val
            for x in self.inOrder(cur.right):
                yield x

    def findMode(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        modes = []
        c = 0
        m = 0
        prev = None
        for v in self.inOrder(root):
            if prev == v:
                c += 1
            else:
                c = 1
            if c > m:
                modes = [v]
                m = c
            elif c == m:
                modes.append(v)
            prev = v
        return modes
