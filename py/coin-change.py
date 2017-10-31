class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        min_count = [0] * (amount + 1)
        for c in coins:
            if c <= amount:
                min_count[c] = 1
        for i in xrange(min(coins), amount + 1):
            next_min = None
            for c in coins:
                if i == c or (i > c and min_count[i - c] > 0):
                    t = min_count[i - c] + 1
                    if next_min is None or t < next_min:
                        next_min = t
            if next_min is not None:
                min_count[i] = next_min

        if min_count[amount] == 0 and amount > 0:
            return -1
        else:
            return min_count[amount]
