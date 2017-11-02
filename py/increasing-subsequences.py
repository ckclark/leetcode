class Solution(object):
    def findSubsequences(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        lnums = len(nums)
        def dfs(idx, cur):
            if idx == lnums:
                if len(cur) > 1:
                    yield tuple(cur)
            else:
                for x in dfs(idx + 1, cur):
                    yield x
                if not cur or nums[idx] >= cur[-1]:
                    cur.append(nums[idx])
                    for x in dfs(idx + 1, cur):
                        yield x
                    cur.pop()
        return map(list, set(dfs(0, [])))
