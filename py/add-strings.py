class Solution(object):
    def addStrings(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        l1, l2 = len(num1), len(num2)
        if l1 > l2:
            l1, l2 = l2, l1
            num1, num2 = num2, num1

        carry = 0
        out = []
        for i in xrange(1, l1 + 1):
            s = int(num1[-i]) + int(num2[-i]) + carry
            out.append(s % 10)
            carry = s / 10
        for i in xrange(l1 + 1, l2 + 1):
            s = int(num2[-i]) + carry
            out.append(s % 10)
            carry = s / 10
        if carry:
            out.append(carry)
        return ''.join(map(str, out[::-1]))
