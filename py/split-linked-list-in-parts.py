# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def splitListToParts(self, root, k):
        """
        :type root: ListNode
        :type k: int
        :rtype: List[ListNode]
        """
        n = 0
        cur = root
        while cur:
            n += 1
            cur = cur.next
        group_size, rem = n / k, n % k
        ans = []
        cur = root
        prev = None
        for group in xrange(k):
            gs = group_size + int(group < rem)
            ans.append(cur)
            while gs > 0:
                prev, cur = cur, cur.next
                gs -= 1
            if prev:
                prev.next = None
        return ans
