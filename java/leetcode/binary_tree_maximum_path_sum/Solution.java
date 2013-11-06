package leetcode.binary_tree_maximum_path_sum;

import common.TreeNode;

public class Solution {
	boolean allNegative;
	int maxVal;
	
	public int maxPathSum(TreeNode root) {
		allNegative = true;
		maxVal = root.val;
		int ans = maxPathSum2(root).allMax;
		if(allNegative){
			return maxVal;
		}else{
			return ans;
		}
	}
	
	public RetVal maxPathSum2(TreeNode cur){
		if(cur == null){
			return new RetVal(0, 0);
		}
		if(cur.val >= 0) allNegative = false;
		if(cur.val > maxVal) maxVal = cur.val;
		RetVal ret;
		if(cur.val < 0)
			ret = new RetVal(0, 0);
		else
			ret = new RetVal(cur.val, cur.val);
		RetVal left = maxPathSum2(cur.left);
		RetVal right = maxPathSum2(cur.right);
		if(ret.endAtRoot < left.endAtRoot + cur.val){
			ret.endAtRoot = left.endAtRoot + cur.val;
		}
		if(ret.endAtRoot < right.endAtRoot + cur.val){
			ret.endAtRoot = right.endAtRoot + cur.val;
		}
		if(ret.allMax < left.allMax){
			ret.allMax = left.allMax;
		}
		if(ret.allMax < right.allMax){
			ret.allMax = right.allMax;
		}
		if(ret.allMax < right.endAtRoot + cur.val + left.endAtRoot){
			ret.allMax = right.endAtRoot + cur.val + left.endAtRoot;
		}
		if(ret.allMax < ret.endAtRoot){
			ret.allMax = ret.endAtRoot;
		}
		return ret;
		
	}
	
	public class RetVal{
		int endAtRoot;
		int allMax;
		public RetVal(int passRoot, int allMax){
			this.endAtRoot = passRoot;
			this.allMax = allMax;
		}
	}
}
