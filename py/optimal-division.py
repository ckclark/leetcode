from fractions import Fraction
class Solution(object):
    def optimalDivision(self, nums):
        """
        :type nums: List[int]
        :rtype: str
        """
        min_result, max_result = dict(), dict()
        min_offset, max_offset = dict(), dict()
        lnums = len(nums)
        def print_ans(start, end, need_max=True):
            if start + 1 == end:
                return str(nums[start])

            if need_max:
                cut = max_offset[start, end]
            else:
                cut = min_offset[start, end]
            ans = print_ans(start, cut, need_max) + "/"
            if end - cut > 1:
                ans += "("
            ans += print_ans(cut, end, not need_max)
            if end - cut > 1:
                ans += ")"
            return ans

        for i, n in enumerate(nums):
            min_result[i, i + 1] = max_result[i, i + 1] = Fraction(n)

        for l in xrange(2, lnums + 1):
            for i in xrange(lnums - l + 1):
                m, M = None, None
                mj, Mj = None, None
                for j in xrange(1, l):
                    tm = min_result[i, i + j] / max_result[i + j, i + l]
                    tM = max_result[i, i + j] / min_result[i + j, i + l]
                    if m is None or m > tm:
                        m, mj = tm, i + j
                    if M is None or M < tM:
                        M, Mj = tM, i + j
                min_result[i, i + l] = m
                max_result[i, i + l] = M
                min_offset[i, i + l] = mj
                max_offset[i, i + l] = Mj
        return print_ans(0, lnums)
