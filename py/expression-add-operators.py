from collections import defaultdict
class Solution(object):
    def dfs_ans(self, ans, depth, lans, ans_list):
        if depth == lans:
            yield ''.join(ans_list)
        else:
            if isinstance(ans[depth], set):
                for x in ans[depth]:
                    ans_list.append(x)
                    for y in self.dfs_ans(ans, depth + 1, lans, ans_list):
                        yield y
                    ans_list.pop()
            else:
                ans_list.append(ans[depth])
                for y in self.dfs_ans(ans, depth + 1, lans, ans_list):
                    yield y
                ans_list.pop()


    def dfs(self, dp, end, target, depth, cur, ans):
        if end == depth and cur == target:
            for x in self.dfs_ans(ans, 0, len(ans), []):
                yield x
        else:
            for nd in xrange(depth + 1, end + 1):
                for possible_v, possible_set in dp[depth, nd].iteritems():
                    if depth > 0:
                        ans.append('+')
                    ans.append(possible_set)
                    for x in self.dfs(dp, end, target, nd, cur + possible_v, ans):
                        yield x
                    ans.pop()
                    if depth > 0:
                        ans.pop()
                        for x in self.dfs(dp, end, target, nd, cur - possible_v, ans + ['-', possible_set]):
                            yield x

    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        dp = defaultdict(lambda:defaultdict(set))

        # merge phase
        lnum = len(num)
        for i in xrange(1, lnum + 1):
            for j in xrange(i):
                if num[j] != '0' or j + 1 == i:
                    dp[j, i][int(num[j:i])].add(num[j:i])

        # multiple phase
        for l in xrange(2, lnum + 1):
            for i in xrange(lnum - l + 1):
                for j in xrange(i + 1, i + l):
                    for a, a_set in dp[i, j].iteritems():
                        for b, b_set in dp[j, i + l].iteritems():
                            for a_ in a_set:
                                if '*' not in a_:
                                    for b_ in b_set:
                                        dp[i, i + l][a * b].add(a_ + '*' + b_)
        return list(self.dfs(dp, lnum, target, 0, 0, []))
