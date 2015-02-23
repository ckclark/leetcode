package leetcode.intersection_of_two_linked_lists;

import common.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
        	return null;
        }
        if(headA == headB)
        	return headA;
        ListNode endA = headA, endB = headB;
        while(endA.next != null)
        	endA = endA.next;
        while(endB.next != null)
        	endB = endB.next;
        if(endA != endB)
        	return null;
        ListNode end = endA;
        end.next = headA;
        ListNode tortoise = headB.next, hare = headB.next.next;
        while(tortoise != hare){
        	tortoise = tortoise.next;
        	hare = hare.next.next;
        }
        hare = headB;
        while(hare != tortoise){
        	hare = hare.next;
        	tortoise = tortoise.next;
        }
        end.next = null;
        return tortoise;
    }
}