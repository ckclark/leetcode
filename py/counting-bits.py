class Solution(object):
    def count_bits(self, n):
        c = (n - ((n >> 1) & 0o33333333333) - ((n >> 2) & 0o11111111111))
        return ((c + (c >> 3)) & 0o30707070707) % 63
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        return map(self.count_bits, xrange(num + 1))
