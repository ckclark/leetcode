class Solution(object):
    def checkPerfectNumber(self, num):
        """
        :type num: int
        :rtype: bool
        """
        MersennePrime = [3, 7, 31, 127, 8191, 131071, 524287]
        MPp = [2, 3, 5, 7, 13, 17, 19]
        perfectnumbers = set(map(lambda a, b:a * (1 << (b - 1)), MersennePrime, MPp))
        return num in perfectnumbers
