package leetcode.contains_duplicate_iii;

import java.util.ArrayList;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k == 0) return false;
        ArrayList<Integer> window = new ArrayList<Integer>(k);
        if(nums == null || nums.length == 0) return false;
        window.add(nums[0]);
        int L, U;
        for(int i = 1; i < nums.length; i++){
            L = -1;
            U = window.size();
            while(L + 1 < U){
                int mid = L + (U - L) / 2;
                if(window.get(mid) > nums[i]){
                    U = mid;
                }else{
                    L = mid;
                }
            }
            if(L >= 0 && (long)nums[i] - window.get(L) <= (long)t) return true;
            if(U < window.size() && (long)window.get(U) - nums[i] <= (long)t) return true;
            window.add(U, nums[i]);
            if(i >= k){
                L = -1;
                U = window.size();
                while(L + 1 < U){
                    int mid = L + (U - L) / 2;
                    if(window.get(mid) > nums[i - k]){
                        U = mid;
                    }else{
                        L = mid;
                    }
                }
                window.remove(L);
            }
        }
        return false;
    }
}
