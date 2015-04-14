package leetcode.house_robber;

public class Solution {
    public int rob(int[] num) {
        int rob = 0, notrob = 0;
        for(int i = 0; i < num.length; i++){
            int n_notrob = Math.max(rob, notrob);
            int n_rob = notrob + num[i];
            rob = n_rob;
            notrob = n_notrob;
        }
        return Math.max(rob, notrob);
    }
}
