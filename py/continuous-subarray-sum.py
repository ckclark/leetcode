from collections import Counter
class Solution(object):
    def checkSubarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        if len(nums) < 2:
            return False
        k = abs(k)
        if k == 0:
            t1, t2 = iter(nums), iter(nums)
            t2.next()
            return any(x == y == 0 for x, y in zip(t1, t2))

        if len(nums) > (k - 1) * 2:
            return True
        visited = Counter()
        prev = None
        subsum = 0
        for n in nums:
            subsum = (subsum + n) % k
            if subsum == 0 and prev is not None:
                return True

            if visited[subsum] >= 2:
                return True
            elif visited[subsum] == 1 and prev != n:
                return True
            visited[subsum] += 1
            prev = n
        return False
