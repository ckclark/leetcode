class Solution(object):
    def isPerfectSquare(self, num):
        """
        :type num: int
        :rtype: bool
        """
        L, U = -1, num + 1
        while L + 1 < U:
            mid = L + (U - L) / 2
            if mid * mid > num:
                U = mid
            else:
                L = mid
        return L * L == num

