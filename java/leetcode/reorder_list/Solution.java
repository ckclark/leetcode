package leetcode.reorder_list;

import java.util.ArrayList;

import common.ListNode;

public class Solution {
	public void reorderList(ListNode head) {
		if(head == null || head.next == null) return;
		ListNode cur = head;
		ListNode tail = null;
		int cnt = 0;
		while(cur != null){
			cnt++;
			cur = cur.next;
		}
		cnt = (cnt + 1) / 2;
		
		cur = head;
		while(cnt > 1){
			cur = cur.next;
			cnt--;
		}
		
		ListNode prev = cur;
		ListNode nxt = prev.next;
		prev.next = null;
		prev = null;
		while(nxt != null){
			ListNode tmp = nxt.next;
			nxt.next = prev;
			prev = nxt;
			nxt = tmp;
		}
		tail = prev;
		ListNode back = tail, forward = head;
		while(back != null && forward != null){
			ListNode ff = forward.next;
			ListNode bb = back.next;
			forward.next = back;
			back.next = ff;
			back = bb;
			forward = ff;
		}
	}
	
	public static void dumpList(ListNode head){
		ListNode cur = head;
		while(cur != null){
			System.err.print("" + cur.val + ", ");
			cur = cur.next;
		}
		System.err.println("");
	}
	
	public static void main(String[] args){
		final int N = 9;
		ArrayList<ListNode> nodeAry = new ArrayList<ListNode>();
		for(int i = 0; i < N; i++){
			nodeAry.add(new ListNode(i));
			if(i > 0) nodeAry.get(i - 1).next = nodeAry.get(i);
		}
		new Solution().reorderList(nodeAry.get(0));
		dumpList(nodeAry.get(0));
	}
}
