class Solution(object):
    def superPow(self, a, b):
        """
        :type a: int
        :type b: List[int]
        :rtype: int
        """
        MODULI = 1337
        if a == 0:
            return 0
        ans = 1
        for n in b:
            ans = pow(ans, 10, MODULI)
            ans = (ans * pow(a, n, MODULI)) % MODULI
        return ans
