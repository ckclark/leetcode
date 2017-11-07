class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        stack = []
        lnum = len(nums)
        for i in xrange(lnum - 1, -1, -1):
            n = nums[i]
            while stack and stack[-1] <= n:
                stack.pop()
            stack.append(n)

        ans = [None] * lnum
        for i in xrange(lnum - 1, -1, -1):
            n = nums[i]
            while stack and stack[-1] <= n:
                stack.pop()
            if not stack:
                ans[i] = -1
            else:
                ans[i] = stack[-1]
            stack.append(n)
        return ans
