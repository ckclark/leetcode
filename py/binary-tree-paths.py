# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from operator import attrgetter

class Solution:
    # @param {TreeNode} root
    # @return {string[]}
    def binaryTreePaths(self, root):
        ans = []
        stack = []
        if root is not None:
            self.dfs(ans, root, stack)
        return ans

    def dfs(self, ans, cur, stack):
        stack.append(cur)
        if cur.left:
            self.dfs(ans, cur.left, stack)

        if cur.right:
            self.dfs(ans, cur.right, stack)

        if cur.left is None and cur.right is None:
            ans.append('->'.join(map(str, map(attrgetter('val'), stack))))
        stack.pop()

