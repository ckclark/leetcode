# Definition for singly-linked list.
#class ListNode(object):
#    def __init__(self, x):
#        self.val = x
#        self.next = None

class Solution(object):
    def oddEvenList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None:
            return head
        if head.next is None:
            return head
        odd, even_head = head, head.next
        even = even_head
        cur = even
        while cur.next is not None:
            odd.next = cur.next
            odd = odd.next
            cur = cur.next
            if cur.next is not None:
                even.next = cur.next
                even = even.next
                cur = cur.next
        even.next = None
        odd.next = even_head
        return head
