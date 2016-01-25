package leetcode.power_of_three;

public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n < 0){
            return false;
        }else{
            int t = (int)(Math.log(n + 1) / Math.log(3));
            return (int)Math.pow(3, t) == n;
        }
    }
}
