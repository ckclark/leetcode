package leetcode.gas_station;


public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas.length == 0)
			return -1;
		int N = gas.length;
		int min = 0, mini = 0;
		int cur = 0;
		for(int i = 0; i < N; i++){
			if(cur < min){
				min = cur;
				mini = i;
			}
			int remain = cur + gas[i] - cost[i];
			cur = remain;
		}
		if(cur < 0) return -1;
		return mini;
	}

	public static void main(String[] args) {
		int[] gas = new int[10000]; // 3897~10000, 1~3896
		int[] cost = new int[10000]; //3311~10000, 1~3310
		for(int i = 0; i < 10000; i++){
			gas[i] = (3896 + i) % 10000 + 1;
			cost[i] = (3310 + i) % 10000 + 1;
		}
		System.err.println(new Solution().canCompleteCircuit(gas, cost));
		System.err.println(new Solution().canCompleteCircuit(new int[]{1, 2}, new int[]{2, 1}));
	}
}
