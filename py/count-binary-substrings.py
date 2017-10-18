from itertools import groupby
class Solution(object):
    def countBinarySubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        prev = 0
        ans = 0
        for k, g in groupby(s):
            l = len(list(g))
            ans += min(l, prev)
            prev = l
        return ans
