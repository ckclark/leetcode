class Solution(object):
    def findWords(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        rows = [
                set('qwertyuiop'),
                set('asdfghjkl'),
                set('zxcvbnm'),
                ]
        return filter(lambda w: not all([len(set(w.lower()) - r) for r in rows]), words)
