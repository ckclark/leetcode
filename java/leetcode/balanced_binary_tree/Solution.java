package leetcode.balanced_binary_tree;

import common.TreeNode;

public class Solution {
	public boolean isBalanced(TreeNode root) {
		if(root == null) return true;
		int left = calHeight(root.left);
		int right = calHeight(root.right);
		if(Math.abs(left - right) > 1) return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}
	
	public static int calHeight(TreeNode root){
		if(root == null) return 0;
		int left = calHeight(root.left);
		int right = calHeight(root.right);
		if(left > right) return left + 1;
		else return right + 1;
	}
}
