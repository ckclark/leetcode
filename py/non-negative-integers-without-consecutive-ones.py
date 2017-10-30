class Solution(object):
    def findIntegers(self, num):
        """
        :type num: int
        :rtype: int
        """
        for t in xrange(num.bit_length() - 1, 0, -1):
            if ((1 << t) & num) and (1 << (t - 1) & num):
                flag = True
                for i in xrange(t, -1, -1):
                    if flag:
                        num |= (1 << i)
                    else:
                        num &= ~(1 << i)
                    flag = not flag
                break

        a, b = 1, 1
        ans = 0
        while num > 0:
            if num & 1:
                ans += a
            num >>= 1
            a, b = a + b, a
        return ans + 1
