package leetcode.binary_search_tree_iterator;

import common.TreeNode;

public class BSTIterator {
    Integer biggest = null;
    Integer curVal = null;
    TreeNode root;
	
    public BSTIterator(TreeNode root) {
        this.root = root;
        TreeNode cur = root;
        if(cur != null){
            while(cur.right != null){
                cur = cur.right;
            }
            biggest = cur.val;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(biggest == null) return false;
        return curVal == null || biggest > curVal;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = root;
        int smallest = biggest;
        if(curVal == null || cur.val > curVal)
            smallest = cur.val;
        while(cur != null){
            if(curVal == null || cur.val > curVal){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
            if(cur != null && cur.val < smallest && (curVal == null || cur.val > curVal)){
                smallest = cur.val;
            }
        }
        return curVal = smallest;
    }
}
