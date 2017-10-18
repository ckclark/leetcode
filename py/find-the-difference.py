from collections import Counter
class Solution(object):
    def findTheDifference(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        sc, tc = Counter(s), Counter(t)
        for c, v in tc.iteritems():
            if v != sc[c]:
                return c
