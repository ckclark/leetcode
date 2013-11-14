package leetcode.palindrome_number;

public class Solution {
    public boolean isPalindrome(int x) {
    	if(x < 0) return false;
    	if(x == 0) return true;
    	int U = 1, L = 1;
    	for(int i = 1; x / 10 >= i; i *= 10){
    		U = i * 10;
    	}
    	while(L < U && (x / U) % 10 == (x / L) % 10){
    		L *= 10;
    		U /= 10;
    	}
    	return L >= U;
    }
    
    public static void main(String[] args){
    	System.err.println(new Solution().isPalindrome(2147447413));
    }
}
