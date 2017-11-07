from collections import Counter
class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        exec_time = Counter()
        stack = []
        for log in logs:
            id, type, t = log.split(':')
            id, t = int(id), int(t)
            if type == 'start':
                stack.append((id, t, t))
            else:
                cur_id, cur_start, cur_real_start = stack.pop()
                exec_time[cur_id] += t - cur_start + 1
                if stack:
                    nxt_id, nxt_start, real_start = stack.pop()
                    exec_time[nxt_id] += cur_real_start - nxt_start
                    stack.append((nxt_id, t + 1, real_start))
        return [exec_time[i] for i in xrange(n)]
