# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def findTilt(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        return self.do_findTilt(root)[1]

    def do_findTilt(self, cur):
        if cur is None:
            return (0, 0)
        lsum, ltiltsum = self.do_findTilt(cur.left)
        rsum, rtiltsum = self.do_findTilt(cur.right)
        tilt = abs(lsum - rsum)
        return lsum + rsum + cur.val, ltiltsum + rtiltsum + tilt
