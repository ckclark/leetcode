package leetcode.merge_k_sorted_lists;

import java.util.ArrayList;
import java.util.Random;

import common.ListNode;

public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
    	if(lists == null || lists.size() == 0) return null;
    	ListNode head = null;
    	int start = 0;
    	for(start = 0; start < lists.size(); start++){
    		ListNode ln = lists.get(start);
    		if(ln != null){
    			head = ln;
    			break;
    		}
    	}
    	if(head == null) return null;
    	for(int merge = start + 1; merge < lists.size(); merge++){
    		ListNode m = lists.get(merge);
    		ListNode cur = head;
    		ListNode prev = null;
    		while(m != null && cur != null){
    			if(m.val < cur.val){
    				if(prev == null){
    					head = prev = m;
    				}else{
    					prev.next = m;
    					prev = m;
    				}
    				m = m.next;
    			}else{
    				if(prev == null){
    					head = prev = cur;
    				}else{
    					prev.next = cur;
    					prev = cur;
    				}
    				cur = cur.next;
    			}
    		}
    		if(m != null){
    			if(prev == null){
    				head = prev = m;
    			}else{
    				prev.next = m;
    			}
    		}
    		if(cur != null){
    			if(prev == null){
    				head = prev = cur;
    			}else{
    				prev.next = cur;
    			}
    		}
    	}
    	return head;
    }
    
    public static void dump(ListNode head){
    	while(head != null){
    		System.err.print(head.val + "->");
    		head = head.next;
    	}
    	System.err.println("");
    }
    public static void main(String[] args){
    	Random r = new Random();
    	final int N = 10;
    	ArrayList<ListNode> heads = new ArrayList<ListNode>();
    	for(int i = 0; i < N; i++){
    		int size = r.nextInt(10) / 9 * 2;
    		ListNode[] ary = new ListNode[size];
    		int prev = 0;
    		for(int j = 0; j < size; j++){
    			int next = prev + r.nextInt(5);
    			ary[j] = new ListNode(next);
    			if(j > 0) ary[j - 1].next = ary[j];
    			prev = next;
    		}

    		if(ary.length > 0){
    			heads.add(ary[0]);
    			dump(ary[0]);
    		}else{
    			heads.add(null);
    			System.err.println("null");
    		}
    	}
    	dump(new Solution().mergeKLists(heads));
    }
}
