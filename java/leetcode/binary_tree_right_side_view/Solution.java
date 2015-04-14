package leetcode.binary_tree_right_side_view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

public class Solution {
    public static class TreeNodeWithDepth{
        TreeNode node;
        int depth;
        public TreeNodeWithDepth(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> solution = new ArrayList<Integer>();
        Queue<TreeNodeWithDepth> queue = new LinkedList<TreeNodeWithDepth>();
        if(root != null){
            int curDepth = -1;
            queue.offer(new TreeNodeWithDepth(root, 0));
            while(!queue.isEmpty()){
                TreeNodeWithDepth twd = queue.remove();
                if(twd.node != null){
                    if(curDepth < twd.depth){
                        solution.add(twd.node.val);
                        curDepth = twd.depth;
                    }
                    queue.offer(new TreeNodeWithDepth(twd.node.right, twd.depth + 1));
                    queue.offer(new TreeNodeWithDepth(twd.node.left, twd.depth + 1));
                }
            }
        }
        return solution;
    }
}
