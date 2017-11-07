class Solution(object):
    def magicalString(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 0:
            return 0
        elif n <= 3:
            return 1
        q = [1, 2, 2]
        cur = 1
        skip = 2
        cnt_1 = 1
        total_cnt = 3
        for v in q:
            if skip <= 0:
                q += [cur] * v
                v = min(n - total_cnt, v)
                total_cnt += v
                if cur == 1:
                    cnt_1 += v
                if total_cnt == n:
                    return cnt_1
                cur = 3 - cur
            skip -= 1
