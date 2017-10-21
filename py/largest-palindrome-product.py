class Solution(object):
    def largestPalindrome(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1:
            return 9
        for x in xrange(3, 10 ** n):
            # two numbers 10 ** n - i, 10 ** n - j
            # x = i + j
            # reverse(10 ** n - x) = i * j
            y = int(str(10 ** n - x)[::-1])
            D = x * x - 4 * y
            if D >= 0:
                sqrt_D = int((D + 0.5) ** .5)
                if sqrt_D ** 2 == D:
                    return ((10 ** n - x) * 10 ** n + y) % 1337
