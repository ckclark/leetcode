from collections import Counter
class Solution(object):
    def removeDuplicateLetters(self, s):
        """
        :type s: str
        :rtype: str
        """
        count = Counter(s)
        stack = []
        used = set()
        for c in s:
            count[c] -= 1
            if c not in used:
                while stack and stack[-1] > c and count[stack[-1]] > 0:
                    p = stack.pop()
                    used.remove(p)
                stack.append(c)
                used.add(c)
        return ''.join(stack)
