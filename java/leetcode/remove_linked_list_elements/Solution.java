package leetcode.remove_linked_list_elements;

import common.ListNode;


public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode ret = null;
        while(head != null && head.val == val){
            head = head.next;
        }
        ret = head;
        while(head != null){
            while(head.next != null && head.next.val == val){
                head.next = head.next.next;
            }
            head = head.next;
        }
        return ret;
    }
}