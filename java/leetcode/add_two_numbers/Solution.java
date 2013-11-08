package leetcode.add_two_numbers;

import common.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if(l1 == null) return l2;
    	if(l2 == null) return l1;
    	int carry = 0;
    	ListNode head = null;
    	ListNode prev = null;
    	while(l1 != null || l2 != null || carry != 0){
    		int v = 0;
    		if(l1 != null){
    			v += l1.val;
    			l1 = l1.next;
    		}
    		if(l2 != null){
    			v += l2.val;
    			l2 = l2.next;
    		}
    		ListNode digit= new ListNode((v + carry) % 10);
    		carry = (v + carry) / 10;
    		if(prev == null){
    			head = prev = digit;
    		}else{
    			prev.next = digit;
    			prev = digit;
    		}
    	}
    	return head;
    }
    
    public static void dump(ListNode head){
    	ListNode cur = head;
    	while(cur != null){
    		System.err.print(cur.val + "->");
    		cur = cur.next;
    	}
    	System.err.println("");
    }
    
    public static void main(String[] args){
    	ListNode[] l1 = new ListNode[]{new ListNode(5)};
    	ListNode[] l2 = new ListNode[]{new ListNode(5)};
    	for(int i = 0; i < l1.length - 1; i++){
    		l1[i].next = l1[i + 1];
    	}
    	for(int i = 0; i < l2.length - 1; i++){
    		l2[i].next = l2[i + 1];
    	}
    	dump(new Solution().addTwoNumbers(l1[0], l2[0]));
    }
}
