package leetcode.linked_list_cycle_ii;

import common.ListNode;

public class Solution {
	public ListNode detectCycle(ListNode head) {
		if(head == null) return null;
		ListNode tortoise = head, hare = head;
		while(hare != null){
			tortoise = tortoise.next;
			hare = hare.next;
			if(hare == null) break;
			hare = hare.next;
			if(hare == tortoise){
				break;
			}
		}
		if(hare == null) return null;
		tortoise = head;
		while(hare != tortoise){
			hare = hare.next;
			tortoise = tortoise.next;
		}
		return hare;
	}
}
