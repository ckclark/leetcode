package leetcode.binary_tree_paths;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<String>();
        if(root == null) return ret;
        List<TreeNode> stack = new ArrayList<TreeNode>();
        doDfs(ret, root, stack);
        return ret;
    }

    private void doDfs(List<String> ret, TreeNode cur, List<TreeNode> stack) {
        stack.add(cur);
        if(cur.left != null){
            doDfs(ret, cur.left, stack);
        }
        if(cur.right != null){
            doDfs(ret, cur.right, stack);
        }
        if(cur.left == null && cur.right == null){
            StringBuilder sb = new StringBuilder();
            String prefix = "";
            for(TreeNode tn : stack){
                sb.append(prefix);
                sb.append(tn.val);
                prefix = "->";
            }
            ret.add(sb.toString());
        }
        stack.remove(stack.size() - 1);
    }
}
