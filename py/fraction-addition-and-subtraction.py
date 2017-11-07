import re
class Solution(object):
    def fractionAddition(self, expression):
        """
        :type expression: str
        :rtype: str
        """
        expression = expression.replace('-+', '-')
        expression = expression.replace('+-', '-')
        matches = re.findall(r'([+-]?)(\d+)/(\d+)', expression)
        ans = (0, 1)
        for m in matches:
            if m[0] == '-':
                v = -int(m[1]), int(m[2])
            else:
                v = int(m[1]), int(m[2])
            ans = ans[0] * v[1] + ans[1] * v[0], ans[1] * v[1]
        def gcd(a, b):
            while b != 0:
                a, b = b, a % b
            return a
        neg = 1
        if ans[0] * ans[1] < 0:
            neg = -1
        g = gcd(abs(ans[0]), abs(ans[1]))
        return '{}/{}'.format(neg * abs(ans[0]) / g, abs(ans[1]) / g)

