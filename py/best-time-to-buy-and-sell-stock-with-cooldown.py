class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(prices) < 2:
            return 0

        sell = 0
        sold = 0
        buy = -prices[0]

        for price in prices:
            next_sell = price + buy
            next_sold = max(sold, sell)
            next_buy = max(sold - price, buy)
            sell, sold, buy = next_sell, next_sold, next_buy
        return max(sell, sold)
