package leetcode.binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.Stack;

import common.TreeNode;

public class Solution {
	
	public static class MyNode{
		TreeNode node;
		boolean isVisit;
		public MyNode(TreeNode node){
			this.node = node;
		}
	}
	
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
    	ArrayList<Integer> ans = new ArrayList<Integer>();
    	if(root == null) return ans;
    	Stack<MyNode> stack = new Stack<MyNode>();
    	stack.push(new MyNode(root));
    	while(!stack.isEmpty()){
    		MyNode cur = stack.pop();
    		if(cur.isVisit){
    			ans.add(cur.node.val);
    		}else{
    			cur.isVisit = true;
    			if(cur.node.right != null){
    				stack.push(new MyNode(cur.node.right));
    			}
    			stack.push(cur);
    			if(cur.node.left != null){
    				stack.push(new MyNode(cur.node.left));
    			}
    		}
    	}
    	return ans;
    }
    
    public static void main(String[] args){
    	TreeNode t1 = new TreeNode(1);
    	TreeNode t2 = new TreeNode(2);
    	TreeNode t3 = new TreeNode(3);
    	TreeNode t4 = new TreeNode(4);
    	t1.left = t2;
    	t2.left = t3;
    	t2.right = t4;
    	for(int x : new Solution().inorderTraversal(t1)){
    		System.err.print(x + "->");
    	}
    	System.err.println("");
    }
}
