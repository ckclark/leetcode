package leetcode.kth_smallest_element_in_a_bst;

import java.util.HashMap;
import java.util.Map;

import common.TreeNode;

public class Solution {

    public int kthSmallest(TreeNode root, int k) {
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        collectSize(map, root);
        int L = 0;
        TreeNode cur = root;
        while(true){
            int left_size = 0;
            if(cur.left != null){
                left_size = map.get(cur.left);
            }
            if(k <= L + left_size){
                cur = cur.left;
            }else if(k > L + left_size + 1){
                L += left_size + 1;
                cur = cur.right;
            }else{
                return cur.val;
            }
        }
    }

    private int collectSize(Map<TreeNode, Integer> map, TreeNode cur) {
        if(cur == null){
            return 0;
        }
        int size = collectSize(map, cur.left) + collectSize(map, cur.right) + 1;
        map.put(cur, size);
        return size;
    }
}
