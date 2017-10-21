# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def findMax(self, start, end):
        bit_length = (end - start).bit_length() - 1
        d = 1 << bit_length
        return max(self.SparseTable[bit_length][start], self.SparseTable[bit_length][end - d])

    def do_constructMaximumBinaryTree(self, start, end):
        if start == end:
            return None
        v, i = self.findMax(start, end)
        ret = TreeNode(v)
        ret.left = self.do_constructMaximumBinaryTree(start, i)
        ret.right = self.do_constructMaximumBinaryTree(i + 1, end)
        return ret

    def constructMaximumBinaryTree(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        self.SparseTable = [[(v, i) for i, v in enumerate(nums)]]
        l = len(nums)
        t = 1
        while t * 2 < l:
            prevTable = self.SparseTable[-1]
            self.SparseTable.append([max(prevTable[i], prevTable[i + t]) for i in xrange(l - t * 2 + 1)])
            t *= 2
        return self.do_constructMaximumBinaryTree(0, l)
