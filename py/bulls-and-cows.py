class Solution(object):
    def getHint(self, secret, guess):
        """
        :type secret: str
        :type guess: str
        :rtype: str
        """
        count_secret = [0] * 10
        count_guess = [0] * 10
        A, B = 0, 0
        for s, g in zip(secret, guess):
            if s == g:
                A += 1
            else:
                count_secret[int(s)] += 1
                count_guess[int(g)] += 1
        for i in xrange(10):
            B += min(count_secret[i], count_guess[i])
        return '%dA%dB' % (A, B)
