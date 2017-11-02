class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        pos = {0: -1}
        v = 0
        ans = 0
        for i, n in enumerate(nums):
            v += n * 2 - 1
            if v in pos:
                ans = max(ans, i - pos[v])
            else:
                pos[v] = i
        return ans
