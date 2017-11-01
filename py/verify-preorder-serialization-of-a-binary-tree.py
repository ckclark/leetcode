class Solution(object):
    def isValidSerialization(self, preorder):
        """
        :type preorder: str
        :rtype: bool
        """
        def get_tree(nodes, offset):
            if nodes[offset] == '#':
                return offset + 1
            else:
                left = get_tree(nodes, offset + 1)
                right = get_tree(nodes, left)
                return right

        nodes = preorder.split(',')
        try:
            ret = get_tree(nodes, 0)
            return ret == len(nodes)
        except IndexError:
            return False
