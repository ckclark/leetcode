package leetcode.insertion_sort_list;

import java.util.Random;

import common.ListNode;

public class Solution {
	public ListNode insertionSortList(ListNode head) {
		if(head == null) return null;
		ListNode cur = head;
		ListNode prev = null;
        while(cur != null){
        	ListNode insertPrev = null;
        	ListNode insertNext = head;
        	ListNode next = cur.next;
        	while(insertNext != null && cur.val > insertNext.val){
        		insertPrev = insertNext;
        		insertNext = insertPrev.next;
        	}
        	if(prev != null){
        		prev.next = next;
        	}else{
        		head = next;
        	}
        	if(insertPrev == null){
        		insertNext = head;
        		head = cur;
        	}else{
        		insertNext = insertPrev.next;
        		insertPrev.next = cur;
        	}
        	cur.next = insertNext;
        	if(prev != null && prev.next != next)
        		prev = cur;
        	else if(prev == null){
        		prev = cur;
        	}
        	cur = next;
        }
        return head;
    }
	
	public static void dump(ListNode head){
		System.err.println("dump");
		while(head != null){
			System.err.print(head.val + " ");
			head = head.next;
		}
		System.err.println("");
	}
	
	public static void main(String[] args){
		final int N = 2, SIZE = 10;
		Random r = new Random();
		ListNode[] input = new ListNode[N];
		for(int i = 0; i < N; i++){
			input[i] = new ListNode(r.nextInt(SIZE));
			if(i > 0) input[i - 1].next = input[i];
		}
		dump(input[0]);
		dump(new Solution().insertionSortList(input[0]));
	}
}
