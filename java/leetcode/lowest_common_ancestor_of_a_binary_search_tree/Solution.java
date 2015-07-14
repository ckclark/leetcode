package leetcode.lowest_common_ancestor_of_a_binary_search_tree;

import common.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val){
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        if(root.val >= p.val && root.val <= q.val){
            return root;
        }else if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else{
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}