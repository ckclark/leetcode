import bisect

class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        min_tail_for_length = []
        for x in nums:
            i = bisect.bisect_left(min_tail_for_length, x)
            if i == len(min_tail_for_length):
                min_tail_for_length.append(x)
            else:
                min_tail_for_length[i] = x
        return len(min_tail_for_length)

