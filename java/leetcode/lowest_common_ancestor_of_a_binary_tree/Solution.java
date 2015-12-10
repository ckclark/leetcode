package leetcode.lowest_common_ancestor_of_a_binary_tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import common.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        Set<TreeNode> visited = new HashSet<TreeNode>();
        int found_depth = -1;
        while(!stack.isEmpty()){
            TreeNode cur = stack.peek();
            if(found_depth > stack.size()){
                found_depth = stack.size();
            }
            if((cur == p || cur == q) && !visited.contains(cur)){
                if(found_depth == -1){
                    found_depth = stack.size();
                }else{
                    return stack.get(found_depth - 1);
                }
            }
            visited.add(cur);
            if(cur.left != null && !visited.contains(cur.left)){
                stack.add(cur.left);
            }else if(cur.right != null && !visited.contains(cur.right)){
                stack.add(cur.right);
            }else{
                stack.pop();
            }
        }
        return null;
    }
}
