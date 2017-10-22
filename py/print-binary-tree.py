# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def printTree(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[str]]
        """
        q = [(root, 1, 0)]
        for v, d, c in q:
            if v.left:
                q.append((v.left, d + 1, c << 1))
            if v.right:
                q.append((v.right, d + 1, (c << 1) | 1))
        maxd = q[-1][1]
        table = [[""] * ((1 << maxd) - 1) for _ in xrange(maxd)]
        for v, d, c in q:
            x = d - 1
            y = (1 << (maxd - 1)) - 1
            for i in xrange(d - 1):
                if c & (1 << i):
                    y += (1 << (i + (maxd - d)))
                else:
                    y -= (1 << (i + (maxd - d)))
            table[x][y] = str(v.val)
        return table
