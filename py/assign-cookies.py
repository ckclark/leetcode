from collections import Counter
class Solution(object):
    def findContentChildren(self, children, s):
        """
        :type g: List[int]
        :type s: List[int]
        :rtype: int
        """
        if not s:
            return 0
        cookies = Counter(s)
        it = iter(sorted(cookies))
        cur = it.next()
        children.sort()
        ans = 0
        try:
            for child in children:
                while cookies[cur] <= 0 or cur < child:
                    cur = it.next()
                cookies[cur] -= 1
                ans += 1
        except StopIteration:
            pass
        return ans


