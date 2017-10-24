class Solution(object):
    def countSubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        P = 10 ** 9 + 7
        Q = 65535
        inv = lambda x: pow(x % P, P - 2, P)

        ls = len(s)
        ans = 0
        Q_inv = inv(Q)
        for lp in xrange(1, ls + 1):
            lrolling, rrolling = 0, 0

            for i in xrange(lp):
                losi = ord(s[i])
                rosi = ord(s[lp - 1 - i])

                lrolling = (lrolling * Q + losi) % P
                rrolling = (rrolling * Q + rosi) % P

            Q_lp = pow(Q, lp, P)
            for i in xrange(lp, ls):
                if lrolling == rrolling:
                    ans += 1
                losi = ord(s[i - lp])
                rosi = ord(s[i])

                lrolling = (lrolling * Q + rosi + ((P - losi) * Q_lp)) % P
                rrolling = ((rrolling + P - losi + rosi * Q_lp) * Q_inv) % P

            if lrolling == rrolling:
                ans += 1
        return ans
