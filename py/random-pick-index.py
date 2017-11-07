from random import random
class Solution(object):

    def __init__(self, nums):
        """
        :type nums: List[int]
        :type numsSize: int
        """
        self.nums = nums

    def pick(self, target):
        """
        :type target: int
        :rtype: int
        """
        meet = 0
        choice = None
        for i, n in enumerate(self.nums):
            if n == target:
                meet += 1
                if random() * meet < 1:
                    choice = i
        return choice



# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.pick(target)
