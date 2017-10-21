import re
class Solution(object):
    def complexNumberMultiply(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        pat = re.compile(r'(-?\d+)\+(-?\d+)i')
        mata = pat.match(a)
        matb = pat.match(b)
        a = int(mata.group(1)), int(mata.group(2))
        b = int(matb.group(1)), int(matb.group(2))
        ans = a[0] * b[0] - a[1] * b[1], a[1] * b[0] + a[0] * b[1]
        return '%d+%di' % ans
