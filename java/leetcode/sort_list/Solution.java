package leetcode.sort_list;

import java.util.Random;

import common.ListNode;

public class Solution {
    public ListNode sortList(ListNode head) {
    	if(head == null) return head;
    	boolean isEnd = false;
    	for(int length = 1; !isEnd; length <<= 1){
    		ListNode prev = null;
    		ListNode tmpHead = head;
    		boolean first = true;
    		while(tmpHead != null){
    			ListNode hare, tortoise, tail = tmpHead;
    			int max = tmpHead.val;
    			tortoise = hare = tmpHead;
    			for(int i = 0; i < length; i++){
    				if(tortoise != null){
    					if(tortoise.val >= max){
    						max = tortoise.val;
    						tail = tortoise;
    					}
    					tortoise = tortoise.next;
    				}
    				if(hare != null){
    					if(hare.val >= max){
    						max = hare.val;
    						tail = hare;
    					}
    					hare = hare.next;
    				}
    				if(hare != null){
    					if(hare.val >= max){
    						max = hare.val;
    						tail = hare;
    					}
    					hare = hare.next;
    				}
    				if((tortoise == null || hare == null) && first)
    					isEnd = true;
    			}
    			first = false;
    			ListNode list1 = tmpHead;
    			ListNode list2 = tortoise;
    			ListNode end1 = tortoise;
    			ListNode end2 = hare;
    			ListNode mergeHead = mergeList(prev, list1, list2, end1, end2);
    			if(prev == null) head = mergeHead;
    			prev = tail;
    			tmpHead = hare;
    		}
    	}
    	return head;
    }

	private ListNode mergeList(ListNode prev, ListNode list1, ListNode list2, ListNode end1, ListNode end2) {
		ListNode head = prev;
		ListNode current = prev;
		while(list1 != end1 || list2 != end2){
			if(list1 == end1){
				if(head == null){
					head = current = list2;
				}else{
					current.next = list2;
					current = list2;
				}
				list2 = list2.next;
			}else if(list2 == end2){
				if(head == null){
					head = current = list1;
				}else{
					current.next = list1;
					current = list1;
				}
				list1 = list1.next;
			}else{
				if(list2.val >= list1.val){
					if(head == null){
						head = current = list1;
					}else{
						current.next = list1;
						current = list1;
					}	
					list1 = list1.next;
				}else{
					if(head == null){
						head = current = list2;
					}else{
						current.next = list2;
						current = list2;
					}
					list2 = list2.next;
				}
			}
		}
		current.next = end2;
		return head;
	}
	
	public static void dumpList(ListNode head){
		while(head != null){
			System.err.print(head.val + "->");
			head = head.next;
		}
		System.err.println("");
	}
	
	public static void testMerge(){
		final int N = 10;
		ListNode[] input = new ListNode[N];
		Random r = new Random();
		for(int i = 0; i < N / 2; i++){
			int j = N / 2 + i;
			if(i == 0){
				input[i] = new ListNode(r.nextInt(20));
				input[j] = new ListNode(r.nextInt(20));
			}else{
				input[i] = new ListNode(r.nextInt(3) + 1 + input[i - 1].val);
				input[j] = new ListNode(r.nextInt(3) + 1 + input[j - 1].val);
			}
		}
		for(int i = 1; i < N; i++){
			input[i - 1].next = input[i];
		}
		dumpList(input[0]);
		dumpList(new Solution().mergeList(null, input[1], input[N / 2], input[N / 2], null));
		dumpList(input[0]);
	}
	
	public static void main(String[] args){
		int cases = 100;
		while(cases-- > 0){
			Random r = new Random();
			final int N = r.nextInt(100) + 1;
			ListNode[] input = new ListNode[N];
			for(int i = 0; i < N; i++){
				input[i] = new ListNode(r.nextInt(100));
				if(i > 0){
					input[i - 1].next = input[i];
				}
			}
			ListNode head = new Solution().sortList(input[0]);
			dumpList(head);
			int prev = head.val;
			ListNode cur = head;
			for(int i = 0; i < N; i++){
				if(cur.val < prev){
					System.err.println(cur.val + " < " + prev);
				}
				cur = cur.next;
			}
		}
	}
}
