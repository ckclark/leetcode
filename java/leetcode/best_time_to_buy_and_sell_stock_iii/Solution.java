package leetcode.best_time_to_buy_and_sell_stock_iii;

import java.util.Random;

public class Solution {
	public int maxProfit(int[] prices) {
		if(prices.length == 0) return 0;
		int profit1 = 0, min0 = prices[0], min1 = prices[0];
		int max0 = prices[0];
		int ret = 0;
		for(int i = 1; i < prices.length; i++){

			if(prices[i] - min1 + profit1 > ret){
				ret = prices[i] - min1 + profit1;
			}

			if(profit1 < max0 - min0 && prices[i] - min1 + profit1 < max0 - min0){
				profit1 = max0 - min0;
				min1 = prices[i];
			}

			if(prices[i] < min1){
				min1 = prices[i];
			}

			if(prices[i] < min0){
				min0 = prices[i];
				max0 = prices[i];
			}

			if(max0 < prices[i]){
				max0 = prices[i];
			}
//			System.err.println("min0 = " + min0 + ", max0 = " + max0);
//			System.err.println("min1 = " + min1 + ", profit1 = " + profit1);
//			System.err.println("ret = " + ret);
//			System.err.println("");
		}
		return ret;
    }
	
	public int maxProfit2(int[] prices){
		if(prices.length <= 1) return 0;
		int[] maxEndWith = new int[prices.length];
		int lowest = prices[0];
		int maxprofit = 0;
		maxEndWith[0] = 0;
		for(int i = 1; i < prices.length; i++){
			int profit = prices[i] - lowest;
			if(profit > maxprofit){
				maxprofit = profit;
			}
			maxEndWith[i] = maxprofit;
			if(prices[i] < lowest) lowest = prices[i];
		}
		int ret = maxEndWith[prices.length - 1];
		int highest = prices[prices.length - 1];
		maxprofit = 0;
		for(int i = prices.length - 2; i >= 0; i--){
			int profit = highest - prices[i];
			if(profit > maxprofit) maxprofit = profit;
			int finalprofit = maxprofit + maxEndWith[i];
			if(finalprofit > ret) ret = finalprofit;
			if(prices[i] > highest) highest = prices[i];
		}
		return ret;
	}
	
	public static final int N = 20; 
	public static int[] ary = new int[N];
	public static boolean[] visit = new boolean[N];
	
	public static void dfs(int depth){
		if(depth == N){
			int sol1 = new Solution().maxProfit(ary);
			int sol2 = new Solution().maxProfit2(ary);
			if(sol1 != sol2){
				for(int i = 0; i < N; i++){
					System.err.print(ary[i] + ", ");
				}
				System.err.println("");
				System.err.println("sol1: " + sol1 + ", sol2: " + sol2);
			}else{
//				System.err.println("sol:" + sol1);
			}
		}else{
			for(int i = 0; i < N; i++){
				if(!visit[i]){
					ary[depth] = i;
//					visit[i] = true;
					dfs(depth + 1);
					visit[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args){
		
//		System.err.println("" + new Solution().maxProfit(new int[]{4,7,2,1,11})); // 13
//		System.err.println("" + new Solution().maxProfit(new int[]{3,1,4,1,5,9,2,6,5,3,5,8,9,7,9,3,2,3,8,4,6})); // 15
//		System.err.println("" + new Solution().maxProfit(new int[]{5, 9, 4, 7, 3, 7})); //
		Random r = new Random();
		for(int _ = 0; _ < 1000000; _++){
			for(int j = 0; j < ary.length; j++){
				ary[j] = r.nextInt(100);
			}
			int sol1 = new Solution().maxProfit(ary);
			int sol2 = new Solution().maxProfit2(ary);
			if(sol1 != sol2){
				for(int i = 0; i < N; i++){
					System.err.print(ary[i] + ", ");
				}
				System.err.println("");
				System.err.println("sol1: " + sol1 + ", sol2: " + sol2);
			}else{
//				System.err.println("sol:" + sol1);
			}

		}
//		dfs(0);
		System.err.println("done");
//		System.err.println("" + new Solution().maxProfit(new int[]{0,1,0,1}));
	}
}
