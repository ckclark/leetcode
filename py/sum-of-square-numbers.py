from collections import Counter
class Solution(object):
    @staticmethod
    def find_primes(n):
        """ returns a list of prime numbers from 2 to < n """
        if n < 2: return []
        if n == 2: return [2]
        # do only odd numbers starting at 3
        s = range(3, n, 2)
        # n**0.5 may be slightly faster than math.sqrt(n)
        mroot = n ** 0.5
        half = len(s)
        i = 0
        m = 3
        while m <= mroot:
            if s[i]:
                j = (m * m - 3)//2
                if j < len(s):
                    s[j] = 0
                    while j < min(len(s), half):
                        s[j] = 0
                        j += m
            i = i + 1
            m = 2 * i + 3
        # make exception for 2
        return [2]+[x for x in s if x]

    def judgeSquareSum(self, c):
        """
        :type c: int
        :rtype: bool
        """
        primes = Solution.find_primes(int((c + 1) ** .5) + 1)
        counter = Counter()
        for p in primes:
            if p > c:
                break
            while c % p == 0:
                c /= p
                counter[p] += 1
        if c > 1:
            counter[c] += 1
        for p, count in counter.iteritems():
            if p % 4 == 3 and count % 2 == 1:
                return False
        return True
