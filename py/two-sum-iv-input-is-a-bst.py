# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def inOrderAsc(self, root):
        stack = []
        visited = set()
        stack.append(root)
        while stack:
            cur = stack[-1]
            if cur.left and cur.left.val not in visited:
                stack.append(cur.left)
            elif cur.val not in visited:
                yield cur.val
                visited.add(cur.val)
            elif cur.right and cur.right.val not in visited:
                stack.append(cur.right)
            else:
                stack.pop()

    def inOrderDesc(self, root):
        stack = []
        visited = set()
        stack.append(root)
        while stack:
            cur = stack[-1]
            if cur.right and cur.right.val not in visited:
                stack.append(cur.right)
            elif cur.val not in visited:
                yield cur.val
                visited.add(cur.val)
            elif cur.left and cur.left.val not in visited:
                stack.append(cur.left)
            else:
                stack.pop()

    def findTarget(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: bool
        """
        if not root:
            return False
        iterAsc = self.inOrderAsc(root)
        iterDesc = self.inOrderDesc(root)

        curAsc = iterAsc.next()
        curDesc = iterDesc.next()

        while curAsc != curDesc:
            s = curAsc + curDesc
            if s < k:
                curAsc = iterAsc.next()
            elif s > k:
                curDesc = iterDesc.next()
            else:
                return True
        else:
            return False

