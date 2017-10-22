from operator import attrgetter
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        q = [(root, 0)]
        m = root
        md = 0
        ans = []
        for v, d in q:
            if d != md:
                ans.append(m.val)
                md = d
                m = v
            m = max(m, v, key=attrgetter('val'))
            if v.left:
                q.append((v.left, d + 1))
            if v.right:
                q.append((v.right, d + 1))
        ans.append(m.val)
        return ans


