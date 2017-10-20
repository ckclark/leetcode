class Solution(object):
    def repeatedSubstringPattern(self, s):
        """
        :type s: str
        :rtype: bool
        """
        for i in xrange(1, len(s) / 2 + 1):
            if len(s) % i == 0 and len(set(s[j:j+i] for j in xrange(0, len(s), i))) == 1:
                return True
        return False
