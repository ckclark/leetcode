package leetcode.best_time_to_buy_and_sell_stock_with_cooldown;

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2)
            return 0;
        int sell = 0, sold = 0, buy = -prices[0];

        for(int price : prices){
            int next_sell = price + buy;
            int next_sold = Math.max(sold, sell);
            int next_buy = Math.max(sold - price, buy);
            sell = next_sell;
            sold = next_sold;
            buy = next_buy;
        }
        return Math.max(sell, sold);
    }
}