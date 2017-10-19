from operator import mul
class Solution(object):
    def dfs(self, rem, cur, depth):
        if depth == 10:
            h = sum(map(mul, cur[:4], [1, 2, 4, 8]))
            m = sum(map(mul, cur[4:], [1, 2, 4, 8, 16, 32]))
            if h < 12 and m < 60:
                yield '{}:{:02d}'.format(h, m)
        else:
            for i, r in enumerate(rem):
                if r > 0:
                    rem[i] -= 1
                    cur[depth] = i
                    for ans in self.dfs(rem, cur, depth + 1):
                        yield ans
                    rem[i] += 1

    def readBinaryWatch(self, num):
        """
        :type num: int
        :rtype: List[str]
        """
        return list(self.dfs([10 - num, num], [None] * 10, 0))
