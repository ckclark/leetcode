class Solution(object):
    def top_down(self, s, rem, mci):
        if self.cache[s] is not None:
            return self.cache[s]
        for i in xrange(mci):
            if (1 << i) & s == 0:
                v = i + 1
                if v >= rem:
                    self.cache[s] = True
                    return True
        self.cache[s] = any(not self.top_down(s | (1 << v), rem - (v + 1), mci) for v in xrange(mci) if (s & (1 << v)) == 0)
        return self.cache[s]

    def canIWin(self, maxChoosableInteger, desiredTotal):
        """
        :type maxChoosableInteger: int
        :type desiredTotal: int
        :rtype: bool
        """
        if sum(xrange(1, maxChoosableInteger + 1)) < desiredTotal:
            return False
        self.cache = [None] * (1 << maxChoosableInteger)
        return self.top_down(0, desiredTotal, maxChoosableInteger)
