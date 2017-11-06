from collections import defaultdict
class Node(object):
    def __init__(self):
        self.children = defaultdict(Node)
        self.val = 0

class MapSum(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.appeared = dict()
        self.root = Node()


    def insert(self, key, val):
        """
        :type key: str
        :type val: int
        :rtype: void
        """
        diff = val - self.appeared.get(key, 0)
        cur = self.root
        for c in key:
            node = cur.children[c]
            node.val += diff
            cur = node
        self.appeared[key] = val

    def sum(self, prefix):
        """
        :type prefix: str
        :rtype: int
        """
        cur = self.root
        for c in prefix:
            cur = cur.children[c]
        return cur.val


# Your MapSum object will be instantiated and called as such:
# obj = MapSum()
# obj.insert(key,val)
# param_2 = obj.sum(prefix)
