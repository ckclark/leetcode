class Solution(object):
    def reverseStr(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        ans = []
        for i in xrange(0, len(s), k * 2):
            ans.append(s[i:i + k][::-1] + s[i + k:i + 2 * k])
        return ''.join(ans)

