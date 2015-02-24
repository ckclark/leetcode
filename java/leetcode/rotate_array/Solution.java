package leetcode.rotate_array;

public class Solution {
    int gcd(int a, int b){
        while(b != 0){
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) return;
        int length = nums.length;
        k = (k % length + length) % length;
        int g = gcd(length, k);
        for(int i = 0; i < g; i++){
            int tmp = nums[i];
            int cur = i;
            for(int j = 0; j < length / g - 1; j++){
                nums[cur] = nums[(cur - k + length) % length];
                cur = (cur - k + length) % length;
            }
            nums[cur] = tmp;
        }
    }
    
    public static void main(String[] args){
        int[] ary = new int[]{1, 2, 3, 4};
        new Solution().rotate(ary, 4);
        for(int x : ary){
            System.err.print(x + " ");
        }
        System.err.println("");
    }
}