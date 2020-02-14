class Solution(object):
    def getMaximumGold(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        self.grid = grid
        self.rows = len(grid)
        if self.rows:
            self.cols = len(grid[0])

        ans = 0
        for x in range(self.rows):
            for y in range(self.cols):
                ans = max(ans, self.dfs(x, y))

        return ans

    def dfs(self, x, y):
        if not (0 <= x < self.rows and 0 <= y < self.cols):
            return 0
        else:
            gold = self.grid[x][y]
            if gold == 0:
                return 0
            self.grid[x][y] = 0
            ans = 0
            for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                nxt = self.dfs(x + dx, y + dy)
                if nxt > ans:
                    ans = nxt
            self.grid[x][y] = gold
            return ans + gold
