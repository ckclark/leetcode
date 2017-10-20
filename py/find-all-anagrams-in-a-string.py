class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        ls, lp = len(s), len(p)
        P = 100000007
        inv = dict()
        for o in xrange(ord('a'), ord('z') + 1):
            inv[o] = pow(o, P - 2, P)

        if ls < lp:
            return []
        pxored = 0
        psubsum = 0
        pproduct = 1

        for c in p:
            pxored ^= ord(c)
            psubsum += ord(c)
            pproduct = (pproduct * ord(c)) % P

        ans = []
        sxored = 0
        ssubsum = 0
        sproduct = 1
        for i, c in enumerate(s, -(lp - 1)):
            sxored ^= ord(c)
            ssubsum += ord(c)
            sproduct = (sproduct * ord(c)) % P

            if i >= 0:
                if (pxored, psubsum, pproduct) == (sxored, ssubsum, sproduct):
                    ans.append(i)
                ord_head = ord(s[i])
                sxored ^= ord_head
                ssubsum -= ord_head
                sproduct = (sproduct * inv[ord_head]) % P

        return ans
