package leetcode.best_time_to_buy_and_sell_stock_ii;

public class Solution {
	public int maxProfit(int[] prices) {
        int buy = 0;
        int profit = 0;
        for(int i = 1; i <= prices.length; i++){
            if(i == prices.length || prices[i] < prices[i - 1]){
                profit += prices[i - 1] - prices[buy];
                buy = i;
            }
        }
        return profit;
    }
	
	public static void main(String[] args){
		Solution sol = new Solution();
		System.err.println("" + sol.maxProfit(new int[]{3,1,4,1,5,9,2,6,5,3,5,8,9,7,9,3,2,3,8,4,6}));
	}
}
