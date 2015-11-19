package leetcode.range_sum_query_mutable;

import java.util.ArrayList;

public class NumArray {
    ArrayList<int[]> segtree = new ArrayList<int[]>();
    public NumArray(int[] nums) {
        segtree.add(nums);
        while(segtree.get(segtree.size() - 1).length > 1){
            int[] prev = segtree.get(segtree.size() - 1);
            int[] next = new int[prev.length / 2];
            for(int i = 0; i < prev.length / 2; i++){
                next[i] = prev[i * 2] + prev[i * 2 + 1];
            }
            segtree.add(next);
        }
    }

    void update(int i, int val) {
        int diff = segtree.get(0)[i] - val;
        if(diff != 0){
            for(int[] l : segtree){
                if(l.length > i){
                    l[i] -= diff;
                    i >>= 1;
                }else{
                    break;
                }
            }
        }
    }

    public int sumRange(int i, int j) {
        return subSumRange(j + 1) - subSumRange(i);
    }

    private int subSumRange(int n) {
        int ans = 0;
        int i = 0;
        while(n > 0){
            if((n & 1) != 0){
                ans += segtree.get(i)[n - 1];
            }
            n >>= 1;
            i += 1;
        }
        return ans;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);