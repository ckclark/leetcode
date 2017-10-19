from collections import defaultdict
class Solution(object):
    def findRestaurant(self, list1, list2):
        """
        :type list1: List[str]
        :type list2: List[str]
        :rtype: List[str]
        """
        d1 = {x: i for (i, x) in enumerate(list1)}
        min_idxes = []
        min_idx_sum = len(list1) + len(list2)
        for i, r in enumerate(list2):
            if r in d1:
                if i + d1[r] < min_idx_sum:
                    min_idx_sum = i + d1[r]
                    min_idxes = [r]
                elif i + d1[r] == min_idx_sum:
                    min_idxes.append(r)
        return min_idxes
