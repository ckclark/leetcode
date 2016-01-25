package leetcode.odd_even_linked_list;

import common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        ListNode odd = head;
        ListNode even, even_head;
        even = even_head = head.next;
        ListNode cur = even;
        while(cur.next != null){
            odd = odd.next = cur = cur.next;
            if(cur.next != null){
                even = even.next = cur = cur.next;
            }
        }
        even.next = null;
        odd.next = even_head;
        return head;
    }
}