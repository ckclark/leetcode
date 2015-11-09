from TreeNode import TreeNode
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
        ret = []
        ret.append('(')
        if root is not None:
            ret.append(str(root.val))
            ret.append(self.serialize(root.left))
            ret.append(self.serialize(root.right))
        ret.append(')')
        return ''.join(ret)

    def doDeserialize(self, data, begin):
        assert data[begin] == '('
        for nondigit in xrange(begin + 1, len(data)):
            if data[nondigit] in '()':
                break
        if nondigit == begin + 1:
            return None, begin + 2
        else:
            root = TreeNode(int(data[begin + 1:nondigit]))
            root.left, next_start = self.doDeserialize(data, nondigit)
            root.right, next_start = self.doDeserialize(data, next_start)
            return root, next_start + 1

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        root, _ = self.doDeserialize(data, 0)
        return root

