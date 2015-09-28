package leetcode.find_the_duplicate_number;

public class Solution {
    public int findDuplicate(int[] nums) {
        int tortoise = 0, hare = 0;
        while(true){
        	tortoise = nums[tortoise];
        	hare = nums[nums[hare]];
        	if(tortoise == hare)
        		break;
        }
        int find = 0;
        while(find != tortoise){
        	find = nums[find];
        	tortoise = nums[tortoise];
        }
        return find;
    }
}
