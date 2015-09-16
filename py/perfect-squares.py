class Solution(object):
    def numSquares(self, n, table=[0]):
        """
        :type n: int
        :rtype: int
        """
        if len(table) >= n + 1:
            return table[n]

        if n % 8 == 3 or n % 8 == 6:
            return 3
        if n % 8 == 7:
            return 4

        for i in xrange(len(table), n + 1):
            table.append(4)
            sqrt = int((i + 1) ** .5)
            if sqrt * sqrt == i:
                table[i] = 1
            else:
                table[i] = 4
                j = 1
                while j <= i / j:
                    table[i] = min(table[i], table[i - j * j] + 1)
                    if table[i] == 2:
                        break
                    j += 1
        return table[n]
