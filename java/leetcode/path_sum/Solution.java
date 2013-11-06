package leetcode.path_sum;

import common.TreeNode;

public class Solution {
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		if(root.left != null){
			if(root.right == null){
				return hasPathSum(root.left, sum - root.val);
			}else{
				return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
			}
		}else{
			if(root.right == null){
				return sum == root.val;
			}else{
				return hasPathSum(root.right, sum - root.val);
			}
		}
	}

}
