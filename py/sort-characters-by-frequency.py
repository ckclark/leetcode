from collections import Counter
class Solution(object):
    def frequencySort(self, s):
        """
        :type s: str
        :rtype: str
        """
        c = Counter(s)
        return ''.join(a * b for a, b in sorted(c.iteritems(), key=lambda x:-x[1]))
