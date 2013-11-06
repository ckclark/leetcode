package leetcode.populating_next_right_pointers_in_each_node;

import common.TreeLinkNode;

public class Solution {
	
	public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;
        while(left != null && right != null){
        	left.next = right;
        	left = left.right;
        	right = right.left;
        }
        connect(root.left);
        connect(root.right);
    }
}
