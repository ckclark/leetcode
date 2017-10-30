from collections import Counter
class Solution(object):
    def leastBricks(self, wall):
        """
        :type wall: List[List[int]]
        :rtype: int
        """
        c = Counter()
        wall_width = sum(wall[0])
        max_non_cut = 0
        for row in wall:
            subsum = 0
            for n in row:
                subsum += n
                c[subsum] += 1
                if subsum < wall_width:
                    max_non_cut = max(c[subsum], max_non_cut)
        return len(wall) - max_non_cut
