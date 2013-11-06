package leetcode.path_sum_ii;

import java.util.ArrayList;

import common.TreeNode;

public class Solution {
	public void hasPathSum(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> cur, TreeNode root, int sum) {
		cur.add(root.val);
		if(root != null){
			if(root.left != null){
				if(root.right == null){
					hasPathSum(ans, cur, root.left, sum - root.val);
				}else{
					hasPathSum(ans, cur, root.left, sum - root.val);
					hasPathSum(ans, cur, root.right, sum - root.val);
				}
			}else{
				if(root.right == null){
					if(sum == root.val){
						ans.add(new ArrayList<Integer>(cur));
					}
				}else{
					hasPathSum(ans, cur, root.right, sum - root.val);
				}
			}
		}
		cur.remove(cur.size() - 1);
	}
	
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if(root == null) return ans;
		hasPathSum(ans, new ArrayList<Integer>(), root, sum);
		return ans;
	}

	public static void main(String[] args){
		TreeNode t5 = new TreeNode(5);
		TreeNode t4 = new TreeNode(4);
		TreeNode t8 = new TreeNode(8);
		TreeNode t11 = new TreeNode(11);
		TreeNode t13 = new TreeNode(13);
		TreeNode t4_ = new TreeNode(4);
		TreeNode t7 = new TreeNode(7);
		TreeNode t2 = new TreeNode(2);
		TreeNode t5_ = new TreeNode(5);
		TreeNode t1 = new TreeNode(1);
		t5.left = t4;
		t5.right = t8;
		t4.left = t11;
		t8.left = t13;
		t8.right = t4_;
		t11.left = t7;
		t11.right = t2;
		t4_.left = t5_;
		t4_.right = t1;
		for(ArrayList<Integer> ans : new Solution().pathSum(t5, 22)){
			for(int x : ans){
				System.err.print(x + ", ");
			}
			System.err.println("");
		}
	}
}
