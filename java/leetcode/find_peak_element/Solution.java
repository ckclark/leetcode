package leetcode.find_peak_element;

public class Solution {
    public int findPeakElement(int[] num) {
    	if(num == null) return -1;
        int len = num.length;
        if(len == 0) return -1;
        if(len == 1) return 0;
        for(int i = 0; i < len; i++){
        	if(i == 0){
        		if(num[i] > num[i + 1]){
        			return 0;
        		}
        	}else if(i == len - 1){
        		if(num[i] > num[i - 1]){
        			return i;
        		}
        	}else{
        		if(num[i - 1] < num[i] && num[i] > num[i + 1]){
        			return i;
        		}
        	}
        }
        return -1;
    }
}
