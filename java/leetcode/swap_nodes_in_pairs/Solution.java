package leetcode.swap_nodes_in_pairs;

import java.util.ArrayList;

import common.ListNode;

public class Solution {
	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode ret = head.next;
		ListNode cur = head;
		ListNode prev = null;
		while(cur != null && cur.next != null){
			ListNode nxt = cur.next;
			cur.next = nxt.next;
			nxt.next = cur;
			if(prev != null){
				prev.next = nxt;
			}
			prev = cur;
			cur = cur.next;
		}
		return ret;
	}

	public static void dump(ListNode head){
		ListNode cur = head;
		while(cur != null){
			System.err.print(cur.val + ", ");
			cur = cur.next;
		}
		System.err.println("");
	}
	
	public static void main(String[] args){
		final int N = 3;
		ArrayList<ListNode> ary = new ArrayList<ListNode>();
		for(int i = 0; i < N; i++){
			ary.add(new ListNode(i));
			if(i > 0) ary.get(i - 1).next = ary.get(i);
		}
		ListNode ret = new Solution().swapPairs(ary.get(0));
		dump(ret);
	}
}