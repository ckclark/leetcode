package leetcode.serialize_and_deserialize_binary_tree;

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
public class Codec {

    public static class MyPair{
        public TreeNode mTreeNode;
        public int mNextStart;
        public MyPair(TreeNode tn, int nextStart){
            mTreeNode = tn;
            mNextStart = nextStart;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        if(root != null){
            sb.append(Integer.toString(root.val));
            sb.append(serialize(root.left));
            sb.append(serialize(root.right));
        }
        sb.append(')');
        return sb.toString();
    }

    private MyPair doDeserialize(String data, int begin){
        int nondigit;
        for(nondigit = begin + 1; ; nondigit++){
            if(data.charAt(nondigit) == '(' || data.charAt(nondigit) == ')'){
                break;
            }
        }
        if(nondigit == begin + 1){
            return new MyPair(null, begin + 2);
        }else{
            TreeNode root = new TreeNode(Integer.parseInt(data.substring(begin + 1, nondigit)));
            MyPair mp;
            mp = doDeserialize(data, nondigit);
            root.left = mp.mTreeNode;
            mp = doDeserialize(data, mp.mNextStart);
            root.right = mp.mTreeNode;
            return new MyPair(root, mp.mNextStart + 1);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return doDeserialize(data, 0).mTreeNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
