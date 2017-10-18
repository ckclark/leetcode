class Solution(object):
    def hasAlternatingBits(self, n):
        """
        :type n: int
        :rtype: bool
        """
        power_2 = (n ^ (n >> 1)) + 1
        return (power_2 & -power_2) == power_2
