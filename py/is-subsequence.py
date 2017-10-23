class Solution(object):
    def isSubsequence(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        x = 0
        for i, c in enumerate(t):
            if x == len(s):
                return True
            if c == s[x]:
                x += 1
        return x == len(s)

