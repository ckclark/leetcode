from collections import Counter
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def dfs(self, cur):
        if cur:
            self.subsum += cur.val
            yield self.subsum_counter[self.subsum - self.needsum]
            self.subsum_counter[self.subsum] += 1
            for x in self.dfs(cur.left):
                yield x
            for x in self.dfs(cur.right):
                yield x
            self.subsum_counter[self.subsum] -= 1
            self.subsum -= cur.val

    def pathSum(self, root, needsum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: int
        """
        self.subsum = 0
        self.needsum = needsum
        self.subsum_counter = Counter()
        self.subsum_counter[0] += 1
        return sum(self.dfs(root))
