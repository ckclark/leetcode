class Solution(object):
    def deduceRemain(self, segment_tree, n):
        for l in segment_tree:
            if n < len(l):
                l[n] -= 1
            n >>= 1

    def countRemainFirstN(self, segment_tree, n):
        ans = 0
        for l in segment_tree:
            if n == 0:
                break
            if n & 1:
                ans += l[n - 1]
            n >>= 1
        return ans

    def countSmaller(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        size = len(nums)
        ans = [0] * size
        segment_tree = []
        segment_tree.append([1] * size)
        t = size / 2
        while t > 0:
            prev = segment_tree[-1]
            nxt = []
            segment_tree.append(nxt)
            for i in xrange(t):
                nxt.append(prev[i * 2] + prev[i * 2 + 1])
            t /= 2
        order = list(enumerate(nums))
        order.sort(key=lambda x:(-x[1], -x[0]))
        for idx, _ in order:
            ans[idx] = self.countRemainFirstN(segment_tree, size) - self.countRemainFirstN(segment_tree, idx + 1)
            self.deduceRemain(segment_tree, idx)
        return ans
