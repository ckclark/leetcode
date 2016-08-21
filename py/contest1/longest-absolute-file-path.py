class Solution(object):
    def lengthLongestPath(self, input):
        """
        :type input: str
        :rtype: int
        """
        l = input.split('\n')
        sublength = [0]
        ans = 0
        for entry in l:
            lall, lentry = len(entry), len(entry.lstrip('\t'))
            depth = lall - lentry + 1
            if len(sublength) <= depth:
                sublength.append(lentry + sublength[-1])
            else:
                sublength[depth] = lentry + sublength[depth - 1]
            if '.' in entry.lstrip():
                ans = max(ans, sublength[depth] + depth - 1)
        return ans
