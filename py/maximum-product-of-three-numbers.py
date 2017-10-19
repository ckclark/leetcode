from operator import mul
import heapq
class Solution(object):
    def maximumProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        largest3 = heapq.nlargest(3, nums)
        smallest3 = heapq.nsmallest(3, nums)
        if largest3[0] <= 0:
            if largest3[0] == 0:
                return 0
            else:
                return reduce(mul, largest3)
        elif largest3[1] <= 0:
            if smallest3[1] < 0:
                return smallest3[0] * smallest3[1] * largest3[0]
            else:
                return 0
        elif largest3[2] <= 0:
            if smallest3[1] < 0:
                return smallest3[0] * smallest3[1] * largest3[0]
            else:
                return reduce(mul, largest3)
        else:
            if smallest3[1] < 0:
                return max(smallest3[0] * smallest3[1] * largest3[0], reduce(mul, largest3))
            else:
                return reduce(mul, largest3)

