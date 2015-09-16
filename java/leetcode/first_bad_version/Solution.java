package leetcode.first_bad_version;

import common.VersionControl;

/* The isBadVersion API is defined in the parent class VersionControl.
boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    // tricky case n = 2147483647, first bad version = 2147483647
    // so we cannot use L = -1, U = n + 1 to binary search.
    public int firstBadVersion(int n) {
        int L = 0, U = n;
        if(isBadVersion(0)) return 0;
        while(L + 1 < U){
            int mid = L + (U - L) / 2;
            if(isBadVersion(mid)){
                U = mid;
            }else{
                L = mid;
            }
        }
        return U;
    }
}