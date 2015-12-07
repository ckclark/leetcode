package leetcode.super_ugly_number;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    private static class Ugly implements Comparable<Ugly>{
        public static int[] ugly_numbers = new int[1000000];
        public static int cnt = 1;
        public int prime;
        public int pivot;
        
        static {
            ugly_numbers[0] = 1;
        }
        
        public static void reset(){
            cnt = 1;
        }
        
        public static void addNextUgly(int ugly){
            ugly_numbers[cnt++] = ugly;
        }
        
        public static int lastUgly(){
            return ugly_numbers[cnt - 1];
        }
        
        public Ugly(int prime, int pivot){
            this.prime = prime;
            this.pivot = pivot;
        }
        
        @Override
        public int compareTo(Ugly o) {
            int v1 = ugly_numbers[pivot] * prime;
            int v2 = ugly_numbers[o.pivot] * o.prime;
            if(v1 > v2) return 1;
            else if(v1 < v2) return -1;
            return 0;
        }
        
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        Ugly.reset();
        List<Ugly> items = new ArrayList<Ugly>();
        for(int p : primes){
            items.add(new Ugly(p, 0));
        }
        PriorityQueue<Ugly> pq = new PriorityQueue<Ugly>(items);
        for(int i = 0; i < n - 1; i++){
            Ugly smallest = pq.remove();
            int nxt_ugly = smallest.prime * Ugly.ugly_numbers[smallest.pivot];
            Ugly.addNextUgly(nxt_ugly);
            smallest.pivot++;
            pq.offer(smallest);
            while(true){
                Ugly test = pq.peek();
                if(nxt_ugly == test.prime * Ugly.ugly_numbers[test.pivot]){
                    test = pq.remove();
                    test.pivot++;
                    pq.offer(test);
                }else{
                    break;
                }
            }
        }
        return Ugly.lastUgly();
    }
}