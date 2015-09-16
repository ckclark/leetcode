package leetcode.h_index;

import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        int ans = 0;
        int size = citations.length;
        for(int i = 1; i <= size; i++){
            if(citations[size - i] >= i){
                if(i < size){
                    if(citations[size - i - 1] <= i){
                        ans = i;
                    }
                }else{
                    ans = i;
                }
            }
        }
        return ans;
    }
}
