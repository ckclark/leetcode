class Solution(object):
    def arrangeCoins(self, n):
        """
        :type n: int
        :rtype: int
        """
        return int((-1 + int((1 + 8 * n + .5) ** .5)) / 2)
