class Solution(object):
    def toHex(self, num):
        """
        :type num: int
        :rtype: str
        """
        ans = []
        for i in xrange(8):
            ans.append('0123456789abcdef'[num & 0xf])
            num >>= 4
            if num == 0:
                break
        return ''.join(ans[::-1])
