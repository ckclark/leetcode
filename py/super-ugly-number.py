import heapq

class Solution(object):
    def nthSuperUglyNumber(self, n, primes):
        """
        :type n: int
        :type primes: List[int]
        :rtype: int
        """
        ugly_numbers = [1]

        items = [(p, p, 0) for p in primes]

        heapq.heapify(primes)

        for i in xrange(n - 1):
            nxt_ugly, p, pivot = heapq.heappop(items)
            ugly_numbers.append(nxt_ugly)
            pivot += 1
            smallest = (p * ugly_numbers[pivot], p, pivot)
            heapq.heappush(items, smallest)
            while items[0][0] == nxt_ugly:
                smallest = heapq.heappop(items)
                u, p, pivot = smallest
                heapq.heappush(items, (p * ugly_numbers[pivot + 1], p, pivot + 1))

        return ugly_numbers[-1]

