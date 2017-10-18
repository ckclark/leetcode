from collections import defaultdict
class Solution(object):
    def nextGreaterElement(self, findNums, nums):
        """
        :type findNums: List[int]
        :type nums: List[int]
        :rtype: List[int]
        """
        next_greater = defaultdict(lambda: -1)
        stack = []
        for n in nums:
            while stack and stack[-1] < n:
                next_greater[stack[-1]] = n
                stack.pop()
            stack.append(n)
        return map(next_greater.__getitem__, findNums)

