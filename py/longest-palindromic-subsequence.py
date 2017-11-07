class Solution(object):
    def longestPalindromeSubseq(self, s):
        """
        :type s: str
        :rtype: int
        """
        prev2 = [0] * len(s)
        prev = [1] * len(s)
        for l in xrange(2, len(s) + 1):
            nxt = [0] * (len(s) - l + 1)
            for i in xrange(len(s) - l + 1):
                if s[i] == s[i + l - 1]:
                    nxt[i] = prev2[i + 1] + 2
                else:
                    nxt[i] = max(prev[i + 1], prev[i])
            prev2, prev = prev, nxt
        return prev[0]
