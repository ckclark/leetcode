# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        def build(pre, pre_start, pre_end, in_pos, in_start, in_end):
            if pre_start == pre_end:
                return
            cur_root = pre[pre_start]
            root_pos = in_pos[cur_root]
            left_size = root_pos - in_start
            cur = TreeNode(cur_root)
            cur.left = build(pre, pre_start + 1, pre_start + 1 + left_size, in_pos, in_start, root_pos)
            cur.right = build(pre, pre_start + 1 + left_size, pre_end, in_pos, root_pos + 1, in_end)
            return cur
        in_pos = {v: pos for (pos, v) in enumerate(inorder)}
        return build(preorder, 0, len(preorder), in_pos, 0, len(inorder))
