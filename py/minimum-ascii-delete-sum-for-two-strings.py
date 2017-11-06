class Solution(object):
    def minimumDeleteSum(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: int
        """
        prev = [0]
        for c in s2:
            prev.append(prev[-1] + ord(c))
        for i1, c1 in enumerate(s1, 1):
            nxtRow = [0] * (len(s2) + 1)
            o1 = ord(c1)
            nxtRow[0] = o1 + prev[0]
            for i2, c2 in enumerate(s2, 1):
                if c1 == c2:
                    nxtRow[i2] = prev[i2 - 1]
                else:
                    o2 = ord(c2)
                    nxtRow[i2] = min(prev[i2] + o1, nxtRow[i2 - 1] + o2)
            prev = nxtRow
        return nxtRow[len(s2)]
