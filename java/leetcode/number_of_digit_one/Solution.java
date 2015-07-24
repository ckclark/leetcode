package leetcode.number_of_digit_one;

public class Solution {
    public int countDigitOne(int n) {
        if(n <= 0) return 0;
        int ans = n / 10;
        for(int i = n; i >= n / 10 * 10; i--){
            int tmp = i;
            while(tmp > 0){
                if(tmp % 10 == 1) ans++;
                tmp /= 10;
            }
        }
        return ans + countDigitOne(n / 10 - 1) * 10;
    }
}
