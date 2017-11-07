from collections import Counter
class Solution(object):
    def characterReplacement(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        c = Counter()
        lo = 0
        M = 0
        for hi, char in enumerate(s):
            c[char] += 1
            most_common_count = c.most_common(1)[0][1]
            if (hi - lo + 1) - most_common_count > k:
                c[s[lo]] -= 1
                lo += 1
            M = max(M, hi - lo + 1)
        return M

