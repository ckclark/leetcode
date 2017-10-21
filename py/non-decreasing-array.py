class Solution(object):
    def checkPossibility(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if not nums:
            return True

        l = len(nums)
        fixed = False
        for i in xrange(l):
            if i + 1 < l:
                if nums[i] > nums[i + 1]:
                    if fixed:
                        return False
                    if i + 2 >= l or i == 0:
                        pass
                    elif nums[i + 1] >= nums[i - 1]:
                        pass
                    else:
                        nums[i + 1] = nums[i]
                    fixed = True
        return True

