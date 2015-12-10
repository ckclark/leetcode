class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        stack = []
        stack.append(root)
        visited = set()
        found_depth = None

        while stack:
            cur = stack[-1]
            if found_depth is not None and len(stack) < found_depth:
                found_depth = len(stack)

            if (cur == p or cur == q) and cur not in visited:
                if found_depth is None:
                    found_depth = len(stack)
                else:
                    return stack[found_depth - 1]

            visited.add(cur)

            if cur.left and cur.left not in visited:
                stack.append(cur.left)
            elif cur.right and cur.right not in visited:
                stack.append(cur.right)
            else:
                stack.pop()
