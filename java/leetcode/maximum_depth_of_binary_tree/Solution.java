package leetcode.maximum_depth_of_binary_tree;

import common.TreeNode;

public class Solution {
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		if(left > right) return left + 1;
		else return right + 1;
	}
}
