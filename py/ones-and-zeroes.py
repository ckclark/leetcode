from collections import Counter
class Solution(object):
    def findMaxForm(self, strs, m, n):
        """
        :type strs: List[str]
        :type m: int
        :type n: int
        :rtype: int
        """
        str_counter = []
        for s in strs:
            c0 = s.count('0')
            str_counter.append((c0, len(s) - c0))
        table = Counter()
        table[m, n] = 0
        ans = 0
        for c0, c1 in str_counter:
            for (remm, remn), cnt in table.items():
                if c0 <= remm and c1 <= remn:
                    nxtm, nxtn = remm - c0, remn - c1
                    table[nxtm, nxtn] = max(table[nxtm, nxtn], cnt + 1)
                    ans = max(table[nxtm, nxtn], ans)
        return ans
