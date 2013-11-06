package leetcode.count_and_say;

import java.util.ArrayList;

public class Solution {
    public String countAndSay(int n) {
    	if(n == 0) return "";
    	ArrayList<Integer> cas = new ArrayList<Integer>();
    	ArrayList<Integer> next = new ArrayList<Integer>();
    	cas.add(1);
    	while(--n > 0){
    		int cnt = 0;
    		for(int i = 0; i < cas.size(); i += cnt){
    			int c = cas.get(i);
    			cnt = 1;
    			if(i + 1 < cas.size()){
    				if(cas.get(i + 1) == c){
    					cnt++;
    					if(i + 2 < cas.size()){
    						if(cas.get(i + 2) == c){
    							cnt++;
    						}
    					}
    				}
    			}
    			next.add(cnt);
    			next.add(c);
    		}
    		cas.clear();
    		cas = next;
    		next = new ArrayList<Integer>();
    	}
    	StringBuilder sb = new StringBuilder();
    	for(int c : cas){
    		sb.append(c);
    	}
    	return sb.toString();
    }
    
    public static void main(String[] args){
    	for(int i = 0; i < 30; i++){
    		System.err.println(new Solution().countAndSay(i));
    	}
    }
}
