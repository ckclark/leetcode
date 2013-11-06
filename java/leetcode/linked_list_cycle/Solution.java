package leetcode.linked_list_cycle;

import common.ListNode;

public class Solution {
	public boolean hasCycle(ListNode head) {
        ListNode hare = head, tortoise = head;
        while(hare != null){
            hare = hare.next;
            if(hare == null) return false;
            hare = hare.next;
            tortoise = tortoise.next;
            if(hare == tortoise){
                return true;
            }
        }
        return false;
	}
}
