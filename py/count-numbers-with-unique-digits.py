class Solution(object):
    def countNumbersWithUniqueDigits(self, n):
        """
        :type n: int
        :rtype: int
        """
        n = min(10, n)
        ans = 1
        for i in xrange(10 - (n - 1), 10 + 1):
            ans = ans * i + 1
        ans *= 9
        ans /= 10
        return ans + 1
