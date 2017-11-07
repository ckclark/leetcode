from collections import Counter
class Solution(object):
    def fourSumCount(self, A, B, C, D):
        """
        :type A: List[int]
        :type B: List[int]
        :type C: List[int]
        :type D: List[int]
        :rtype: int
        """
        count1 = Counter()
        for a in A:
            for b in B:
                count1[a + b] += 1
        ans = 0
        for c in C:
            for d in D:
                ans += count1[-(c + d)]
        return ans
