# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
import heapq

class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        h = []
        for i, l in enumerate(lists):
            if l:
                node = l
                h.append((node.val, node, i))
                lists[i] = lists[i].next
        heapq.heapify(h)
        ret = None
        cur = ret
        while h:
            _, node, idx = heapq.heappop(h)
            if ret is None:
                ret = cur = node
            else:
                cur.next = node
                cur = node
            if lists[idx]:
                heapq.heappush(h, (lists[idx].val, lists[idx], idx))
                lists[idx] = lists[idx].next
        return ret

