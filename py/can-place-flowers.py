from itertools import groupby
class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """

        prev = None
        l = len(flowerbed)
        for i, f in enumerate(flowerbed):
            if f == 0:
                if not prev and (i >= l - 1 or flowerbed[i + 1] == 0):
                    flowerbed[i] = 1
                    n -= 1
            prev = flowerbed[i]
        return n <= 0
