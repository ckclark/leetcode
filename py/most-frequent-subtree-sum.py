from collections import Counter
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def top_down(self, cur, c):
        if cur:
            lsum = self.top_down(cur.left, c)
            rsum = self.top_down(cur.right, c)
            s = lsum + rsum + cur.val
            c[s] += 1
            if c[s] > self.freq:
                self.freq = c[s]
                self.most_freq = [s]
            elif c[s] == self.freq:
                self.most_freq.append(s)
            return s
        else:
            return 0


    def findFrequentTreeSum(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        c = Counter()
        self.most_freq = []
        self.freq = 0
        self.top_down(root, c)
        return self.most_freq
