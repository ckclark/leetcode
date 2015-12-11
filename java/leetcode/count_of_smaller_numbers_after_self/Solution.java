package leetcode.count_of_smaller_numbers_after_self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public List<int[]> segment_tree;
    
    public void deduceRemain(int idx){
        for(int[] l : segment_tree){
            if(idx < l.length){
                l[idx]--;
            }
            idx >>= 1;
        }
    }

    public int countRemainFirstN(int n){
        int ans = 0;
        for(int[] l : segment_tree){
            if(n == 0){
                break;
            }
            if((n & 1) != 0){
                ans += l[n - 1];
            }
            n >>= 1;
        }
        return ans;
    }

    public List<Integer> countSmaller(int[] nums) {
        int length = nums.length;
        List<Integer> ans = new ArrayList<Integer>(length);
        int[] ans_array = new int[length];
        segment_tree = new ArrayList<int[]>();
        int[] first = new int[length];
        for(int i = 0; i < length; i++){
            first[i] = 1;
        }
        segment_tree.add(first);
        int[] prev = first;
        for(int t = length / 2; t > 0; t /= 2){
            int[] next = new int[t];
            segment_tree.add(next);
            for(int i = 0; i < t; i++){
                next[i] = prev[i * 2] + prev[i * 2 + 1];
            }
            prev = next;
        }
        int[][] order = new int[length][];
        for(int i = 0; i < length; i++){
            int[] item = new int[]{i, nums[i]};
            order[i] = item;
        }
        Arrays.sort(order, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] > o2[1]){
                    return -1;
                }else if(o1[1] < o2[1]){
                    return 1; 
                }else{
                    if(o1[0] > o2[0]){
                        return -1;
                    }else if(o1[0] < o2[0]){
                        return 1;
                    }else{
                        throw new RuntimeException("not gonna happen");
                    }
                }
            }
        });;
        for(int[] item : order){
            int idx = item[0];
            ans_array[idx] = countRemainFirstN(length) - countRemainFirstN(idx + 1); 
            deduceRemain(idx);
        }
        for(int x: ans_array){
            ans.add(x);
        }
        return ans;
    }
}
