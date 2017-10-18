import sys
class Solution(object):
    def fizzBuzz(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        ret = []
        for i in xrange(1, n + 1):
            s = ''
            if i % 3 == 0:
                s += 'Fizz'
            if i % 5 == 0:
                s += 'Buzz'
            if i % 3 > 0 and i % 5 > 0:
                s += str(i)
            ret.append(s)
        return ret
