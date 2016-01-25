from math import log
class Solution(object):
    def isPowerOfThree(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n <= 0:
            return False
        t = int(log(n + 1) / log(3))
        return (3 ** t) == n
