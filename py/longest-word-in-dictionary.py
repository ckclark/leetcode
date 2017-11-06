class Solution(object):
    def longestWord(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        words = sorted(words, key=lambda w:(len(w), w))
        prefix_dict = set()
        max_word = ''
        for w in words:
            if len(w) == 1 or w[:-1] in prefix_dict:
                prefix_dict.add(w)
                if len(w) > len(max_word) or w < max_word:
                    max_word = w
        return max_word
