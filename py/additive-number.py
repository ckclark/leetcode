class Solution(object):
    def isAdditiveNumberInternal(self, num, l1, l2):
        n1 = num[:l1]
        n2 = num[l1:l1 + l2]
        if (len(n1) > 1 and n1[0] == '0') or (len(n2) > 1 and n2[0] == '0'):
            return False
        n1, n2 = int(n1), int(n2)
        cur = l1 + l2
        while True:
            if cur == len(num): return True
            nxt = n1 + n2
            lnxt = len(str(nxt))
            if num[cur:cur + lnxt] == str(nxt):
                n1, n2 = n2, nxt
                cur += lnxt
            else:
                break
        return False

    def isAdditiveNumber(self, num):
        """
        :type num: str
        :rtype: bool
        """
        if len(num) < 3:
            return False
        for l1 in xrange(1, len(num) / 2 + 1):
            for l2 in xrange(1, (len(num) - l1) / 2 + 1):
                if len(num) - l1 - l2 < max(l1, l2):
                    break
                if self.isAdditiveNumberInternal(num, l1, l2):
                    return True
        return False
