package leetcode.maximum_product_of_word_lengths;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maxProduct(String[] words) {
        int size = words.length;
        int[] length = new int[size];
        int[] bitval = new int[size];
        Arrays.sort(words, new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                if(s1.length() > s2.length()){
                    return -1;
                }else if(s1.length() < s2.length()){
                    return 1;
                }
                return 0;
            }
            
        });

        for(int i = 0; i < size; i++){
            String word = words[i];
            int val = 0, l = word.length();
            length[i] = l;
            for(char c : word.toCharArray()){
                val |= (1 << (c - 'a'));
            }
            bitval[i] = val;
        }
        int max = 0;
        for(int i = 0; i < size; i++){
            if(length[i] * length[i] < max) break;
            for(int j = i + 1; j < size; j++){
                if((bitval[i] & bitval[j]) == 0){
                    max = Math.max(length[i] * length[j], max);
                }
            }
        }
        return max;
    }
}
