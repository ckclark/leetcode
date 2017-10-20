class Solution(object):
    def findMaxAverage(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: float
        """
        s = sum(nums[:k])
        m = s
        for i in xrange(k, len(nums)):
            s += nums[i] - nums[i - k]
            m = max(m, s)
        return float(m) / k

