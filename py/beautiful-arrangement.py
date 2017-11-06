class Solution(object):
    def countArrangement(self, N):
        """
        :type N: int
        :rtype: int
        """
        table = dict()
        def dfs(cur, s):
            fs = frozenset(s)
            if (cur, fs) not in table:
                if not s:
                    table[cur, fs] = 1
                else:
                    ans = 0
                    for n in s:
                        if n % cur == 0 or cur % n == 0:
                            s.remove(n)
                            ans += dfs(cur + 1, s)
                            s.add(n)
                    table[cur, fs] = ans
            return table[cur, fs]
        return dfs(1, set(xrange(1, N + 1)))
