class Solution(object):
    def checkRecord(self, s):
        """
        :type s: str
        :rtype: bool
        """
        A = False
        L = 0
        for c in s:
            if c == 'L':
                L += 1
                if L > 2:
                    return False
            else:
                L = 0
                if c == 'A':
                    if A:
                        return False
                    else:
                        A = True

        return True
