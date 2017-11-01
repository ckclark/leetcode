class Solution(object):
    def find_root(self, parent, n):
        if parent[n][0] != n:
            parent[n][0] = self.find_root(parent, parent[n][0])
        return parent[n][0]

    def link(self, parent, a, b):
        if parent[a][1] > parent[b][1]:
            parent[b][0] = a
            parent[a][1] += parent[b][1]
        else:
            parent[a][0] = b
            parent[b][1] += parent[a][1]
        self.groups -= 1

    def findCircleNum(self, M):
        """
        :type M: List[List[int]]
        :rtype: int
        """
        n = len(M)
        parent = [[i, 1] for i in xrange(n)]
        self.groups = n
        for a in xrange(n):
            for b in xrange(i):
                if M[a][b]:
                    ra = self.find_root(parent, a)
                    rb = self.find_root(parent, b)
                    if ra != rb:
                        self.link(parent, ra, rb)
        return self.groups
