class NumArray(object):
    def __init__(self, nums):
        """
        initialize your data structure here.
        :type nums: List[int]
        """
        self.segtree = [nums]
        while len(self.segtree[-1]) > 1:
            prev = self.segtree[-1]
            self.segtree.append([sum(prev[i * 2: i * 2 + 2]) for i in xrange((len(prev) + 1) / 2)])

    def update(self, i, val):
        """
        :type i: int
        :type val: int
        :rtype: int
        """
        diff = self.segtree[0][i] - val
        if diff != 0:
            for l in self.segtree:
                l[i] -= diff
                i >>= 1


    def sumRange(self, i, j):
        """
        sum of elements nums[i..j], inclusive.
        :type i: int
        :type j: int
        :rtype: int
        """
        return self.subSumRange(j + 1) - self.subSumRange(i)

    def subSumRange(self, n):
        ans = 0
        i = 0
        while n > 0:
            if n & 1:
                ans += self.segtree[i][n - 1]
            n >>= 1
            i += 1
        return ans
