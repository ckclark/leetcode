# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        :type root: TreeNode
        :rtype: str
        """
        ans = []
        if root:
            ans.append(str(root.val))
            ans.append(self.serialize(root.left))
            ans.append(self.serialize(root.right))
        return ' '.join(ans)

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        :type data: str
        :rtype: TreeNode
        """
        return self.do_deserialize(data)[0]

    def do_deserialize(self, data):
        ans = None
        if data:
            val, data = data.split(' ', 1)
            if val:
                ans = TreeNode(int(val))
                ans.left, data = self.do_deserialize(data)
                ans.right, data = self.do_deserialize(data)
        return ans, data



# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
