package leetcode.validate_binary_search_tree;

import common.TreeNode;

public class Solution {
	
	public boolean isValidBST(TreeNode root, Integer lower, Integer upper){
		if(root.left != null){
			if(root.left.val >= root.val) return false;
			if(lower != null && root.left.val <= lower.intValue()) return false;
			if(!isValidBST(root.left, lower, root.val)) return false; 
		}
		if(root.right != null){
			if(root.right.val <= root.val) return false;
			if(upper != null && root.right.val >= upper.intValue()) return false;
			if(!isValidBST(root.right, root.val, upper)) return false; 
		}
		return true;
	}
	
    public boolean isValidBST(TreeNode root) {
    	if(root == null) return true;
        return isValidBST(root, null, null);
    }
}
