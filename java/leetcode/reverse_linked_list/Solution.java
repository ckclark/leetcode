package leetcode.reverse_linked_list;

import common.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev, cur;
        cur = head;
        prev = null;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}
