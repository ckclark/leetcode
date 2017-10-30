class Solution(object):
    def increasingTriplet(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        first, second = None, None
        for n in nums:
            if first is None or n <= first:
                first = n
            elif second is None or n <= second:
                second = n
            else:
                return True
        return False

