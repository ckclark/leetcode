package leetcode.perfect_squares;

import java.util.ArrayList;

public class Solution {
    private ArrayList<Integer> table = new ArrayList<Integer>();
    public Solution(){
        table.add(0);
    }
    public int numSquares(int n) {
        while(table.size() <= n){
            int cur = table.size();
            int m = 4;
            for(int i = 1; i <= cur / i; i++){
                int t = table.get(cur - i * i) + 1;
                m = Math.min(t, m);
            }
            table.add(m);
        }
        return table.get(n);
    }
}
