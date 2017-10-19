from operator import itemgetter
class Solution(object):
    def findRelativeRanks(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        withRank = list(enumerate(sorted(list(enumerate(nums)), key=itemgetter(1), reverse=True), 1))
        top3 = ["Gold Medal", "Silver Medal", "Bronze Medal"]
        for i in xrange(min(len(withRank), 3)):
            withRank[i] = (top3[i], withRank[i][1])
        return map(lambda x:str(x[0]), sorted(withRank, key=lambda x:x[1][0]))

