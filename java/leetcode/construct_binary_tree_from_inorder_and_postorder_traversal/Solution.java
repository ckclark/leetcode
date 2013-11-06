package leetcode.construct_binary_tree_from_inorder_and_postorder_traversal;

import common.TreeNode;

public class Solution {
	public TreeNode buildTree(int[] inorder, int[] postorder, int in_from, int in_to, int post_from, int post_to){
		if(in_from == in_to || post_from == post_to) return null;
		int rootval = postorder[post_to - 1];
		TreeNode root = new TreeNode(rootval);
		int rootidx;
		for(rootidx = in_from; rootidx < in_to && inorder[rootidx] != rootval; rootidx++);
		root.left = buildTree(inorder, postorder, in_from, rootidx, post_from, post_from + (rootidx - in_from));
		root.right = buildTree(inorder, postorder, rootidx + 1, in_to, post_to - (in_to - rootidx), post_to - 1);
		return root;
	}
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if(inorder == null || postorder == null) return null;
    	return buildTree(inorder, postorder, 0, inorder.length, 0, postorder.length);
    }
    
    public static void inOrder(TreeNode cur){
    	if(cur != null){
    		inOrder(cur.left);
    		System.err.print(cur.val + "->");
    		inOrder(cur.right);
    	}
    }
    
    public static void postOrder(TreeNode cur){
    	if(cur != null){
    		postOrder(cur.left);
    		postOrder(cur.right);
    		System.err.print(cur.val + "->");
    	}
    }
    
    public static void main(String[] args){
    	int[] inorder = new int[]{4, 9, 5, 1, 8, 3, 7, 6};
    	int[] postorder = new int[]{9, 4, 5, 8, 7, 6, 3, 1};
    	TreeNode ret = new Solution().buildTree(inorder, postorder);
    	inOrder(ret);
    	System.err.println("");
    	postOrder(ret);
    	System.err.println("");
    }
}
