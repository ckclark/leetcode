package leetcode.recover_binary_search_tree;

import java.util.Random;

import common.TreeNode;

public class Solution {
	TreeNode OffendingNode1;
	TreeNode OffendingNode2;
	TreeNode prev;
	
	public void inOrder(TreeNode node){
		if(node != null){
			inOrder(node.left);
			if(OffendingNode1 == null && prev != null && prev.val > node.val){
				OffendingNode1 = prev;
			}
			if(OffendingNode1 != null && OffendingNode2 == null && node.val > OffendingNode1.val){
				OffendingNode2 = prev;
			}
			prev = node;
			inOrder(node.right);
		}
	}
	
    public void recoverTree(TreeNode root) {
    	prev = OffendingNode1 = OffendingNode2 = null;
    	inOrder(root);
    	if(OffendingNode2 == null){
    		OffendingNode2 = prev;
    	}
    	int tmp = OffendingNode1.val;
    	OffendingNode1.val = OffendingNode2.val;
    	OffendingNode2.val = tmp;
    }
    
	public static int fillNumber = 0;
	
	public static void inOrder(TreeNode node, boolean gen){
		if(node != null){
			inOrder(node.left, gen);
			if(gen)
				node.val = fillNumber++;
			System.err.print(node.val + " ");
			inOrder(node.right, gen);
		}
	}
	
    public static void main(String[] args){
    	final int N = 15;
    	TreeNode[] tree = new TreeNode[N];
    	for(int i = N - 1; i >= 0; i--){
    		tree[i] = new TreeNode(0);
    		if(i * 2 + 1 < N)
    			tree[i].left = tree[i * 2 + 1];
    		if(i * 2 + 2 < N)
    			tree[i].right = tree[i * 2 + 2];
    	}
    	inOrder(tree[0], true);
    	System.err.println("");
    	
    	Random r = new Random();
    	int x = r.nextInt(N);
    	int y = x;
    	while(y == x){
    		y = r.nextInt(N);
    	}
    	System.err.println(tree[x].val + " swaps " + tree[y].val);
    	int tmp = tree[x].val;
    	tree[x].val = tree[y].val;
    	tree[y].val = tmp;

    	inOrder(tree[0], false);
    	System.err.println("");

    	new Solution().recoverTree(tree[0]);

    	inOrder(tree[0], false);
    	System.err.println("");
    	
    	TreeNode tn1 = new TreeNode(2);
    	TreeNode tn2 = new TreeNode(1);
    	tn1.right = tn2;
    	inOrder(tn1, false);
    	System.err.println("");
    	new Solution().recoverTree(tn1);
    	inOrder(tn1, false);
    	System.err.println("");
    }
}
