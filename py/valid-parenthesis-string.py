class Solution(object):

    def checkValidString(self, s):
        """
        :type s: str
        :rtype: bool
        """
        lowest, highest = 0, 0
        for c in s:
            if c == '(':
                lowest += 1
                highest += 1
            elif c == ')':
                if lowest > 0:
                    lowest -= 1
                highest -= 1
                if highest < 0:
                    return False
            else:
                if lowest > 0:
                    lowest -= 1
                highest += 1
        return lowest == 0
