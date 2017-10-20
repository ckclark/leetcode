class Solution(object):
    def countdigits(self, n):
        t = 10
        s = n + 1
        while n + 1 > t:
            s += (n + 1) - t
            t *= 10
        return s - 1

    def findNthDigit(self, n):
        """
        :type n: int
        :rtype: int
        """
        L, U = 0, 1 << 31
        while L + 1 < U:
            mid = L + (U - L) / 2
            if self.countdigits(mid) >= n:
                U = mid
            else:
                L = mid
        rem = n - self.countdigits(L)
        return int(str(U)[rem - 1])
