from collections import Counter
class Solution(object):
    def triangleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = filter(None, nums)
        if not nums:
            return 0
        c = Counter(nums)
        N = max(nums)
        buckets = [0] * (N + 1)
        for k, cnt in c.iteritems():
            buckets[k] += cnt
        for i in xrange(1, N + 1):
            buckets[i] += buckets[i - 1]

        s = sorted(c)
        ans = 0
        for i, n1 in enumerate(s):
            for j in xrange(i):
                n2 = s[j]
                n1_n2 = n1 + n2
                ans += c[n1] * c[n2] * (buckets[min(n1_n2 - 1, N)] - buckets[n1])
                ans += c[n2] * (c[n1] - 1) * c[n1] / 2
            ans += c[n1] * (c[n1] - 1) * (c[n1] - 2) / 6
            ans += c[n1] * (c[n1] - 1) / 2 * (buckets[min(n1 * 2 - 1, N)] - buckets[n1])
        return ans
