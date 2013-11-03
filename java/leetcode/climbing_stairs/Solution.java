package leetcode.climbing_stairs;

public class Solution {
    public int climbStairs(int n) {
        int a = 1, b = 1;
        while(n > 0){
        	int tmp = a;
        	a = a + b;
        	b = tmp;
        	n--;
        }
        return b;
    }
}
