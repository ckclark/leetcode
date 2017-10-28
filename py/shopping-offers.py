from collections import Counter
from operator import mul
class Solution(object):
    def shoppingOffers(self, price, special, needs):
        """
        :type price: List[int]
        :type special: List[List[int]]
        :type needs: List[int]
        :rtype: int
        """
        c = Counter()
        c[tuple(needs)] = 0

        q = [(tuple(needs), 0)]

        min_offer = 0
        for need, depth in q:
            if depth < len(special):
                sp, p = special[depth][:-1], special[depth][-1]
                m = c[need]
                max_group = None
                q.append((need, depth + 1))
                for nv, sv in zip(need, sp):
                    if nv < sv:
                        break
                    if sv > 0:
                        if max_group is None or nv / sv < max_group:
                            max_group = nv / sv
                else:
                    for i in xrange(1, max_group + 1):
                        s_need = list(need)
                        orig = 0
                        for j, s in enumerate(sp):
                            s_need[j] -= s * i
                            orig += price[j] * s * i
                        used = p * i - orig
                        if c[tuple(s_need)] > m + used:
                            c[tuple(s_need)] = m + used
                            q.append((tuple(s_need), 1))
                            min_offer = min(min_offer, m + used)
        return sum(map(mul, price, needs)) + min_offer

print Solution().shoppingOffers([2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1])
