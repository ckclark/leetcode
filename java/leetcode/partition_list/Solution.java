package leetcode.partition_list;

import common.ListNode;

public class Solution {
	public ListNode partition(ListNode head, int x) {
		if(head == null) return head;
		ListNode prewall = null;
		ListNode wall = head;
		while(wall != null && wall.val < x){
			prewall = wall;
			wall = wall.next;
		}
		if(wall == null) return head;
		ListNode cur = wall.next;
		ListNode prev = wall;
		while(cur != null){
			ListNode nxt = cur.next;
			if(cur.val < x){
				prev.next = nxt;
				cur.next = wall;
				if(prewall == null){
					prewall = cur;
					head = cur;
				}else{
					prewall.next = cur;
					prewall = cur;
				}
			}else{
				prev = cur;
			}
			cur = nxt;
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
	
	public static void main(String[] args){
		final int N = 6;
		int[] vals = new int[]{1, 1, 1, 2, 1, 2}; 
		ListNode[] ary = new ListNode[N];
		for(int i = 0; i < N; i++){
			ary[i] = new ListNode(vals[i]);
			if(i > 0) ary[i - 1].next = ary[i]; 
		}
		dump(new Solution().partition(ary[0], 3));
	}
}
