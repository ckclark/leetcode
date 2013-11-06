package leetcode.sum_root_to_leaf_numbers;

import common.TreeNode;

public class Solution {
	int ans;
	
	public void dfs(TreeNode cur, int val){
		val = val * 10 + cur.val;
		if(cur.left == null && cur.right == null){
			ans += val;
		}else{
			if(cur.left != null){
				dfs(cur.left, val);
			}
			if(cur.right != null){
				dfs(cur.right, val);
			}
		}
	}
	
	public int sumNumbers(TreeNode root) {
		if(root == null) return 0;
		ans = 0;
		dfs(root, 0);
		return ans;
	}

	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(7);
		System.err.println(new Solution().sumNumbers(root));
	}
}
