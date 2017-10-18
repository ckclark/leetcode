from operator import add
class Solution(object):
    def matrixReshape(self, nums, r, c):
        """
        :type nums: List[List[int]]
        :type r: int
        :type c: int
        :rtype: List[List[int]]
        """
        if len(nums) == 0:
            return nums
        origR = len(nums)
        origC = len(nums[0])
        if origR * origC != r * c:
            return nums
        oneline = reduce(add, nums)
        return map(list, zip(*([iter(oneline)] * c)))
