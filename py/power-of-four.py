class Solution(object):
    def isPowerOfFour(self, num):
        """
        :type num: int
        :rtype: bool
        """
        return (num & 0x55555555) > 0 and (num & -num) == num
