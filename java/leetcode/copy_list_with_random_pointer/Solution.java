package leetcode.copy_list_with_random_pointer;

import java.util.ArrayList;
import java.util.Random;

import common.RandomListNode;

public class Solution {

	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null) return null;
		RandomListNode cur = head;
		RandomListNode nxt = null;
		RandomListNode ret = null;
		RandomListNode dup = null;
		while(cur != null){
			nxt = cur.next;
			cur.next = new RandomListNode(cur.label);
			cur.next.next = nxt;
			cur = nxt;
		}
		cur = head;
		while(cur != null){
			if(cur.random == null){
				cur.next.random = null;
			}else{
				cur.next.random = cur.random.next;
			}
			cur = cur.next.next;
		}
		cur = head;
		ret = head.next;
		while(cur != null){
			dup = cur.next;
			cur.next = dup.next;
			dup.next = (cur.next == null ? null : cur.next.next);
			cur = cur.next;
		}
		return ret;
	}

//	static class RandomListNode {
//		int label;
//		RandomListNode next, random;
//		RandomListNode(int x) { this.label = x; }
//		
//		public void dump(){
//			RandomListNode cur = this;
//			while(cur != null){
//				System.err.println("label: " + cur.label + ", next: " + (cur.next == null ? "null" : cur.next.label) + ", random: " + (cur.random == null ? "null" : cur.random.label) + ", hashCode = " + cur.hashCode());
//				cur = cur.next;
//			}
//		}
//		public void clear(){
//			RandomListNode cur = this;
//			while(cur != null){
//				cur.label = -1;
//				cur = cur.next;
//			}
//		}
//	};
	
	public static void main(String[] args){
		final int N = 1;
		ArrayList<RandomListNode> ary = new ArrayList<RandomListNode>();
		for(int i = 0; i < N; i++){
			ary.add(new RandomListNode(i));
		}
		for(int i = 0; i < N - 1; i++){
			ary.get(i).next = ary.get(i + 1);
		}
		ary.get(N - 1).next = null;
		
		for(int i = 0; i < N; i++){
			Random x = new Random();
			int r = x.nextInt(N + 1);
			RandomListNode ran;
			if(r == N){
				ran = null;
			}else{
				ran = ary.get(r);
			}
			ary.get(i).random = ran;
		}
//		ary.get(0).dump();
		
//		Solution sol = new Solution();
//		RandomListNode cpy = sol.copyRandomList(ary.get(0));
//		ary.get(0).clear();
//		cpy.dump();
	}
}
