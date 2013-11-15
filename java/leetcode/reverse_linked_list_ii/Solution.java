package leetcode.reverse_linked_list_ii;

import common.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if(head == null) return null;
    	ListNode curRight = head;
    	for(int len = 0; len < n - m; len++){
    		curRight = curRight.next;
    	}
    	ListNode prevLeft = null;
    	ListNode curLeft = head;
    	for(int len = 0; len < m - 1; len++){
    		prevLeft = curLeft;
    		curLeft = curLeft.next;
    		curRight = curRight.next;
    	}
    	if(prevLeft == null){
    		head = curRight;
    	}else{
    		prevLeft.next = curRight;
    	}
    	for(int len = 0; len < n - m; len++){
    		ListNode next = curLeft.next;
    		curLeft.next = curRight.next;
    		curRight.next = curLeft;
    		curLeft = next;
    	}
    	return head;
    }
    
    public static void dump(ListNode node){
    	while(node != null){
    		System.err.print(node.val + "->");
    		node = node.next;
    	}
    	System.err.println("null");
    }
    
    public static void main(String[] args){
    	final int N = 10;
    	ListNode[] list = new ListNode[N];
    	for(int m = 1; m <= N; m++){
    		for(int n = m; n <= N; n++){
    			for(int i = 0; i < N; i++){
    				list[i] = new ListNode(i);
    				if(i > 0) list[i - 1].next = list[i];
    			}
    			dump(new Solution().reverseBetween(list[0], m, n));
    		}
    	}
    }
}
