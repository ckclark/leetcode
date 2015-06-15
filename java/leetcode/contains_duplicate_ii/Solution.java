package leetcode.contains_duplicate_ii;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<Integer>(k);
        for(int i = 0; i < k && i < nums.length; i++){
            if(window.contains(nums[i])){
                return true;
            }else{
                window.add(nums[i]);
            }
        }
        for(int i = k; i < nums.length; i++){
            if(window.contains(nums[i])){
                return true;
            }else{
                window.add(nums[i]);
                window.remove(nums[i - k]);
            }
        }
        return false;
    }
}