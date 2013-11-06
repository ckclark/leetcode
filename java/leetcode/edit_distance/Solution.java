package leetcode.edit_distance;

public class Solution {
    public int minDistance(String word1, String word2) {
    	char[] char1 = word1.toCharArray();
    	char[] char2 = word2.toCharArray();
    	int[][] table = new int[char1.length + 1][char2.length + 1];
    	for(int i = 0; i < char1.length + 1; i++){
    		for(int j = 0; j < char2.length + 1; j++){
    			if(i == 0){
    				if(j == 0){
    					table[i][j] = 0;
    				}else{
    					table[i][j] = table[i][j - 1] + 1; 
    				}
    			}else{
    				if(j == 0){
    					table[i][j] = table[i - 1][j] + 1;
    				}else{
    					if(char1[i - 1] == char2[j - 1]){
    						table[i][j] = table[i - 1][j - 1];
    					}else{
    						int min = table[i - 1][j - 1] + 1;
    						if(min > table[i - 1][j] + 1) min = table[i - 1][j] + 1;
    						if(min > table[i][j - 1] + 1) min = table[i][j - 1] + 1;
    						table[i][j] = min;
    					}
    				}
    			}
    		}
    	}
    	return table[char1.length][char2.length];
    }
    
    public static void main(String[] args){
    	System.err.println(new Solution().minDistance("ahello", "hello"));
    }
}
