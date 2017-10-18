from collections import defaultdict
from Queue import Queue
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def averageOfLevels(self, root):
        """
        :type root: TreeNode
        :rtype: List[float]
        """
        levels = defaultdict(list)
        q = Queue()
        q.put((root, 0))

        while not q.empty():
            v, depth = q.get()
            levels[depth].append(v.val)
            if v.left:
                q.put((v.left, depth + 1))
            if v.right:
                q.put((v.right, depth + 1))
        d = 0
        ans = []
        while True:
            if not levels[d]:
                break
            ans.append(float(sum(levels[d])) / len(levels[d]))
            d += 1
        return ans

