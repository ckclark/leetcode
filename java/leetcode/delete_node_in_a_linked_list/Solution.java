package leetcode.delete_node_in_a_linked_list;

import common.ListNode;

public class Solution {
    public void deleteNode(ListNode node) {
        ListNode prev = node;
        while(node.next != null){
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }
}