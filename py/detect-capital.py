class Solution(object):
    def detectCapitalUse(self, word):
        """
        :type word: str
        :rtype: bool
        """
        if word.islower():
            return True
        if word.isupper():
            return True
        if word[1:].islower():
            return True
        return False
