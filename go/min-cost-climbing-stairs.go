package leetcode

func minCostClimbingStairs(cost []int) int {
	size := len(cost)
	prev2, prev1, prev0 := 0, 0, 0
	for i := 2; i <= size; i++ {
		n1, n2 := prev2+cost[i-2], prev1+cost[i-1]
		if n1 > n2 {
			prev0 = n2
		} else {
			prev0 = n1
		}
		prev2, prev1 = prev1, prev0
	}
	return prev0
}
