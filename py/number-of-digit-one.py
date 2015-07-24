class Solution:
    # @param {integer} n
    # @return {integer}
    def countDigitOne(self, n):
        if n <= 0:
            return 0
        ans = n / 10
        for i in xrange(n / 10 * 10, n + 1):
            ans += str(i).count('1')
        return ans + self.countDigitOne(n / 10 - 1) * 10

if __name__ == '__main__':
    print Solution().countDigitOne(1)

