import Queue

class Solution(object):
    def findMinHeightTrees(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: List[int]
        """

        neighbors = [[] for _ in xrange(n)]
        for (s, t) in edges:
            neighbors[s].append(t)
            neighbors[t].append(s)
        q = Queue.Queue()
        q.put(0)
        visit = {0}

        while not q.empty():
            cur = q.get()
            farthest = cur
            for neighbor in neighbors[cur]:
                if neighbor not in visit:
                    q.put(neighbor)
                    visit.add(neighbor)

        mht_height = 0
        stack = [farthest]
        visit = {farthest}
        while stack:
            cur = stack[-1]
            l = len(stack)
            if l > mht_height:
                if l % 2 == 0:
                    ans = [stack[l / 2], stack[(l - 1) / 2]]
                else:
                    ans = [stack[l / 2]]
                mht_height = l

            for neighbor in neighbors[cur]:
                if neighbor not in visit:
                    stack.append(neighbor)
                    visit.add(neighbor)
                    break
            else:
                stack.pop()
        return ans

