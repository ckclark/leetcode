from collections import Counter
class Solution(object):
    def judgeCircle(self, moves):
        """
        :type moves: str
        :rtype: bool
        """
        c = Counter(moves)
        return c['L'] == c['R'] and c['U'] == c['D']
