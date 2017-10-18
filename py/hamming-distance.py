class Solution(object):
    def hammingDistance(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: int
        """
        xored = x ^ y
        uCount = xored - ((xored >> 1) & 0o33333333333) - ((xored >> 2) & 0o11111111111)
        return ((uCount + (uCount >> 3)) & 0o30707070707) % 63
