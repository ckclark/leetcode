class Solution(object):
    def optimalDivision(self, nums):
        """
        :type nums: List[int]
        :rtype: str
        """
        min_result, max_result = dict(), dict()
        lnums = len(nums)

        def find_cut(start, end, need_max):
            if start + 1 == end:
                return 0, (nums[start], 1)
            if need_max and (start, end) in max_result:
                return max_result[start, end]
            if not need_max and (start, end) in min_result:
                return min_result[start, end]

            if need_max:
                M, Mcut = None, None
                for cut in xrange(start + 1, end):
                    c1, v1 = find_cut(start, cut, True)
                    c2, v2 = find_cut(cut, end, False)
                    if M is None or v1[0] * v2[1] * M[1] > M[0] * v1[1] * v2[0]:
                        M, Mcut = (v1[0] * v2[1], v1[1] * v2[0]), cut
                max_result[start, end] = Mcut, M
                return max_result[start, end]
            else:
                m, mcut = None, None
                for cut in xrange(start + 1, end):
                    c1, v1 = find_cut(start, cut, False)
                    c2, v2 = find_cut(cut, end, True)
                    if m is None or v1[0] * v2[1] * m[1] < m[0] * v1[1] * v2[0]:
                        m, mcut = (v1[0] * v2[1], v1[1] * v2[0]), cut
                min_result[start, end] = mcut, m
                return min_result[start, end]

        def print_ans(start, end, need_max):
            if start + 1 == end:
                return str(nums[start])

            cut, val = find_cut(start, end, need_max)
            ans = print_ans(start, cut, need_max) + "/"
            if end - cut > 1:
                ans += "("
            ans += print_ans(cut, end, not need_max)
            if end - cut > 1:
                ans += ")"
            return ans

        return print_ans(0, lnums, True)
