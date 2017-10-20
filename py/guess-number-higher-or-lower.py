# The guess API is already defined for you.
# @param num, your guess
# @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
# def guess(num):

class Solution(object):
    def guessNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        L, U = 0, n + 1
        while L + 1 < U:
            mid = L + (U - L) / 2
            g = guess(mid)
            if g > 0:
                L = mid
            elif g < 0:
                U = mid
            else:
                return mid
