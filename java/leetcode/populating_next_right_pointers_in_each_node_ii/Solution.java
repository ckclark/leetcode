package leetcode.populating_next_right_pointers_in_each_node_ii;

import common.TreeLinkNode;

public class Solution {
	public void connect(TreeLinkNode root) {
		if(root == null) return;
		TreeLinkNode parent = root;
		if(parent.right != null){
			TreeLinkNode child = parent.right;
			TreeLinkNode nxt = parent.next;
			while(nxt != null){
				if(nxt.left != null){
					child.next = nxt.left;
					break;
				}
				if(nxt.right != null){
					child.next = nxt.right;
					break;
				}
				nxt = nxt.next;
			}
			connect(child);
		}
		
		if(parent.left != null){
			TreeLinkNode child = parent.left;
			TreeLinkNode nxt = parent.next;
			if(parent.right != null){
				child.next = parent.right;
			}else{
				while(nxt != null){
					if(nxt.left != null){
						child.next = nxt.left;
						break;
					}
					if(nxt.right != null){
						child.next = nxt.right;
						break;
					}
					nxt = nxt.next;
				}
			}
			connect(child);
		}
		
	}
}
