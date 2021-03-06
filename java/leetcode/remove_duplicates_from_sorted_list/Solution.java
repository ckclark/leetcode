package leetcode.remove_duplicates_from_sorted_list;

import java.util.ArrayList;
import java.util.Random;

import common.ListNode;

public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return null;
		ListNode cur = head;
		while(cur != null){
			while(cur.next != null && cur.next.val == cur.val){
				cur.next = cur.next.next;
			}
			cur = cur.next;
		}
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
		final int N = 10;
		Random r = new Random();
		ArrayList<ListNode> ary = new ArrayList<ListNode>();
		for(int i = 0; i < N; i++){
			int v = 0;
			if(i > 0) v = ary.get(i - 1).val; 
			ary.add(new ListNode(v + r.nextInt(2)));
			if(i > 0) ary.get(i - 1).next = ary.get(i);
		}
		dump(ary.get(0));
		dump(new Solution().deleteDuplicates(ary.get(0)));
	}
}
