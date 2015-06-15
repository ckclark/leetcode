package leetcode.contains_duplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int x : nums){
            set.add(x);
        }
        return set.size() != nums.length;
    }
}
