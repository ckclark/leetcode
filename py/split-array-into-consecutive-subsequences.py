from itertools import groupby
class Solution(object):
    def isPossible(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        prev = None
        not_full_1, not_full_2, attach = 0, 0, 0
        for n, items in groupby(nums):
            cnt = len(list(items))
            if prev is None:
                not_full_1 = cnt
            elif prev + 1 == n:
                if not_full_1 + not_full_2 > cnt:
                    return False
                else:
                    cnt -= not_full_1 + not_full_2
                attach = min(attach, cnt)
                cnt -= attach
                not_full_1, not_full_2, attach = cnt, not_full_1, not_full_2 + attach
            else:
                if not_full_1 + not_full_2 > 0:
                    return False
                not_full_1, not_full_2, attach = cnt, 0, 0
            prev = n
        return not_full_1 + not_full_2 == 0
