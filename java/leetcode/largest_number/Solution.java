package leetcode.largest_number;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String largestNumber(int[] num) {
        if(num == null || num.length == 0) return "";
        int length = num.length;
        String[] num_str = new String[length];
        for(int i = 0; i < length; i++){
            num_str[i] = String.valueOf(num[i]);
        }
        Arrays.sort(num_str, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return -(o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder ret = new StringBuilder();
        for(String str : num_str){
            ret.append(str);
        }
        String r = ret.toString().replaceAll("^0+", "");
        if(r.length() == 0){
            return "0";
        }else{
            return r;
        }
    }
    
    public static void main(String[] args){
        System.err.println(new Solution().largestNumber(new int[]{ 0, 0, 0, 1}));
    }
}
