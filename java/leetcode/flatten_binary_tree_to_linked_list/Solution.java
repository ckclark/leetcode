package leetcode.flatten_binary_tree_to_linked_list;

import common.TreeNode;

public class Solution {
	TreeNode prev;
	public void preOrderFlatten(TreeNode cur){
		if(cur != null){
			TreeNode left = cur.left, right = cur.right;
			cur.left = null;
			if(prev != null) prev.right = cur;
			prev = cur;
			preOrderFlatten(left);
			preOrderFlatten(right);
		}
	}

	public void flatten(TreeNode root) {
		prev = null;
		preOrderFlatten(root);
	}
	
	public static void preOrderPrint(TreeNode cur){
		if(cur != null){
			System.err.print(cur.val + "->");
			preOrderPrint(cur.left);
			preOrderPrint(cur.right);
		}
	}

	
	public static void inOrderPrint(TreeNode cur){
		if(cur != null){
			inOrderPrint(cur.left);
			System.err.print(cur.val + "->");
			inOrderPrint(cur.right);
		}
	}
    
    public static void main(String[] args){
    	TreeNode t1 = new TreeNode(1);
    	TreeNode t2 = new TreeNode(2);
    	TreeNode t3 = new TreeNode(3);
    	TreeNode t4 = new TreeNode(4);
    	TreeNode t5 = new TreeNode(5);
    	TreeNode t6 = new TreeNode(6);
    	
    	t1.left = t2;
    	t1.right = t5;
    	t2.left = t3;
    	t2.right = t4;
    	t5.right = t6;
    	
    	preOrderPrint(t1);
    	System.err.println("");
    	inOrderPrint(t1);
    	System.err.println("");
    	new Solution().flatten(t1);
    	preOrderPrint(t1);
    	System.err.println("");
    	inOrderPrint(t1);
    	System.err.println("");
    }
}
