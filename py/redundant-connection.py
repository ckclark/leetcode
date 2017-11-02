from collections import defaultdict
class Solution(object):
    def findRedundantConnection(self, edges):
        """
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        visited = set()
        parent = dict()
        neighbors = defaultdict(list)
        edge_idx = {tuple(sorted(e)): i for i, e in enumerate(edges)}
        def cycle_edge(v1, v2):
            e = tuple(sorted([v1, v2]))
            max_idx, ans = edge_idx[e], e
            v = v1
            while v != v2:
                e = tuple(sorted([v, parent[v]]))
                if edge_idx[e] > max_idx:
                    max_idx = edge_idx[e]
                    ans = e
                v = parent[v]
            return list(ans)

        def dfs(cur):
            visited.add(cur)
            for neighbor in neighbors[cur]:
                if neighbor != parent[cur]:
                    if neighbor in visited:
                        yield cycle_edge(cur, neighbor)
                    else:
                        parent[neighbor] = cur
                        for x in dfs(neighbor):
                            yield x

        for v1, v2 in edges:
            neighbors[v1].append(v2)
            neighbors[v2].append(v1)
        parent[v1] = -1
        return next(dfs(v1))
