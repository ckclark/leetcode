package leetcode.sliding_window_maximum;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static class Element{
        public int idx, value;
        public Element(int offset, int value){
            this.idx = offset;
            this.value = value;
        }
    }
    
    public void insertMonotonicQueue(Deque<Element> d, int idx, int value){
        while(!d.isEmpty() && d.peekLast().value < value){
            d.removeLast();
        }
        d.addLast(new Element(idx, value));
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        Deque<Element> d = new LinkedList<Element>();
        int[] ans = new int[nums.length - k + 1];
        for(int i = 0; i < k ;i++){
            insertMonotonicQueue(d, i, nums[i]);
        }
        ans[0] = d.peekFirst().value;
        for(int i = k; i < nums.length; i++){
            insertMonotonicQueue(d, i, nums[i]);
            if(d.peekFirst().idx == i - k){
                d.removeFirst();
            }
            ans[i - k + 1] = d.peekFirst().value;
        }
        return ans;
    }
}
