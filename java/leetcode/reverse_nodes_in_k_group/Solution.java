package leetcode.reverse_nodes_in_k_group;

import common.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1) return head;
        
        ListNode prev = null;
        while(true){
        	ListNode groupHead;
        	if(prev == null){
        		groupHead = head;
        	}else{
        		groupHead = prev.next;
        	}
        	if(groupHead == null) return head;
        	ListNode groupTail = groupHead;
        	int steps;
        	for(steps = 0; steps < k - 1 && groupTail.next != null; steps++){
        		groupTail = groupTail.next;
        	}
        	if(steps < k - 1) return head;
        	else{
        		ListNode groupNext = groupHead.next;
        		ListNode groupPrev = groupHead;
        		for(int i = 0; i < k - 1; i++){
        			ListNode groupTmp = groupNext.next;
        			groupNext.next = groupHead;
        			groupPrev.next = groupTmp;
        			groupHead = groupNext;
        			groupTail = groupPrev;
        			groupNext = groupTmp;
        		}
        		if(prev == null){
        			head = groupHead;
        		}else{
        			prev.next = groupHead;
        		}
        		prev = groupTail;
        	}
        }
    }
    
    public static void dump(ListNode head){
    	while(head != null){
    		System.err.print(head.val + "->");
    		head = head.next;
    	}
    }
    public static void main(String[] args){
    	final int N = 3;
    	ListNode[] list = new ListNode[N];
    	for(int i = 0; i < N; i++){
    		list[i] = new ListNode(i);
    		if(i > 0) list[i - 1].next = list[i];
    	}
    	dump(new Solution().reverseKGroup(list[0], 4));
    }
}
