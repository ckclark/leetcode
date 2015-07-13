package leetcode.majority_element_ii;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return ans;
        int counter1 = 0;
        int candidate1 = 0;
        int counter2 = 0;
        int candidate2 = 1;
        for(int x : nums){
            if(candidate1 == x){
                counter1++;
            }else if(candidate2 == x){
                counter2++;
            }else if(counter1 == 0){
                counter1 = 1;
                candidate1 = x;
            }else if(counter2 == 0){
                counter2 = 1;
                candidate2 = x;
            }else{
                counter2--;
                counter1--;
            }
        }
        counter1 = 0;
        counter2 = 0;
        for(int x : nums){
            if(x == candidate1){
                counter1++;
            }else if(x == candidate2){
                counter2++;
            }
        }
        if(counter1 > nums.length / 3){
            ans.add(candidate1);
        }
        if(counter2 > nums.length / 3){
            ans.add(candidate2);
        }
        return ans;
    }
}
