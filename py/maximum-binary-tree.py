# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def constructMaximumBinaryTree(self, nums, start=None, end=None):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        if start is None and end is None:
            start, end = 0, len(nums)
        if start == end:
            return None
        m, mi = nums[start], start
        for i in xrange(start, end):
            if nums[i] > m:
                m, mi = nums[i], i
        ret = TreeNode(m)
        ret.left = self.constructMaximumBinaryTree(nums, start, mi)
        ret.right = self.constructMaximumBinaryTree(nums, mi + 1, end)
        return ret
