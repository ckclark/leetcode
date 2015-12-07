class Solution(object):
    def findMinHeightTrees(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        adjacency_list = [[] for _ in xrange(n)]
        degree = [0] * n
        for s, t in edges:
            adjacency_list[s].append(t)
            adjacency_list[t].append(s)
            degree[s] += 1
            degree[t] += 1

        queue = []
        visit = set()

        for i, d in enumerate(degree):
            if d <= 1:
                queue.append(i)

        while queue and len(visit) < n - 2:
            nxtqueue = []
            for v in queue:
                visit.add(v)
                for adj in adjacency_list[v]:
                    if adj not in visit:
                        degree[adj] -= 1
                        if degree[adj] == 1:
                            nxtqueue.append(adj)
            queue = nxtqueue

        return queue

