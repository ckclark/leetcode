class Solution(object):
    def collectSize(self, cur):
        if cur is None:
            return 0
        cur.size = self.collectSize(cur.left) + self.collectSize(cur.right) + 1
        return cur.size

    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        self.collectSize(root)
        L = 0
        cur = root
        while True:
            if cur.left is None:
                left_size = 0
            else:
                left_size = cur.left.size

            if k <= L + left_size:
                cur = cur.left
            elif k == L + left_size + 1:
                return cur.val
            else:
                L += left_size + 1
                cur = cur.right
