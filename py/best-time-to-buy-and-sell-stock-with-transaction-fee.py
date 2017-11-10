class Solution(object):
    def maxProfit(self, prices, fee):
        """
        :type prices: List[int]
        :type fee: int
        :rtype: int
        """
        hold, not_hold = None, 0
        for p in prices:
            hold, not_hold = max(hold, not_hold - p - fee), max(not_hold, None if hold is None else hold + p)
        return max(hold, not_hold)
