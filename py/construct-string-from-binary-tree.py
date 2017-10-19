# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def tree2str(self, t):
        """
        :type t: TreeNode
        :rtype: str
        """
        if not t:
            return ""
        ret = [str(t.val)]
        if t.left or t.right:
            ret.append("(")
            ret.append(self.tree2str(t.left))
            ret.append(")")
            if t.right:
                ret.append("(")
                ret.append(self.tree2str(t.right))
                ret.append(")")
        return ''.join(ret)

