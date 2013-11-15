package leetcode.convert_sorted_list_to_binary_search_tree;

import common.ListNode;
import common.TreeNode;

public class Solution {
	public TreeNode sortedListToBST(ListNode head, ListNode end) {
		if(head == end) return null;
		ListNode hare = head.next;
		ListNode tortoise = head;
		while(hare != end){
			hare = hare.next;
			if(hare != end){
				hare = hare.next;
			}
			tortoise = tortoise.next;
		}
		TreeNode root = new TreeNode(tortoise.val);
		root.left = sortedListToBST(head, tortoise);
		root.right = sortedListToBST(tortoise.next, end);
		return root;
	}
	
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return sortedListToBST(head, null);
    }
    
    public static void inOrder(TreeNode node){
    	if(node != null){
    		inOrder(node.left);
    		System.err.print(node.val + " ");
    		inOrder(node.right);
    	}
    }
    
    public static void preOrder(TreeNode node){
    	if(node != null){
    		System.err.print(node.val + " ");
    		preOrder(node.left);
    		preOrder(node.right);
    	}
    }
    
    public static void main(String[] args){
    	final int N = 15;
    	ListNode[] list = new ListNode[N];
    	for(int i = 0; i < N; i++){
    		list[i] = new ListNode(i);
    		if(i > 0) list[i - 1].next = list[i];
    	}
    	
    	inOrder(new Solution().sortedListToBST(list[0]));
    	System.err.println("");
    	preOrder(new Solution().sortedListToBST(list[0]));
    	System.err.println("");
    }
}
