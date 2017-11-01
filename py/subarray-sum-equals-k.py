from collections import Counter
class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        subsum = [0]
        for i, n in enumerate(nums):
            subsum.append(subsum[-1] + n)

        c = Counter()
        ans = 0
        for i, n in enumerate(subsum):
            if n - k in c:
                ans += c[n - k]
            c[n] += 1
        return ans
