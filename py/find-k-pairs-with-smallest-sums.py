import heapq
class Solution(object):
    def kSmallestPairs(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[List[int]]
        """
        l1, l2 = len(nums1), len(nums2)
        if l1 * l2 <= k:
            return sorted([[n1, n2] for n1 in nums1 for n2 in nums2], key=lambda x:x[0] + x[1])
        swapped = False
        heap = []
        for i in xrange(min(l1, k)):
            heap.append([nums1[i] + nums2[0], [i, 0]])
        ans = []
        heapq.heapify(heap)
        while len(ans) < k:
            s, idx = heapq.heappop(heap)
            idx1, idx2 = idx
            ans.append([nums1[idx1], nums2[idx2]])
            if idx2 + 1 < l2:
                idx2 += 1
                s = nums1[idx1] + nums2[idx2]
                heapq.heappush(heap, [s, [idx1, idx2]])
        return ans
