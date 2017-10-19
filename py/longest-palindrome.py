from collections import Counter
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        counter = Counter(s)
        odd = 0
        ans = 0
        for char, cnt in counter.iteritems():
            if cnt % 2 == 0:
                ans += cnt
            else:
                odd = 1
                ans += cnt - 1
        return ans + odd
