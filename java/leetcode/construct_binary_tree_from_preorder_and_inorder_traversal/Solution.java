package leetcode.construct_binary_tree_from_preorder_and_inorder_traversal;

import common.TreeNode;

public class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder, int pre_from, int pre_to, int in_from, int in_to){
		if(in_from == in_to || pre_from == pre_to) return null;
		int rootval = preorder[pre_from];
		TreeNode root = new TreeNode(rootval);
		int rootidx;
		for(rootidx = in_from; rootidx < in_to && inorder[rootidx] != rootval; rootidx++);
		System.err.println(rootidx);
		root.left = buildTree(preorder, inorder, pre_from + 1, pre_from + 1 + (rootidx - in_from), in_from, rootidx);
		root.right = buildTree(preorder, inorder, pre_to + 1 - (in_to - rootidx), pre_to, rootidx + 1, in_to);
		return root;
	}
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(inorder == null || preorder == null) return null;
    	return buildTree(preorder, inorder, 0, inorder.length, 0, preorder.length);
    }
    
    public static void inOrder(TreeNode cur){
    	if(cur != null){
    		inOrder(cur.left);
    		System.err.print(cur.val + "->");
    		inOrder(cur.right);
    	}
    }
    
    public static void preOrder(TreeNode cur){
    	if(cur != null){
    		System.err.print(cur.val + "->");
    		preOrder(cur.left);
    		preOrder(cur.right);
    	}
    }
    
    public static void main(String[] args){
    	int[] preorder = new int[]{1, 5, 4, 9, 3, 8, 6, 7};
    	int[] inorder = new int[]{4, 9, 5, 1, 8, 3, 7, 6};
    	TreeNode ret = new Solution().buildTree(preorder, inorder);
    	preOrder(ret);
    	System.err.println("");
    	inOrder(ret);
    	System.err.println("");
    }
}
