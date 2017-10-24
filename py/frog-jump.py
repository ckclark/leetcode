class Solution(object):
    def canCross(self, stones):
        """
        :type stones: List[int]
        :rtype: bool
        """
        self.fail = set()
        end = stones[-1]
        if stones[1] != 1:
            return False
        stones = set(stones)
        return any(self.dfs(stones, 1, 1, end))

    def dfs(self, stones, cur, prev_jump, end):
        if cur == end:
            yield True
        if (cur, prev_jump) in self.fail:
            return
        if prev_jump > 1 and cur + prev_jump - 1 in stones:
            if any(self.dfs(stones, cur + prev_jump - 1, prev_jump - 1, end)):
                yield True
        if cur + prev_jump in stones:
            if any(self.dfs(stones, cur + prev_jump, prev_jump, end)):
                yield True
        if cur + prev_jump + 1 in stones:
            if any(self.dfs(stones, cur + prev_jump + 1, prev_jump + 1, end)):
                yield True
        self.fail.add((cur, prev_jump))
