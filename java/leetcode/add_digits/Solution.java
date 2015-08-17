package leetcode.add_digits;

public class Solution {
    public int addDigits(int num) {
        if(num == 0) return 0;
        return 9 - (9 - (num % 9)) % 9;
    }
}
