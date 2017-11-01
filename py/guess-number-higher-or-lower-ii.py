class Solution(object):
    def getMoneyAmount(self, n, table=dict()):
        """
        :type n: int
        :rtype: int
        """
        def dp(L, U):
            if (L, U) not in table:
                if L + 1 >= U:
                    table[L, U] = 0
                else:
                    table[L, U] = min(j + max(dp(L, j), dp(j + 1, U)) for j in xrange(L, U))
            return table[L, U]
        return dp(1, n + 1)
