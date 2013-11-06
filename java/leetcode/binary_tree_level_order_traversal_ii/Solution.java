package leetcode.binary_tree_level_order_traversal_ii;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import common.TreeNode;

public class Solution {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		Queue<MyNode> queue = new LinkedList<MyNode>();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if(root == null) return ans;
		queue.offer(new MyNode(root, 0));
		while(!queue.isEmpty()){
			MyNode myNode = queue.remove();
			TreeNode tn = myNode.node;
			ArrayList<Integer> lvl = null;
			if(ans.size() <= myNode.level){
				lvl = new ArrayList<Integer>();
				ans.add(lvl);
			}else{
				lvl = ans.get(myNode.level);
			}
			lvl.add(tn.val);
			if(tn.left != null) queue.offer(new MyNode(tn.left, myNode.level + 1));
			if(tn.right != null) queue.offer(new MyNode(tn.right, myNode.level + 1));
		}
		int size = ans.size();
		for(int i = 0; i < size / 2; i++){
			ArrayList<Integer> tmp = ans.get(i);
			ans.set(i, ans.get(size - 1 - i));
			ans.set(size - 1 - i, tmp);
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
		final int N = 15;
		final int R = 5;
		ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
		for(int i = 0; i < N; i++){
			nodes.add(new TreeNode(i));
		}
		Random r = new Random();
		for(int i = 0; i < N; i++){
			if(i * 2 + 1 < N){
				nodes.get(i).left = nodes.get(i * 2 + 1);
			}
			if(i * 2 + 2 < N){
				nodes.get(i).right = nodes.get(i * 2 + 2);
			}
		}
		for(int i = 0; i < R; i++){
			int ran = r.nextInt(N);
			System.err.println("ran:" + ran);
			nodes.get(ran).left = null;
		}
		
		for(ArrayList<Integer> row : new Solution().levelOrderBottom(nodes.get(0))){
			for(int x : row){
				System.err.print(x + ", ");
			}
			System.err.println("");
		}
	}
}
