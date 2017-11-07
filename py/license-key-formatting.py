class Solution(object):
    def licenseKeyFormatting(self, S, K):
        """
        :type S: str
        :type K: int
        :rtype: str
        """
        S = S.replace('-', '').upper()
        return '-'.join(S[max(0, i):i + K] for i in xrange(-((K - len(S)) % K), len(S), K))
