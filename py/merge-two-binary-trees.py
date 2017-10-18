class Solution(object):
    def mergeTrees(self, t1, t2):
        """
        :type t1: TreeNode
        :type t2: TreeNode
        :rtype: TreeNode
        """
        if t1 is None:
            return t2
        elif t2 is None:
            return t1
        else:
            ret = TreeNode(t1.val + t2.val)
            ret.left = self.mergeTrees(t1.left, t2.left)
            ret.right = self.mergeTrees(t1.right, t2.right)
            return ret

