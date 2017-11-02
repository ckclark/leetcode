# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def deleteNode(self, root, key):
        """
        :type root: TreeNode
        :type key: int
        :rtype: TreeNode
        """
        def remove(node, parent):
            ret = root
            if node.left is None and node.right is None:
                if parent is None:
                    ret = None
                else:
                    if parent.val > node.val:
                        parent.left = None
                    else:
                        parent.right = None
            elif node.left is not None and node.right is not None:
                p, to_remove = node, node.right
                while to_remove.left is not None:
                    p, to_remove = to_remove, to_remove.left
                node.val = to_remove.val
                ret = remove(to_remove, p)
            else:
                if node.left is not None:
                    up = node.left
                else:
                    up = node.right
                if parent is None:
                    ret = up
                else:
                    if parent.val > node.val:
                        parent.left = up
                    else:
                        parent.right = up
            return ret

        def dfs(cur, parent):
            if cur:
                if cur.val == key:
                    return remove(cur, parent)
                elif cur.val < key:
                    return dfs(cur.right, cur)
                else:
                    return dfs(cur.left, cur)
            return None

        ret = dfs(root, None)
        if root is None or (ret is None and root.val == key):
            return None
        else:
            return ret or root
