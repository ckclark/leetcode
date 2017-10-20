class Solution(object):
    def findUnsortedSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        stackl, stackr = [], []
        stopl, stopr = False, False
        for i, n in enumerate(nums):
            if not stackl or stackl[-1] <= n:
                if not stopl:
                    stackl.append(n)
            else:
                while stackl and stackl[-1] > n:
                    stackl.pop()
                stopl = True
        for i in xrange(len(nums) - 1, -1, -1):
            n = nums[i]
            if not stackr or stackr[-1] >= n:
                if not stopr:
                    stackr.append(n)
            else:
                while stackr and stackr[-1] < n:
                    stackr.pop()
                stopr = True
        return max(len(nums) - len(stackl) - len(stackr), 0)

