package leetcode.count_complete_tree_nodes;

import common.TreeNode;

public class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int h = 0;
        TreeNode left = root.left;
        while(left != null){
            left = left.left;
            h++;
        }
        int L = 0, U = 1 << h;
        while(L + 1 < U){
            int mid = L + (U - L) / 2;
            TreeNode now = root;
            for(int i = h - 1; i >= 0; i--){
                if(((1 << i) & mid) != 0){
                    now = now.right;
                }else{
                    now = now.left;
                }
            }
            if(now == null){
                U = mid;
            }else{
                L = mid;
            }
        }
        return L + (1 << h);
    }
    
    public static void main(String[] args){
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        System.err.println(new Solution().countNodes(root));
    }
}
