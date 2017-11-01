class Solution(object):
    def getSum(self, a, b):
        """
        :type a: int
        :type b: int
        :rtype: int
        """
        if a == 0:
            return b
        elif a == -b:
            return 0
        else:
            if a < b:
                a, b = b, a
            if (a > -b and b < 0) or (b > -a and a < 0):
                return -self.getSum((-a & -b) << 1, -a ^ -b)
            else:
                return self.getSum((a & b) << 1, a ^ b)
