from collections import Counter
class Solution(object):
    def findShortestSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        first = dict()
        last = dict()
        c = Counter()
        m = 0
        possible_values = []
        for i, v in enumerate(nums):
            first.setdefault(v, i)
            last[v] = i
            c[v] += 1
            if c[v] == m:
                possible_values.append(v)
            elif c[v] > m:
                possible_values = [v]
                m = c[v]

        return min(last[x] - first[x] + 1 for x in possible_values)
