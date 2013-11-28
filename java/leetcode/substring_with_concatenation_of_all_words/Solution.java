package leetcode.substring_with_concatenation_of_all_words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	public static class MutableInt{
		private int val;
		public MutableInt(int v){
			this.val = v;
		}
		public void increment(){
			this.val++;
		}
		public void decrement(){
			this.val--;
		}
		public int get(){
			return this.val;
		}
	}
	
    public ArrayList<Integer> findSubstring(String S, String[] L) {
    	ArrayList<Integer> ans = new ArrayList<Integer>();
    	if(L.length == 0) return ans;
    	int len = L[0].length();
    	int size = L.length;
    	for(int i = 0; i < len; i++){
    		Map<String, MutableInt> remaining = new HashMap<String, MutableInt>();
    		for(String s : L){
    			MutableInt mi = remaining.get(s);
    			if(mi == null){
    				mi = new MutableInt(0);
    				remaining.put(s, mi);
    			}
    			mi.increment();
    		}
    		
    		int head = i;
    		int zeroes = 0;
    		for(int curr = i; head + size * len <= S.length(); curr += len){
        		if(curr > head){
        			String substr = S.substring(curr - len, curr);
        			MutableInt mi = remaining.get(substr);
        			if(mi == null){
        				while(head < curr - len){
        					remaining.get(S.substring(head, head + len)).increment();
        					head += len;
        				}
        				head = curr;
        				zeroes = 0;
        			}else{
        				mi.decrement();
        				if(mi.get() == 0){
        					zeroes++;
        				}else if(mi.get() == -1){
        					zeroes--;
        				}
        				if(curr - head == len * size){
        					if(zeroes == remaining.size()){
	        					ans.add(head);
	        					remaining.get(S.substring(head, head + len)).increment();
	        					head += len;
	        					zeroes--;
        					}else{
        						MutableInt mi2 = remaining.get(S.substring(head, head + len));
        						mi2.increment();
        						if(mi2.get() == 0){
        							zeroes++;
        						}else if(mi2.get() == 1){
        							zeroes--;
        						}
        						head += len;
        					}
        				}
        			}
        		}
    		}
    	}
    	return ans;
    }
    
    public static void main(String[] args){
    	String[] L = new String[]{"a", "b", "a"};
    	String S = "abababab";
    	for(int x : new Solution().findSubstring(S, L)){
    		System.err.println("pos:" + x);
    		System.err.println(S.substring(x, x + L.length * L[0].length()));
    	}
    }
}
