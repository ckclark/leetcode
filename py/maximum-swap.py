class Solution(object):
    def maximumSwap(self, num):
        """
        :type num: int
        :rtype: int
        """
        counter = [0] * 10
        snum = str(num)
        lnum = len(snum)
        for d in map(int, snum):
            counter[d] += 1
        for i, d in enumerate(map(int, snum)):
            for di in xrange(9, d, -1):
                if counter[di] > 0:
                    for j in xrange(lnum - 1, i, -1):
                        if int(snum[j]) == di:
                            return int(snum[:i] + snum[j] + snum[i + 1:j] + snum[i] + snum[j + 1:])
            counter[d] -= 1
        return num
