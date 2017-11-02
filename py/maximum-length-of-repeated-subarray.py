class Solution(object):
    def findLength(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: int
        """
        lA, lB = len(A), len(B)
        if lA > lB:
            lA, lB = lB, lA
            A, B = B, A
        ans = 0
        prev = [0] * (lA + 1)
        for b in B:
            ary = [0] * (lA + 1)
            for j, a in enumerate(A, 1):
                if a == b:
                    ary[j] = prev[j - 1] + 1
                    ans = max(ans, ary[j])
            prev = ary
        return ans
