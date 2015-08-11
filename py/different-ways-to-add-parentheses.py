import re
from collections import defaultdict
from operator import __mul__, __sub__, __add__
from itertools import product

class Solution:
    # @param {string} input
    # @return {integer[]}
    def diffWaysToCompute(self, input):
        opmap = {
            '+': __add__,
            '-': __sub__,
            '*': __mul__,
        }
        pat = re.compile(r'(?<=\d)[+\-*]')
        operands = map(int, pat.split(input))
        operators = map(opmap.get, pat.findall(input))
        l = len(operands)
        d = defaultdict(list)
        for i in xrange(l):
            d[i, 1] = [operands[i]]

        for subl in xrange(2, l + 1):
            for left in xrange(0, l - subl + 1):
                for right in xrange(left + 1, left + subl):
                    llist = d[left, right - left]
                    rlist = d[right, subl - (right - left)]
                    op = operators[right - 1]
                    d[left, subl].extend([op(loprand, roprand) for loprand, roprand in product(llist, rlist)])
        return d[0, l]

if __name__ == '__main__':
    print Solution().diffWaysToCompute('2*3-4*5')
