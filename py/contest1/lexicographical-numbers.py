class Solution(object):
    def lexicalOrder(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        ans = []
        cur = 1
        while len(ans) < n:
            ans.append(cur)
            if cur * 10 <= n:
                cur = cur * 10
            elif cur + 1 <= n and cur % 10 != 9:
                cur = cur + 1
            else:
                cur /= 10
                while cur % 10 == 9:
                    cur /= 10
                cur += 1
        return ans
