package leetcode.two_sum;

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i = 0; i < numbers.length; i++){
    		Integer pos = map.get(target - numbers[i]);
    		if(pos != null){
    			return new int[]{pos + 1, i + 1};
    		}else{
    			map.put(numbers[i], i);
    		}
    	}
    	return null;
    }
    
    public static void main(String[] args){
    	int[] ans = new Solution().twoSum(new int[]{6, 1, 999, 2, 5}, 3);;
    	System.err.println(ans[0] + ", " + ans[1]);
    }
}
