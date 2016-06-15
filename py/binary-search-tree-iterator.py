# Definition for a  binary tree node
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class BSTIterator(object):
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.cache = None
        self.g = BSTIterator.inOrder(root)


    def hasNext(self):
        """
        :rtype: bool
        """
        if self.cache:
            return True
        try:
            self.cache = self.g.next()
        except StopIteration:
            return False
        return True

    @staticmethod
    def inOrder(node):
        if node:
            if node.left:
                for n in BSTIterator.inOrder(node.left):
                    yield n
            yield node
            if node.right:
                for n in BSTIterator.inOrder(node.right):
                    yield n


    def next(self):
        """
        :rtype: int
        """
        if self.cache or self.hasNext():
            ret = self.cache.val
            self.cache = None
            return ret
