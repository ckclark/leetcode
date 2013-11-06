package leetcode.binary_tree_zigzag_level_order_traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

public class Solution {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if(root == null) return ans;
		Queue<MyNode> queue = new LinkedList<MyNode>();
		queue.offer(new MyNode(root, 0));
		while(!queue.isEmpty()){
			MyNode cur = queue.remove();
			ArrayList<Integer> levelAry;
			if(cur.level >= ans.size()){
				levelAry = new ArrayList<Integer>();
				ans.add(levelAry);
			}else{
				levelAry = ans.get(cur.level);
			}

			levelAry.add(cur.node.val);
			if(cur.node.left != null) queue.offer(new MyNode(cur.node.left, cur.level + 1));
			if(cur.node.right != null) queue.offer(new MyNode(cur.node.right, cur.level + 1));
		}
		for(int i = 1; i < ans.size(); i += 2){
			Collections.reverse(ans.get(i));
		}
		return ans;
	}
	
	public static class MyNode{
		TreeNode node;
		int level;
		public MyNode(TreeNode node, int level){
			this.node = node;
			this.level = level;
		}
	}

	public static void main(String[] args){
		TreeNode t3 = new TreeNode(3);
		TreeNode t9 = new TreeNode(9);
		TreeNode t20 = new TreeNode(20);
		TreeNode t15 = new TreeNode(15);
		TreeNode t7 = new TreeNode(7);
		t3.left = t9;
		t3.right = t20;
		t20.left = t15;
		t20.right = t7;
		
		for(ArrayList<Integer> row : new Solution().zigzagLevelOrder(t3)){
			for(int x : row){
				System.err.print(x + ", ");
			}
			System.err.println("");
		}
	}
}
