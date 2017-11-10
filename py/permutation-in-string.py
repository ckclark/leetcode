from collections import Counter
class Solution(object):
    def checkInclusion(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: bool
        """
        P = 10 ** 9 + 7
        Q = 65535
        inv = lambda x: pow(x % P, P - 2, P)
        ls1, ls2 = len(s1), len(s2)

        if ls2 < ls1:
            return False

        match = 0
        for c, cnt in Counter(s1).iteritems():
            match = (match + cnt * pow(Q, ord(c) - ord('a') + 1, P)) % P

        window = 0
        for i in xrange(ls1 - 1):
            window = (window + pow(Q, ord(s2[i]) - ord('a') + 1, P)) % P

        for i in xrange(ls1 - 1, ls2):
            window = (window + pow(Q, ord(s2[i]) - ord('a') + 1, P)) % P
            if window == match:
                return True
            window = (window + (P - pow(Q, ord(s2[i - ls1 + 1]) - ord('a') + 1, P))) % P
        return False
