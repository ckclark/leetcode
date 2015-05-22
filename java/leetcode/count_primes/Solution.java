package leetcode.count_primes;


public class Solution {
    public int countPrimes(int n) {
        boolean[] notprime = new boolean[n];
        int ans = 0;
        for(int i = 2; i < n; i++){
            if(!notprime[i]){
                ans++;
                if(n / i >= i){
                    for(int j = i * i; j < n; j += i){
                        notprime[j] = true;
                    }
                }
            }
        }
        return ans;
    }
}