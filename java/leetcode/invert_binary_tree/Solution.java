package leetcode.invert_binary_tree;

import common.TreeNode;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root != null){
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
