class Solution(object):
    def repeatedStringMatch(self, A, B):
        """
        :type A: str
        :type B: str
        :rtype: int
        """
        lA, lB = len(A), len(B)
        if lA >= lB:
            if B in A:
                return 1
            if B in A + A:
                return 2
        else:
            L = (lB + (lA - 1)) / lA
            print A * L
            if B in A * L:
                return L
            R = L - ((L - (lB - lB / lA * lA)) % L)
            print A[-R:] + A + A[:R]
            if B in A[-R:] + A + A[:R]:
                return L + 1
        return -1
