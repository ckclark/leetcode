package leetcode.rotate_list;

import common.ListNode;

public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
    	if(head == null) return head;
    	int length = 0;
    	ListNode cur = head;
    	ListNode tail = null;
    	while(cur != null){
    		length++;
    		tail = cur;
    		cur = cur.next;
    	}
    	int shift = (length - (n % length)) % length;
    	ListNode nHead = head;
    	ListNode prev = null;
    	while(shift > 0){
    		prev = nHead;
    		nHead = nHead.next;
    		shift--;
    	}
    	if(prev != null){
    		 tail.next = head;
    		 prev.next = null;
    		 head = nHead;
    	}
    	return head;
    }
    
    public static void dump(ListNode cur){
    	while(cur != null){
    		System.err.print(cur.val + "->");
    		cur = cur.next;
    	}
    	System.err.println("null");
    }
    
    public static void main(String args[]){
    	final int N = 1;
    	dump(new Solution().rotateRight(null, 10));
    	for(int shift = 0; shift < 12; shift++){
    		ListNode[] list = new ListNode[N];
    		for(int i = 0; i < N; i++){
    			list[i] = new ListNode(i);
    			if(i > 0) list[i - 1].next = list[i];
    		}
    		dump(new Solution().rotateRight(list[0], shift));
    	}
    }
}
