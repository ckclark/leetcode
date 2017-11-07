class Solution(object):
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        prev = [0] * (len(word2) + 1)
        for i, c1 in enumerate(word1, 1):
            nxt = [0] * (len(word2) + 1)
            for j, c2 in enumerate(word2, 1):
                if c1 == c2:
                    nxt[j] = prev[j - 1] + 1
                else:
                    nxt[j] = max(nxt[j - 1], prev[j])
            prev = nxt
        return len(word2) + len(word1) - 2 * prev[len(word2)]
