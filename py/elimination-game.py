class Solution(object):
    def lastRemaining(self, n):
        """
        :type n: int
        :rtype: int
        """
        return ((n | 0x55555555555555) & ((1 << (n.bit_length() - 1)) - 1)) + 1
