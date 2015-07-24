package leetcode.palindrome_linked_list;

import common.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev, cur;
        cur = head;
        prev = null;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        int n = 0;
        if(head == null || head.next == null) return true;
        for(ListNode cur = head; cur != null; cur = cur.next){
            n++;
        }
        ListNode list1 = head, list2 = head;
        for(int i = 0; i < n / 2; i++){
            list2 = list2.next;
        }
        if(n % 2 != 0) list2 = list2.next;
        list2 = reverseList(list2);
        for(int i = 0; i < n / 2; i++){
            if(list1.val != list2.val)
                return false;
            list1 = list1.next;
            list2 = list2.next;
        }
        return true;
    }
}