from collections import defaultdict, Counter
class Solution(object):
    def longestIncreasingPath(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        if not matrix:
            return 0
        h = len(matrix)
        w = len(matrix[0])
        neighbors = defaultdict(list)
        in_deg = Counter()
        longest_length = Counter()

        ds = [(0, -1), (0, 1), (1, 0), (-1, 0)]
        starts = set(xrange(h * w))
        for x, row in enumerate(matrix):
            for y, v in enumerate(row):
                for dx, dy in ds:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < h and 0 <= ny < w:
                        if matrix[nx][ny] > v:
                            neighbors[x * w + y].append(nx * w + ny)
                            in_deg[nx * w + ny] += 1
                            starts.discard(nx * w + ny)
        for start in starts:
            longest_length[start] = 1

        q = list(starts)
        ans = 1
        for v in q:
            for neighbor in neighbors[v]:
                longest_length[neighbor] = max(longest_length[neighbor], longest_length[v] + 1)
                ans = max(longest_length[neighbor], ans)
                in_deg[neighbor] -= 1
                if in_deg[neighbor] == 0:
                    q.append(neighbor)
        return ans
