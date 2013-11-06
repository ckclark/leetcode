package leetcode.merge_two_sorted_lists;

import java.util.ArrayList;
import java.util.Random;

import common.ListNode;

public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		ListNode cur1 = l1, cur2 = l2;
		ListNode cur;
		ListNode head;
		if(cur1.val > cur2.val){
			head = cur2;
			cur2 = cur2.next;
		}else{
			head = cur1;
			cur1 = cur1.next;
		}
		cur = head;
		while(cur1 != null && cur2 != null){
			if(cur1.val > cur2.val){
				cur.next = cur2;
				cur = cur2;
				cur2 = cur2.next;
			}else{
				cur.next = cur1;
				cur = cur1;
				cur1 = cur1.next;
			}
		}
		if(cur1 != null) cur.next = cur1;
		if(cur2 != null) cur.next = cur2;
		return head;
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
		final int N = 1;
		Random r = new Random();
		ArrayList<ListNode> ary1 = new ArrayList<ListNode>();
		for(int i = 0; i < N; i++){
			int v = 0;
			if(i > 0) v = ary1.get(i - 1).val; 
			ary1.add(new ListNode(v + r.nextInt(2)));
			if(i > 0) ary1.get(i - 1).next = ary1.get(i);
		}
		
		ArrayList<ListNode> ary2 = new ArrayList<ListNode>();
		for(int i = 0; i < N; i++){
			int v = 0;
			if(i > 0) v = ary2.get(i - 1).val; 
			ary2.add(new ListNode(v + r.nextInt(2)));
			if(i > 0) ary2.get(i - 1).next = ary2.get(i);
		}
		dump(ary1.get(0));
		dump(ary2.get(0));
		dump(new Solution().mergeTwoLists(ary1.get(0), ary2.get(0)));
	}
}
