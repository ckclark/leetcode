package leetcode.binary_tree_preorder_traversal;

import java.util.ArrayList;

import common.TreeNode;

public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
    	ArrayList<Integer> ans = new ArrayList<Integer>();
    	if(root == null) return ans;
    	ArrayList<TreeNode> stack = new ArrayList<TreeNode>();
    	stack.add(root);
    	while(stack.size() > 0){
    		TreeNode cur = stack.remove(stack.size() - 1);
    		ans.add(cur.val);
    		if(cur.right != null){
    			stack.add(cur.right);
    		}
    		if(cur.left != null){
    			stack.add(cur.left);
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
    	for(int x : new Solution().preorderTraversal(t1)){
    		System.err.print(x + "->");
    	}
    	System.err.println("");
    }
}
