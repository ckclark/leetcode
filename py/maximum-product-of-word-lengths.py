from operator import or_

class Solution(object):
    def maxProduct(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        words = filter(None, words)
        if not words:
            return 0
        words.sort(key=len, reverse=True)
        lenwords = map(len, words)
        bitval = [reduce(or_, map(lambda x:1 << (ord(x) - ord('a')), word)) for word in words]
        size = len(words)

        ans = 0
        for i in xrange(size):
            if lenwords[i] * lenwords[i] <= ans: break
            for j in xrange(i + 1, size):
                if not (bitval[i] & bitval[j]):
                    ans = max(ans, lenwords[i] * lenwords[j])
                    break
        return ans
