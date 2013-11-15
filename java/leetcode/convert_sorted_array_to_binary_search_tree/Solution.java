package leetcode.convert_sorted_array_to_binary_search_tree;

import common.TreeNode;

public class Solution {
	public TreeNode sortedArrayToBST(int[] num, int from, int to) {
		if(from == to) return null;
		TreeNode root;
		int mid = from + (to - from) / 2;
		root = new TreeNode(num[mid]);
		root.left = sortedArrayToBST(num, from, mid);
		root.right = sortedArrayToBST(num, mid + 1, to);
		return root;
	}

	public TreeNode sortedArrayToBST(int[] num) {
        if(num == null) return null;
        return sortedArrayToBST(num, 0, num.length);
    }
	
	public static void inOrder(TreeNode node){
		if(node != null){
			inOrder(node.left);
			System.err.print(node.val + " ");
			inOrder(node.right);
		}
	}
	
	public static void main(String[] args){
		inOrder(new Solution().sortedArrayToBST(new int[]{}));
	}
}
