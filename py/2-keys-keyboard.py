class Solution(object):
    def minSteps(self, n):
        """
        :type n: int
        :rtype: int
        """
        ans = [n] * (n + 1)
        ans[1] = 0
        for i in xrange(1, n + 1):
            for j in xrange(2, n / i + 1):
                ans[j * i] = min(ans[i] + j, ans[j * i])
        return ans[n]
