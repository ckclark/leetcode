package leetcode.best_time_to_buy_and_sell_stock;

public class Solution {
	public int maxProfit(int[] prices) {
		int ret = 0;
		if(prices.length == 0) return 0;
		int min = prices[0], max = prices[0];
        for(int x : prices){
        	if(min > x){
        		min = x;
        		max = x;
        	}
        	if(max < x){
        		max = x;
        	}
        	if(max - min > ret){
        		ret = max - min;
        	}
        }
        return ret;
    }
}
