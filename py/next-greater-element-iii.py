class Solution(object):
    def nextGreaterElement(self, n):
        """
        :type n: int
        :rtype: int
        """
        s = str(n)
        for i, n in enumerate(reversed(s[:-1]), 1):
            if n < s[-i]:
                x, j = min((x, k) for k, x in enumerate(s[-i:]) if x > n)
                ans = s[:-i - 1]
                ans += x
                l = list(s[-i:])
                l[j] = n
                ans += ''.join(sorted(l))
                ans = int(ans)
                if ans >= 1 << 31:
                    return -1
                return ans
        else:
            return -1
