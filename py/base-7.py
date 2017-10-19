class Solution(object):
    def convertToBase7(self, num):
        """
        :type num: int
        :rtype: str
        """
        if num == 0:
            return "0"
        neg = "-" if num < 0 else ""
        num = abs(num)
        ans = []
        while num > 0:
            ans.append(num % 7)
            num /= 7
        return neg + ''.join(map(str, ans[::-1]))
