package leetcode.majority_element;


public class Solution {
    public int majorityElement(int[] num) {
        int candidate = 0, counter = 0;
        for(int x : num){
            if(counter == 0){
                candidate = x;
                counter = 1;
            }else{
                if(candidate == x){
                    counter++;
                }else{
                    counter--;
                }
            }
        }
        return candidate;
    }
}
