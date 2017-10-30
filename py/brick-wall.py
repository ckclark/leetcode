import heapq
class Solution(object):
    def leastBricks(self, wall):
        """
        :type wall: List[List[int]]
        :rtype: int
        """
        n_row = len(wall)
        heap = [(wall[i][0], i, 0) for i in xrange(n_row)]
        heapq.heapify(heap)
        max_noncross = 0
        while True:
            l, idx, offset = heapq.heappop(heap)
            cur_l = l
            if offset == len(wall[idx]) - 1:
                break
            heapq.heappush(heap, (l + wall[idx][offset + 1], idx, offset + 1))
            cnt = 1
            while True:
                ol, oidx, ooffset = heapq.heappop(heap)
                if ol == l:
                    cnt += 1
                    heapq.heappush(heap, (ol + wall[oidx][ooffset + 1], oidx, ooffset + 1))
                elif ol > l:
                    heapq.heappush(heap, (ol, oidx, ooffset))
                    break
            max_noncross = max(max_noncross, cnt)
        return n_row - max_noncross
