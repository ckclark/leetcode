from itertools import combinations, cycle, islice
class Solution(object):
    def flipLights(self, n, m):
        """
        :type n: int
        :type m: int
        :rtype: int
        """
        if m > 4:
            return self.flipLights(n, 4 - m % 2)
        if n > 6:
            return self.flipLights(6, m)

        ans = set()
        for i in xrange(m % 2, m + 1, 2):
            for comb in combinations(xrange(4), i):
                orig = [True] * n
                for flip in comb:
                    if flip == 0:
                        orig = [not x for x in orig]
                    elif flip == 1:
                        orig = [not x if i % 2 == 0 else x for i, x in enumerate(orig)]
                    elif flip == 2:
                        orig = [not x if i % 2 == 1 else x for i, x in enumerate(orig)]
                    elif flip == 3:
                        orig = [not x if i % 3 == 0 else x for i, x in enumerate(orig)]
                ans.add(tuple(orig))
        return len(ans)
