def link(info, size, r1, r2):
    if size[r1] > size[r2]:
        info[r2] = r1
        size[r1] += size[r2]
        return size[r1]
    else:
        info[r1] = r2
        size[r2] += size[r1]
        return size[r2]

def find_root(info, p1):
    if p1 != info[p1]:
        info[p1] = find_root(info, info[p1])
    return info[p1]

class Solution(object):
    def maxAreaOfIsland(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        info = dict()
        size = dict()
        rows = len(grid)
        cols = len(grid[0])
        m = 0
        for r, row in enumerate(grid):
            for c, v in enumerate(row):
                if v == 1:
                    info[r, c] = (r, c)
                    size[r, c] = 1
                    m = 1
        for r, row in enumerate(grid):
            for c, v in enumerate(row):
                if v == 1:
                    if r > 0 and grid[r - 1][c] == 1:
                        ra, rb = find_root(info, (r, c)), find_root(info, (r - 1, c))
                        if ra != rb:
                            m = max(m, link(info, size, ra, rb))
                    if r < rows - 1 and grid[r + 1][c] == 1:
                        ra, rb = find_root(info, (r, c)), find_root(info, (r + 1, c))
                        if ra != rb:
                            m = max(m, link(info, size, ra, rb))
                    if c > 0 and grid[r][c - 1] == 1:
                        ra, rb = find_root(info, (r, c)), find_root(info, (r, c - 1))
                        if ra != rb:
                            m = max(m, link(info, size, ra, rb))
                    if c < cols - 1 and grid[r][c + 1] == 1:
                        ra, rb = find_root(info, (r, c)), find_root(info, (r, c + 1))
                        if ra != rb:
                            m = max(m, link(info, size, ra, rb))
        return m
