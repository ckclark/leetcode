import re
class Solution(object):
    def solveEquation(self, equation):
        """
        :type equation: str
        :rtype: str
        """
        lhs, rhs = equation.split('=')
        lcoef = sum(int(m + "1" if m in ["-", "+", ""] else m) for m in re.findall(r'([+-]?\d*)x', lhs))
        rcoef = sum(int(m + "1" if m in ["-", "+", ""] else m) for m in re.findall(r'([+-]?\d*)x', rhs))
        lconst = sum(int(m) for m in re.findall(r'([+-]?\d+)(?![0-9x])', lhs))
        rconst = sum(int(m) for m in re.findall(r'([+-]?\d+)(?![0-9x])', rhs))
        print lcoef, rcoef, lconst, rconst
        if lcoef == rcoef:
            if lconst == rconst:
                return "Infinite solutions"
            else:
                return "No solution"
        else:
            return 'x={ans}'.format(ans=(lconst - rconst) / (rcoef - lcoef))
