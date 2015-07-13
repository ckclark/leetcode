package leetcode.summary_ranges;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<String>();
        if(nums == null || nums.length == 0) return ans;
        int from = nums[0], cur = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == cur + 1){
                cur = nums[i];
            }else{
                if(from == cur){
                    ans.add(Integer.toString(cur));
                }else{
                    ans.add(from + "->" + cur);
                }
                from = cur = nums[i];
            }
        }
        if(from == cur){
            ans.add(Integer.toString(cur));
        }else{
            ans.add(from + "->" + cur);
        }
        return ans;
    }
}
