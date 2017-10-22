class Solution(object):
    def numberOfArithmeticSlices(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        lA = len(A)
        if lA < 3:
            return 0
        p, q = 0, 0
        ans = 0
        while p < lA - 2:
            if A[p + 1] * 2 != A[p] + A[p + 2]:
                p += 1
            else:
                q = p
                while q < lA - 2 and A[q + 1] * 2 == A[q] + A[q + 2]:
                    q += 1
                l = q + 2 - p
                ans += (l - 1) * (l - 2) / 2
                p = q
        return ans
