from collections import Counter
class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        """
        :type ransomNote: str
        :type magazine: str
        :rtype: bool
        """
        cr = Counter(ransomNote)
        cm = Counter(magazine)
        for c, v in cr.iteritems():
            if v > cm[c]:
                return False
        return True
