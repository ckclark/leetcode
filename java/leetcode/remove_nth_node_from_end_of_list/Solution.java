package leetcode.remove_nth_node_from_end_of_list;

import java.util.ArrayList;

import common.ListNode;

public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null || n == 0){
			return head;
		}
		if(n == 1 && head.next == null) return null;
		int size = 0;
		ListNode cur = head;
		while(cur != null){
			cur = cur.next;
			size += 1;
		}
		n = size - n;
		if(n == 0){
			head = head.next;
		}else{
			cur = head;
			ListNode prev = null;
			while(n > 0){
				prev = cur;
				n--;
				cur = cur.next;
			}
			prev.next = cur.next;
		}
		return head;
	}

//	public static class ListNode {
//		int val;
//		ListNode next;
//		ListNode(int x) {
//			val = x;
//			next = null;
//		}
//		public void dump(){
//			ListNode cur = this;
//			while(cur != null){
//				System.err.println("val = " + cur.val);
//				cur = cur.next;
//			}
//			System.err.println("");
//		}
//	}
	
	public static void main(String[] args){
		final int N = 10;
//		Solution sol = new Solution();
		for(int i = 0; i <= N; i++){
			ArrayList<ListNode> ary = new ArrayList<ListNode>();
			for(int j = 0; j < N; j++){
				ary.add(new ListNode(j));
				if(j > 0) ary.get(j - 1).next = ary.get(j);
			}
//			ListNode head = sol.removeNthFromEnd(ary.get(0), i);
//			head.dump();
		}
	}
}
