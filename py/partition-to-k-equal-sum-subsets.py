class Solution(object):
    def canPartitionKSubsets(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        s = sum(nums)
        if s % k != 0:
            return False
        target = s / k
        lnums = len(nums)
        fail = set()
        nums.sort(reverse=True)
        def dfs(groups, cur, flag):
            if groups == k - 1:
                return True
            for i in xrange(lnums):
                n = nums[i]
                if (1 << i) & flag == 0 and flag | (1 << i) not in fail:
                    if cur + n <= target:
                        if dfs(groups + (cur + n) / target, (cur + n) % target, flag | (1 << i)):
                            return True
            fail.add(flag)
            return False

        return dfs(0, 0, 0)
