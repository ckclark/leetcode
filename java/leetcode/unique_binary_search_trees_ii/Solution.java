package leetcode.unique_binary_search_trees_ii;

import java.util.ArrayList;

import common.TreeNode;

public class Solution {
	public ArrayList<TreeNode> generateTrees(int n) {
		return generateTrees(1, n);
	}
	
	public ArrayList<TreeNode> generateTrees(int from, int to){
		if(from > to){
			ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
			ret.add(null);
			return ret;
		}
		ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
		for(int i = from; i <= to; i++){
			int r = i;
			
			ArrayList<TreeNode> left = generateTrees(from, r - 1);
			ArrayList<TreeNode> right = generateTrees(r + 1, to);
			for(TreeNode ltn : left){
				for(TreeNode rtn : right){
					TreeNode root = new TreeNode(i);
					root.left = ltn;
					root.right = rtn;
					ret.add(root);
				}
			}
		}
		return ret;
	}
	
	public void bfs(TreeNode node){
		final int N = 100;
		TreeNode[] queue = new TreeNode[N];
		int head = 0, tail = 0;
		queue[head++] = node;
		while(head != tail){
			TreeNode cur = queue[tail];
			tail = (tail + 1) % N;
			String v;
			if(cur == null) v = "#";
			else v = "" + cur.val;
			System.err.print(v + ", ");
			if(cur != null){
				queue[head] = cur.left;
				head = (head + 1) % N;
				queue[head] = cur.right;
				head = (head + 1) % N;
			}
		}
		System.err.println("");
	}
	
	public static void main(String[] args){
		Solution sol = new Solution();
		for(TreeNode tn : sol.generateTrees(3)){
			sol.bfs(tn);
		}
	}
}
