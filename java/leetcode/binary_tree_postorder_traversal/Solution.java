package leetcode.binary_tree_postorder_traversal;

import java.util.ArrayList;

import common.TreeNode;

public class Solution {
	
	public static class MyNode{
		TreeNode node;
		boolean isVisit;
		public MyNode(TreeNode node){
			this.node = node;
		}
	}
	
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
    	ArrayList<Integer> ans = new ArrayList<Integer>();
    	if(root == null) return ans;
    	ArrayList<MyNode> stack = new ArrayList<MyNode>();
    	stack.add(new MyNode(root));
    	while(stack.size() > 0){
    		MyNode cur = stack.get(stack.size() - 1);
    		if(cur.isVisit){
    			ans.add(cur.node.val);
    			stack.remove(stack.size() - 1);
    		}else{
    			cur.isVisit = true;
    			if(cur.node.right != null){
    				stack.add(new MyNode(cur.node.right));
    			}
    			if(cur.node.left != null){
    				stack.add(new MyNode(cur.node.left));
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
    	for(int x : new Solution().postorderTraversal(t1)){
    		System.err.print(x + "->");
    	}
    	System.err.println("");
    }
}
