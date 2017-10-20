class Solution(object):
    def validPalindromeIdx(self, s, i, j, todelete):
        while i < j:
            if s[i] == s[j]:
                i += 1
                j -= 1
            else:
                return bool(todelete) and (self.validPalindromeIdx(s, i + 1, j, todelete - 1) or self.validPalindromeIdx(s, i, j - 1, todelete - 1))
        return True

    def validPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        return self.validPalindromeIdx(s, 0, len(s) - 1, 1)
