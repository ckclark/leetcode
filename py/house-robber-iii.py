# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def do_rob(self, cur):
        if not cur:
            return 0, 0
        else:
            robl, no_robl = self.do_rob(cur.left)
            robr, no_robr = self.do_rob(cur.right)

            rob_cur, no_rob_cur = cur.val + no_robl + no_robr, max(robl, no_robl) + max(robr, no_robr)
            return rob_cur, no_rob_cur

    def rob(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        return max(self.do_rob(root))
