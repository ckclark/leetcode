package leetcode.h_index_ii;

public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int size = citations.length;
        int U = size, L = -1;
        while(L + 1 < U){
            int mid = L + (U - L) / 2;
            if(citations[mid] >= size - mid){
                U = mid;
            }else{
                L = mid;
            }
        }
        return size - U;
    }
}