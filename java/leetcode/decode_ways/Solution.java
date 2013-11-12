package leetcode.decode_ways;

public class Solution {
    public int numDecodings(String s) {
    	char[] chars = s.toCharArray();
    	int lens = chars.length;
    	if(lens == 0) return 0;
    	char prev = 0;
    	int cur_end = 1, cur_prev = 0;
    	for(int i = 0; i < lens; i++){
    		int next_end = 0, next_prev = 0;
    		next_prev = cur_end;
    		if(chars[i] == '0'){
    			if(prev == '1' || prev == '2'){
    				next_end += cur_prev;
    			}else{
    				next_end = 0;
    			}
    		}else{
    			next_end = cur_end; // 1 digit ends at char[i]
    			if(prev == '2'){
    				if(chars[i] >= '1' && chars[i] <= '6'){
    					next_end += cur_prev; // 2 digit '2x' ends at char[i]
    				}
    			}else if(prev == '1'){
    				next_end += cur_prev;
    			}
    		}
    		prev = chars[i];
    		cur_end = next_end;
    		cur_prev = next_prev;
    	}
    	return cur_end;
    }
    
    public static void main(String[] args){
    	System.err.println(new Solution().numDecodings(""));
    }
}
