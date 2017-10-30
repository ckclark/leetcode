class Solution(object):
    def isOneBitCharacter(self, bits):
        """
        :type bits: List[int]
        :rtype: bool
        """
        s0, s1 = True, False
        for i, b in enumerate(bits[:-1]):
            if b == 1:
                s0, s1 = s1 and bits[i - 1] == 1, s0
            else:
                s0, s1 = True, False
        return s0

