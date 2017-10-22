from collections import defaultdict
class Solution(object):
    def insert(self, now, p, front):
        lsize = 0 if now.left is None else now.left.val[1]
        if front <= lsize:
            if now.left is None:
                now.left = TreeNode((p, 1))
            else:
                self.insert(now.left, p, front)
        else:
            if now.right is None:
                now.right = TreeNode((p, 1))
            else:
                self.insert(now.right, p, front - lsize - 1)
        now.val = (now.val[0], now.val[1] + 1)

    def inOrder(self, cur):
        if cur:
            for x in self.inOrder(cur.left):
                yield x
            yield cur.val[0]
            for x in self.inOrder(cur.right):
                yield x

    def reconstructQueue(self, people):
        """
        :type people: List[List[int]]
        :rtype: List[List[int]]
        """
        if not people:
            return people
        people.sort(key=lambda x:(-x[0], x[1]))
        root = TreeNode((people[0], 1))
        for p in people[1:]:
            self.insert(root, p, p[1])
        return list(self.inOrder(root))

